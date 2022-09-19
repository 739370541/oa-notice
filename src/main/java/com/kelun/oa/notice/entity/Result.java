/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：Wrapper.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.kelun.oa.notice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author yale
 */
@ApiModel(value="统一返回对象", description="统一返回对象")
@Data
public class Result<T> implements Serializable {

	/**
	 * 序列化标识
	 */
	private static final long serialVersionUID = 4893280118017319089L;

	/**
	 * 成功码.
	 */
	public static final int SUCCESS_CODE = 200;

	/**
	 * 成功码.
	 */
	public static final int PAY_ERROR_CODE = 800;

	/**
	 * 成功信息.
	 */
	public static final String SUCCESS_MESSAGE = "操作成功";

	/**
	 * 错误码.
	 */
	public static final int ERROR_CODE = 500;

	/**
	 * 错误信息.
	 */
	public static final String ERROR_MESSAGE = "服务器开小差了";

	/**
	 * 错误码：参数非法
	 */
	public static final int ILLEGAL_ARGUMENT_CODE = 100;

	/**
	 * 错误信息：参数非法
	 */
	public static final String ILLEGAL_ARGUMENT_MESSAGE = "参数非法";


	/**
	 * 编号.
	 */
	@ApiModelProperty("编码<200:成功，other:异常>")
	private int code;

	/**
	 * 信息.
	 */
	@ApiModelProperty("提示信息")
	private String message;

	/**
	 * 结果数据
	 */
	@ApiModelProperty("结果数据")
	private T result;

	/**
	 * Instantiates a new wrapper. default code=200
	 */
	Result() {
		this(SUCCESS_CODE, SUCCESS_MESSAGE);
	}

	/**
	 * Instantiates a new wrapper.
	 *
	 * @param code    the code
	 * @param message the message
	 */
	Result(int code, String message) {
		this(code, message, null);
	}

	/**
	 * Instantiates a new wrapper.
	 *
	 * @param code    the code
	 * @param message the message
	 * @param result  the result
	 */
	Result(int code, String message, T result) {
		super();
		this.code(code).message(message).result(result);
	}


	/**
	 * Sets the 编号 , 返回自身的引用.
	 *
	 * @param code the new 编号
	 *
	 * @return the wrapper
	 */
	private Result<T> code(int code) {
		this.setCode(code);
		return this;
	}

	/**
	 * Sets the 信息 , 返回自身的引用.
	 *
	 * @param message the new 信息
	 *
	 * @return the wrapper
	 */
	private Result<T> message(String message) {
		this.setMessage(message);
		return this;
	}

	/**
	 * Sets the 结果数据 , 返回自身的引用.
	 *
	 * @param result the new 结果数据
	 *
	 * @return the wrapper
	 */
	public Result<T> result(T result) {
		this.setResult(result);
		return this;
	}


	/**
	 * 快速创建成功结果并返回结果数据
	 * 这个方法可以返回true和false
	 * @param data
	 * @return Result
	 */
	@JsonIgnore
	public static Result success(Object data) {
		return new Result<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
	}

	/**
	 * 快速创建成功结果并返回结果数据
	 * 这个方法可以返回true和false
	 * @param data
	 * @return Result
	 */
	@JsonIgnore
	public static Result success(String massage,Object data) {
		return new Result<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
	}


	/**
	 * 快速创建成功结果
	 * @return Result
	 */
	@JsonIgnore
	public static Result success() {
		return new Result<>(SUCCESS_CODE, SUCCESS_MESSAGE, null);
	}

	/**
	 * 快速创建失败结果
	 * @return Result
	 */
	@JsonIgnore
	public static Result error() {
		return new Result<>(ERROR_CODE, ERROR_MESSAGE, null);
	}

	/**
	 * 创建自定义失败结果
	 * @return Result
	 */
	@JsonIgnore
	public static Result error(int successCode,String message) {
		return new Result<>(successCode, message, null);
	}

	/**
	 * 快速创建自定义消息返回
	 * @param message
	 * @return
	 */
	public static Result success(String message){
		return new Result<>(SUCCESS_CODE,message,null);
	}

	/**
	 * 快速创建成功结果并返回结果数据
	 * 这个方法可以返回true和false
	 * @param message
	 * @return Result
	 */
	@JsonIgnore
	public static Result failure(String message) {
		return new Result<>(ILLEGAL_ARGUMENT_CODE, message, null);
	}

	/**
	 * 快速创建布尔类型结果
	 * @param flag
	 * @return
	 */
	public static Result success(boolean flag){
		if(flag){
			return Result.success();
		}else{
			return Result.error();
		}
	}

	/**
	 * 自定义状态码、消息、以及数据返回
	 * @param successCode
	 * @param successMessage
	 * @param data
	 * @return
	 */
	public static Result success(int successCode,String successMessage,Object data){
		return new Result<>(successCode, successMessage, data);
	}

}
