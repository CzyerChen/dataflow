package com.dataflow.common.utils;


import org.apache.commons.lang3.StringUtils;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * String 功能类
 */
public class StringUtil {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_MOBILE_PHONE_REGEX =
            Pattern.compile("^1[0-9]{10}$", Pattern.CASE_INSENSITIVE);

    public static int str2Int(String str, int nullVal) {
        int result = nullVal;
        try {
            if(str != null && StringUtils.isNumeric(str)){
                result = Integer.parseInt(str);
            }else{
                System.out.println("Integer.parseInt() str is not a number:" + str);
            }
        } catch (Exception e) {

        }
        return result;
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        str = str.replace("-", "");
        return str;
    }

    public static boolean booleanValue(String s){
        if(s != null){
            String n = s.toLowerCase();
            if(n.startsWith("y") || n.startsWith("t") || n.startsWith("1")){
                return true;
            }
        }
        return false;
    }

    public static String convert2UTF8(String iso){
        if(iso == null){
            return iso;
        }
        try {
            return new String(iso.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            System.out.println("convert charset fail."+ e);
        }
        return iso;
    }

    // 根据Unicode编码完美的判断中文汉字和符号
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION;
    }

    // 完整的判断中文汉字和符号
    public static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (char c : ch) {
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }


    public static final char[] hexChar = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (byte aB : b) {
            sb.append(hexChar[(aB & 0xf0) >>> 4]);
            sb.append(hexChar[aB & 0x0f]);
        }
        return sb.toString();
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }



}
