package com.gary.ribbon.springcloudribbon.web;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

//@Component
public class MyProbabilityRandomRule implements IRule {

    ILoadBalancer balancer = new BaseLoadBalancer();

    @Override
    public Server choose(Object key) {
        System.err.println("choose=====>");
        List<Server> allServers = balancer.getAllServers();
        Random random = new Random();
        final int number = random.nextInt(10);
        if (number < 5) {
            return findServer(allServers, 8091);
        }
        return findServer(allServers, 8092);
    }

    private Server findServer(List<Server> allServers, int port) {
        for (Server server : allServers) {
            if (server.getPort() == port) {
                return server;
            }
        }
        System.out.println("NULL port=" + port);
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.balancer = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.balancer;
    }

}
