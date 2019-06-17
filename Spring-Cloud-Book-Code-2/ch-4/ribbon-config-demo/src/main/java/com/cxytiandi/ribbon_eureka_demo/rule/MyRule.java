package com.cxytiandi.ribbon_eureka_demo.rule;

import java.util.List;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

public class MyRule implements IRule {

	private ILoadBalancer lb;

	@Override
	public Server choose(Object key) {
		List<Server> servers = lb.getAllServers();
		for (Server server : servers) {
			System.out.println(server.getHostPort());
		}
		return servers.get(0);
	}

	@Override
	public void setLoadBalancer(ILoadBalancer lb) {
		this.lb = lb;
	}

	@Override
	public ILoadBalancer getLoadBalancer() {
		return lb;
	}

}
