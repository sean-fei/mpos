package com.mpos.common;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//@JsonFilter("com.wechat.common.GeneralResponse")
@ApiModel(value = "GeneralResponse", description = "通用返回对象")
public class GeneralResponse implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = -1793618628484206474L;
	/*
	 * 信息
	 */
    @ApiModelProperty(value = "信息", required = false, example = "失败原因:DB连接超时/执行成功")
    private String message;
    /*
     * 编码非200均为失败
     */
    @ApiModelProperty(value = "编码", required = true)
    private String code;
    /*
     * 数据
     */
    @ApiModelProperty(value = "数据", required = false, example = "JSON: {name:张三,age:18}")
    private Object data;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public GeneralResponse() {
    	
    }
    
    public GeneralResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public GeneralResponse withCode(String code) {
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public GeneralResponse withData(Object data) {
        this.data = data;
        return this;
    }

    /**
     *
     * 成功GeneralResponse
     *
     * @return GeneralResponse 返回GeneralResponse实例
     */
    public static GeneralResponse success() {
        return new GeneralResponse().withMessage("").withCode("200").withData(null);
    }

    /**
     *
     * 成功GeneralResponse
     *
     * @param message
     *            信息
     * @return GeneralResponse 返回GeneralResponse实例
     */
    public static GeneralResponse successWithMsg(String message) {
        return new GeneralResponse().withMessage(message).withCode("200").withData(null);
    }

    /**
     *
     * 成功GeneralResponse
     *
     * @param data
     *            数据
     * @return GeneralResponse 返回GeneralResponse实例
     */
    public static GeneralResponse success(Object data) {
        return new GeneralResponse().withMessage("").withCode("200").withData(data);
    }

    /**
     *
     * 成功GeneralResponse
     *
     * @param message
     *            信息
     * @param data
     *            数据
     * @return GeneralResponse 返回GeneralResponse实例
     */
    public static GeneralResponse success(String message, Object data) {

        return new GeneralResponse().withMessage(message).withCode("200").withData(data);
    }

    /**
     *
     * 成功GeneralResponse
     *
     * @param code
     *            编码
     * @param message
     *            信息
     * @param data
     *            数据
     * @return GeneralResponse 返回GeneralResponse实例
     */
    public static GeneralResponse success(String code, String message, Object data) {
        return new GeneralResponse().withMessage(message).withCode(code).withData(data);
    }

    /**
     *
     * 失败GeneralResponse
     *
     * @param message
     *            信息
     * @return GeneralResponse 返回GeneralResponse实例
     */
    public static GeneralResponse failure(String message) {
        return new GeneralResponse().withMessage(message).withCode("500").withData(null);
    }

    /**
     *
     * 失败GeneralResponse
     *
     * @param message
     *            信息
     * @param data
     *            数据
     * @return GeneralResponse 返回GeneralResponse实例
     */
    public static GeneralResponse failure(String message, Object data) {
        return new GeneralResponse().withMessage(message).withCode("500").withData(data);
    }

    /**
     *
     * 失败GeneralResponse
     *
     * @param code
     *            编码
     * @param message
     *            信息
     * @return GeneralResponse 返回GeneralResponse实例
     */
    public static GeneralResponse failure(String code, String message) {
        return new GeneralResponse().withMessage(message).withCode(code).withData(null);
    }

    /**
     *
     * 失败GeneralResponse
     *
     * @param code
     *            编码
     * @param message
     *            信息
     * @param data
     *            数据
     * @return GeneralResponse 返回GeneralResponse实例
     */
    public static GeneralResponse failure(String code, String message, Object data) {
        return new GeneralResponse().withMessage(message).withCode(code).withData(data);
    }

}
