package com.cc.rd.util;

import com.google.common.io.BaseEncoding;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * @program: EncryptUtils
 * @description: 使用缓存，使用 Apache Commons Crypt
 * @author: cchen
 * @create: 2019-03-06 17:21
 */
@Slf4j
public class EncryptUtils {
    private final static String PASS = "ChenChenAPass_#$";

    private final static SecretKeySpec secretKeySpecification = new SecretKeySpec(getUTF8Bytes(PASS), "AES");

    private final static IvParameterSpec initialVector = new IvParameterSpec(getUTF8Bytes(PASS));

    /**
     * 加密
     *
     * @param plain plain text
     * @return encrypted string
     */
    public static String encrypt(String plain) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpecification, initialVector);
            byte[] bytes = cipher.doFinal(getUTF8Bytes(plain));
            return BaseEncoding.base64().encode(bytes);
        } catch (Exception e) {
            log.error("AES|ENC|N|{}", plain, e);
            return null;
        }
    }

    /**
     * 解密
     *
     * @param encoded encrypted string
     * @return plain text
     */
    public static String decrypt(String encoded) {
        byte[] bytes = BaseEncoding.base64().decode(encoded);
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpecification, initialVector);
            return new String(cipher.doFinal(bytes));
        } catch (Exception e) {
            log.error("AES|DEC|N|{}", encoded, e);
            return null;
        }
    }

    private static byte[] getUTF8Bytes(String s) {
        return s.getBytes(StandardCharsets.UTF_8);
    }
}
