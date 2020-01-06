package com.xbao.rest;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @Description: 返回对象实体
 */
/*@ApiModel("返回类")*/
public class ResResult<T> implements Serializable {

	private static final long serialVersionUID = 3758864789222317092L;

	/*@ApiModelProperty("状态码")*/
	public int code;

	/*@ApiModelProperty("返回消息")*/
	private String msg;

	/*@ApiModelProperty("对象")*/
	private T data;

	public ResResult<T> setCode(ResCode resCode) {
		this.code = resCode.code;
		return this;
	}

	public int getCode() {
		return code;
	}

	public ResResult<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResResult<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		return data;
	}

	public ResResult<T> setData(T data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}