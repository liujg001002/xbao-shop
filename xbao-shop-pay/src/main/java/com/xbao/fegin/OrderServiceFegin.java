package com.xbao.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.xbao.api.service.OrderService;

@Component
@FeignClient("order")
public interface OrderServiceFegin extends OrderService {

}
