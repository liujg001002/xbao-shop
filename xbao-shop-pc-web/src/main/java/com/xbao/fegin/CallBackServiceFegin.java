package com.xbao.fegin;

import com.xbao.api.service.CallBackService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.xbao.api.service.CallBackService;

@FeignClient("pay")
@Component
public interface CallBackServiceFegin extends CallBackService {

}
