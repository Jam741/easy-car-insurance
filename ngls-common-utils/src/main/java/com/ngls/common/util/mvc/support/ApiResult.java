package com.ngls.common.util.mvc.support;

import com.google.common.collect.Maps;
import com.ngls.common.util.exception.ErrorCode;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 接口调用返回结果
 *
 * @author Kixs
 * @version 1.0, 2018/6/30
 */
public class ApiResult<T> implements Serializable {

    private static final int SUCCESS_STATUS = 0;

    private static final long serialVersionUID = 6381737684108028571L;

    @ApiModelProperty("业务数据")
    private T data;

    @ApiModelProperty(hidden = true)
    private ErrorCode error;

    @ApiModelProperty("成功／失败信息")
    private String message;

    public ApiResult() {
    }

    public ApiResult(T data) {
        this.data = data;
    }

    public ApiResult(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public ApiResult(ErrorCode error, T data) {
        this.error = error;
        this.data = data;
        this.message = null;
    }

    public ApiResult(ErrorCode error, String message) {
        this.error = error;
        this.message = message;
    }

    public ApiResult(ErrorCode error, String message, T data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    @ApiModelProperty(value = "接口调用是否成功", required = true)
    public boolean isSucc() {
        return error == null;
    }

    @ApiModelProperty(value = "状态码：0表示正常，其他表示错误码", required = true)
    public int getCode() {
        return error == null ? SUCCESS_STATUS : error.getCode();
    }

    public static <T> ApiResult<T> succ() {
        return new ApiResult<T>();
    }

    public static <T> ApiResult<T> succ(T t) {
        return new ApiResult<T>(t);
    }

    public static <T> ApiResult<T> succ(T t, String message) {
        return new ApiResult<T>(t, message);
    }

    public static <T> ApiResult<T> fail(ErrorCode error) {
        return fail(error, error.getMessage(), null);
    }

    public static <T> ApiResult<T> failFormatMsg(ErrorCode error, Object ... args) {
        return fail(error, String.format(error.getMessage(), args), null);
    }

    public static <T> ApiResult<T> fail(ErrorCode error, T t) {
        return fail(error, error.getMessage(), t);
    }

    public static <T> ApiResult<T> fail(ErrorCode error, String message) {
        return fail(error, message, null);
    }

    public static <T> ApiResult<T> fail(ErrorCode error, String message, T t) {
        if (error == null) {
            throw new NullPointerException("error");
        }
        return new ApiResult<T>(error, message, t);
    }

    /**
     * 创建分页数据返回值.
     *
     * @param total 总条数
     * @param list 数据列表
     * @return ApiResult
     */
    public static <E> ApiResult buildPagination(int total, List<E> list) {
        Map<String, Object> pagination = Maps.newHashMap();
        pagination.put("total", total);
        pagination.put("list", list);
        return ApiResult.succ(pagination);
    }

    /**
     * 创建分页数据返回值.
     *
     * @param total 总条数
     * @param list 数据列表
     * @param message 返回消息
     * @return ApiResult
     */
    public static <E> ApiResult buildPagination(int total, List<E> list, String message) {
        Map<String, Object> pagination = Maps.newHashMap();
        pagination.put("total", total);
        pagination.put("list", list);
        return ApiResult.succ(pagination, message);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorCode getError() {
        return error;
    }

    public void setError(ErrorCode error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
