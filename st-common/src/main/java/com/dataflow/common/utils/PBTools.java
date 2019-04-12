package com.dataflow.common.utils;


import java.util.UUID;

/**
 * Desciption
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 10:31
 */
public class PBTools {
    private static MD5 md5 = new MD5();

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "") ;
    }

    public static String md5(String str) {
        return md5.getMD5ofStr(md5.getMD5ofStr(str));
    }

    public static String md5(byte[] bytes) {
        return md5.getMD5ofByte(bytes);
    }

}
