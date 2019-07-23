package com.xbao.api.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xbao.base.ResponseBase;
import com.xbao.entity.UserEntity;
@RequestMapping("/member")
public interface MemberService {

	// 使用userId查找用户信息
	@RequestMapping("/findUserById")
	ResponseBase findUserById(Long userId);
	@RequestMapping("/regUser")
	ResponseBase regUser( UserEntity user);
}
