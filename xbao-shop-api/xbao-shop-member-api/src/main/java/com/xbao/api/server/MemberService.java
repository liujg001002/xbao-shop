package com.xbao.api.server;

import java.util.Map;

import com.xbao.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/member")
public interface MemberService {

	@RequestMapping("/testRest")
	public Map<String, Object> testRest();

	@RequestMapping("/testResponse")
	public ResponseBase testResponse();

	@RequestMapping("/setRedisTest")
	public ResponseBase setRedisTest(String key, String value);

	@RequestMapping("/getRedis")
	public ResponseBase getRedis(String key);
}
