package com.gary.ribbon.springcloudribbon.web;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

public class BalancerApplication {

    public static void main(String[] args) {
        ILoadBalancer balancer = new BaseLoadBalancer();

        List<Server> servers = new ArrayList<Server>();
        servers.add(new Server("127.0.0.1", 8091));
        servers.add(new Server("127.0.0.1", 8092));
        balancer.addServers(servers);
        for (int i = 0; i < 10; i++) {
            Server choosedServer = balancer.chooseServer(null);
            System.out.println(choosedServer);
        }

    }
}
