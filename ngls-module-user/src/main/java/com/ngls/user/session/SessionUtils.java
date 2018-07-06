
package com.ngls.user.session;

import com.ngls.user.dto.UserDto;

import javax.servlet.http.HttpSession;

/**
 * Session工具类（不提供获取方法, 通过@FromSession自动注入）.
 *
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
public final class SessionUtils {

    public final static String USER_SESSION_KEY = UserInfo.class.getName();

    public static void addUserInfo(HttpSession httpSession, UserDto userDto) {
        httpSession.setAttribute(USER_SESSION_KEY, new UserInfo(userDto));
    }

    public static void removeUserInfo(HttpSession httpSession) {
        httpSession.removeAttribute(USER_SESSION_KEY);
    }

}