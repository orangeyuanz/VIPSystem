package com.orange.hzm.utils;

/**
 * @author orange
 * @date 2023/09/30
 * 有关字符串处理的工具类。
 * 这个类中的每个方法都可以“安全”地处理<code>null</code>，而不会抛出<code>NullPointerException</code>。
 * @todo
 **/
public class StringUtil {

    /**
     * 空字符串
     */
    private static final String EMPTY_STRING = "";

    /**
     * @param str 要检查的字符串
     * @author orange
     * @date 2023/09/30
     * 判断字符串是否为空
     * @return 若为空 则返回<code>true</code>
     * <pre>
     * StringUtil.isEmpty(null)      = true
     * StringUtil.isEmpty("")        = true
     * StringUtil.isEmpty(" ")       = false
     * StringUtil.isEmpty("bob")     = false
     * StringUtil.isEmpty("  bob  ") = false
     * </pre>
     **/
    public static Boolean isEmpty(String str){
        return ((str == null) || (str.length() == 0));
    }
}
