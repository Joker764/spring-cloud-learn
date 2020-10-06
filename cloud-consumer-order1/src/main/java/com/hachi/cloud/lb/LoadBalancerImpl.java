package com.hachi.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hachi
 * @date 10/6/20 11:15 PM
 */
@Component
public class LoadBalancerImpl implements LoadBalancer {

    private AtomicInteger nextServerCylicCounter = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.nextServerCylicCounter.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.nextServerCylicCounter.compareAndSet(current, next));
        System.out.println("getAndIncrement() next: " + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
