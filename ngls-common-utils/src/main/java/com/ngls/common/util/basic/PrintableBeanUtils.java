
package com.ngls.common.util.basic;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * toString工具类
 *
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
public class PrintableBeanUtils {

    private PrintableBeanUtils() {
    }

    public static String toString(Object object) {
        return ToStringBuilder.reflectionToString(object, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}