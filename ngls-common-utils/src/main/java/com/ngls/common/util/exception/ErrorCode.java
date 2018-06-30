package com.ngls.common.util.exception;

/**
 * 错误码接口
 *
 * @author Kixs
 * @version 1.0, 2018/6/30
 */
public interface ErrorCode {

    /**
     * 获取错误码.
     *
     * @return 错误码必须大于0
     */
    int getCode();

    /**
     * 获取错误信息.
     *
     * @return 错误信息
     */
    String getMessage();
}
