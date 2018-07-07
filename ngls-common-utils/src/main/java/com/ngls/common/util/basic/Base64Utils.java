
package com.ngls.common.util.basic;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Base64编码&解码工具类.
 *
 * @author Kixs
 * @version 1.0, 2018/7/5
 */
public class Base64Utils {

    /**
     * Base64加密
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    /**
     * Base64解密
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }
}
