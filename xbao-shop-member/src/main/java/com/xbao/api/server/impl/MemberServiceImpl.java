package com.xbao.api.server.impl;

import java.util.HashMap;
import java.util.Map;

import com.xbao.api.server.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.xbao.base.BaseController;
import com.xbao.base.BaseRedisService;
import com.xbao.base.ResponseBase;

@RestController
public class MemberServiceImpl extends BaseController implements MemberService {
	@Autowired
	private BaseRedisService baseRedisService;

	@Override
	public Map<String, Object> testRest() {
		Map<String, Object> result = new HashMap<>();
		result.put("errorCode", "200");
		result.put("errorMsg", "success");
		return result;
	}

	@Override
	public ResponseBase testResponse() {
		return setResultSuccess();
	}

	@Override
	public ResponseBase setRedisTest(String key, String value) {
		baseRedisService.setString(key, value);
		return setResultSuccess();
	}

	@Override
	public ResponseBase getRedis(String key) {
		String value = baseRedisService.getString(key);
		return setResultSuccess(value);
	}

}
