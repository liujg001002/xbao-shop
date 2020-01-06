package com.xbao.rest;

/**
 * @Description: 将结果转换为封装后的对象
 * @author kwah
 * @date 2018/4/19 09:45
 */
public class ResResponse {

//	private final static String SUCCESS = "success";
//
//	public static ResResult<String> ok() {
//		return new ResResult<String>().setCode(ResCode.SUCCESS).setMsg(SUCCESS);
//	}
//
//	public static <T> ResResult<T> ok(T data) {
//		return new ResResult<T>().setCode(ResCode.SUCCESS).setMsg(SUCCESS).setData(data);
//	}
//
//	public static <T> ResResult<T> error(String message) {
//		return new ResResult<T>().setCode(ResCode.FAIL).setMsg(message);
//	}
//
//	/***
//	 * 业务处理错误返回
//	 * @param message
//	 * @param <T>
//	 * @return
//	 */
//	public static <T> ResResult<T> serverErr(String message) {
//		return new ResResult<T>().setCode(ResCode.SERVICE_ERROR).setMsg(message);
//	}
//
//	public static <T> ResResult<T> makeRsp(int code, String msg) {
//		return new ResResult<T>().setCode(code).setMsg(msg);
//	}
//
//	public static <T> ResResult<T> makeRsp(int code, String msg, T data) {
//		return new ResResult<T>().setCode(code).setMsg(msg).setData(data);
//	}


	private final static String SUCCESS = "success";

	public static ResResult<String> ok() {
		return new ResResult<String>().setCode(ResCode.SUCCESS).setMsg(ResCode.SUCCESS.getMsg());
	}

	public static <T> ResResult<T> ok(T data) {
		return new ResResult<T>().setCode(ResCode.SUCCESS).setMsg(ResCode.SUCCESS.getMsg()).setData(data);
	}

	public static <T> ResResult<T> error(String message) {
		return new ResResult<T>().setCode(ResCode.FAIL).setMsg(message);
	}

	public static <T> ResResult<T> error(ResCode resCode,T data) {
		return new ResResult<T>().setCode(resCode.getCode()).setMsg(resCode.getMsg()).setData(data);
	}

	public static <T> ResResult<T> error(ResCode resCode) {
		return new ResResult<T>().setCode(resCode.getCode()).setMsg(resCode.getMsg());
	}

	public static <T> ResResult<T> makeRsp(int code, String msg) {
		return new ResResult<T>().setCode(code).setMsg(msg);
	}

	public static <T> ResResult<T> makeRsp(int code, String msg, T data) {
		return new ResResult<T>().setCode(code).setMsg(msg).setData(data);
	}
}
