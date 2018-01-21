package com.fangjia.fsh.substitution.controller;

import com.fangjia.api.client.fsh.house.HouseRemoteClient;
import com.fangjia.fsh.substitution.dto.HouseInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import feign.Feign;
import feign.RequestLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fangjia.common.base.ResponseData;
import com.fangjia.fsh.substitution.service.SubstitutionService;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 房产置换API
 *
 * @author yinjihuan
 * @create 2017-10-28 14:07
 **/
@RestController
@RequestMapping("/substitution")
public class SubstitutionController {

	private Logger logger = LoggerFactory.getLogger(SubstitutionController.class);

	@Autowired
	private SubstitutionService substitutionService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HouseRemoteClient houseRemoteClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private LoadBalancerClient loadBalancer;

	@GetMapping("/choose")
	public Object chooseUrl() {
		ServiceInstance instance = loadBalancer.choose("fsh-house");
		return instance;
	}

	interface HelloRemote {
		@RequestLine("GET /house/hello")
		String hello();
	}

	@GetMapping("/callHello")
	@HystrixCommand(fallbackMethod = "defaultCallHello", commandProperties = {
			@HystrixProperty(name="execution.isolation.thread.interruptOnTimeout", value = "false")
	})
	public String callHello() {
		//return restTemplate.getForObject("http://localhost:8081/house/hello", String.class);
		String result = restTemplate.getForObject("http://fsh-house/house/hello", String.class);
		/*String result = houseRemoteClient.hello();
		System.out.println("调用结果：" + result);
		HelloRemote helloRemote = Feign.builder().target(HelloRemote.class,"http://localhost:8081");
		System.out.println("调用结果2："+helloRemote.hello());*/
		return result;
	}


	public String defaultCallHello() {
		return "fail";
	}

	/**
	 * 获取置换信息
	 * @param sid
	 * @return
	 */
	@GetMapping("/{sid}")
	public ResponseData substitutionInfo(@PathVariable("sid") Long sid, HttpServletRequest request) {
		String uid = request.getHeader("uid");
		System.err.println("authorization:"+request.getHeader("authorization"));
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			System.out.println(headers.nextElement());
		}

		System.err.println("==="+uid);
		logger.info("获取置换信息");
		return ResponseData.ok(substitutionService.getSubstitutionInfo(sid));
	}


	@GetMapping("/infos")
	public Object serviceUrl() {
		//return eurekaClient.getInstancesByVipAddress("fsh-substitution", false);
		return discoveryClient.getInstances("fsh-substitution");
	}

	@GetMapping("/data")
	public HouseInfo getData(@RequestParam("name") String name) {
		ResponseEntity<HouseInfo> responseEntity = restTemplate.getForEntity("http://localhost:8081/house/data?name="+name, HouseInfo.class);
		if(responseEntity.getStatusCodeValue() == 200) {
			return responseEntity.getBody();
		}
		return null;
		//return restTemplate.getForObject("http://localhost:8081/house/data?name="+name, HouseInfo.class);
	}

	@GetMapping("/data/{name}")
	public String getData2(@PathVariable("name") String name) {
		return restTemplate.getForObject("http://localhost:8081/house/data/{name}", String.class, name);
	}

	@GetMapping("/save")
	public Long add() {
		HouseInfo houseInfo = new HouseInfo();
		houseInfo.setCity("上海");
		houseInfo.setRegion("虹口");
		houseInfo.setName("XXX");
		Long id = restTemplate.postForObject("http://localhost:8081/house/save", houseInfo, Long.class);
		return id;
	}
}
