package com.cxytiandi.spring_cloud_gateway.filter.factory;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

/**
 * 自定义GatewayFilterFactory
 * @author yinjihuan
 *
 */
@Component
public class CheckAuthGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

	@Override
	public GatewayFilter apply(NameValueConfig config) {
		return (exchange, chain) -> {
			System.err.println("进入了CheckAuthGatewayFilterFactory" + config.getName() + "\t" + config.getValue());
			ServerHttpRequest request = exchange.getRequest().mutate()
					.build();

			return chain.filter(exchange.mutate().request(request).build());
		};
	}

}
