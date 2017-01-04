package com.dky.common.utils;

import java.util.UUID;

/**
 * Created by wangpeng on 2017/1/4.
 */
public class DkyStringUtils {


    public static String uuidString(){
        return  UUID.randomUUID().toString().replaceAll("-", "");
    }
}
