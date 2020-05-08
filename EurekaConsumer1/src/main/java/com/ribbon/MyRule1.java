package com.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author :huyiju
 * @date :2020-04-22 19:26
 */
public class MyRule1 extends AbstractLoadBalancerRule {


        //自定义原子类
        private AtomicInteger nextServerCyclicCounter;

        private static Logger log = LoggerFactory.getLogger(MyRule1.class);

        //构造函数为0
        public MyRule1() {
            this.nextServerCyclicCounter = new AtomicInteger(0);
        }

        public MyRule1(ILoadBalancer lb) {
            this();
            this.setLoadBalancer(lb);
        }

        public Server choose(ILoadBalancer lb, Object key) {
            if (lb == null) {
                log.warn("no load balancer");
                return null;
            } else {
                Server server = null;
                int count = 0;

                while(true) {
                    if (server == null && count++ < 10) {
                        //获取存活的服务
                        List<Server> reachableServers = lb.getReachableServers();
                        //获取所有服务
                        List<Server> allServers = lb.getAllServers();
                        int upCount = reachableServers.size();
                        int serverCount = allServers.size();
                        if (upCount != 0 && serverCount != 0) {
                            //取模 获取下标
                            int nextServerIndex = this.incrementAndGetModulo(serverCount);
                            //获取下标
                            server = (Server)allServers.get(nextServerIndex);
                            if (server == null) {
                                Thread.yield();
                            } else {
                                if (server.isAlive() && server.isReadyToServe()) {
                                    return server;
                                }

                                server = null;
                            }
                            continue;
                        }

                        log.warn("No up servers available from load balancer: " + lb);
                        return null;
                    }

                    if (count >= 10) {
                        log.warn("No available alive servers after 10 tries from load balancer: " + lb);
                    }

                    return server;
                }
            }
        }

        //核心算法 随机数

        private int incrementAndGetModulo(int modulo) {
            Random r=new Random();
            //随机数
            int current;
            //求膜
            int next;
            current = r.nextInt(10000);
            System.out.println("随机数是："+current);
            next = (current + 1) % modulo;
            System.out.println("服务节点是："+next);
            return next;
        }

        public Server choose(Object key) {
            return this.choose(this.getLoadBalancer(), key);
        }

        public void initWithNiwsConfig(IClientConfig clientConfig) {
        }
}
