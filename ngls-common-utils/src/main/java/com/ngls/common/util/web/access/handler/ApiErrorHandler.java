
package com.ngls.common.util.web.access.handler;

import com.ngls.common.util.mvc.support.ApiError;
import com.ngls.common.util.web.access.RejectedAccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * WEB拒绝访问时返回API调用错误的Handler.
 *
 * @author Kixs
 * @version 1.0, 2016/6/29
 */
public class ApiErrorHandler implements RejectedAccessHandler {

    private ApiError error;

    @Override
    public void rejectedAccess(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.getWriter().write(error.getJsonString());
    }

    public void setError(ApiError error) {
        this.error = error;
    }

}