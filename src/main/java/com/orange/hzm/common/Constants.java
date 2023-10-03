package com.orange.hzm.common;

public interface Constants {
    String CODE_200 = "200"; //成功
    String CODE_401 = "401";  // 权限不足
    String CODE_400 = "400";  // 参数错误
    String CODE_500 = "500"; // 系统错误
    String CODE_600 = "600"; // 其他业务异常

    public static final String HTTP_RESPONSE_CODE_PARAM_ERROR = "202";
    public static final String HTTP_RESPONSE_CODE_USER_NOT_EXIST = "402";
    public static final String HTTP_RESPONSE_CODE_USER_LOGIN_ERROR = "403";
    public static final String HTTP_RESPONSE_CODE_NOLOGIN = "1001";
    public static final String SESSION_USER = "USER";
    public static final String SESSION_ADMIN_USER = "ADMIN_USER";

    String DICT_TYPE_ICON = "icon";


    String FILES_KEY = "FILES_FRONT_ALL";
}
