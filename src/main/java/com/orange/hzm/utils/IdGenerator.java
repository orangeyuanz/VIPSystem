package com.orange.hzm.utils;


import java.sql.Time;
import java.util.Date;

/**
 * @author orange
 * @date 2023/10/02
 * 生成不同Id串
 **/
public class IdGenerator {
    public static int GenerateByTime(){
        return TimeUtil.timeStamp();
    }
}
