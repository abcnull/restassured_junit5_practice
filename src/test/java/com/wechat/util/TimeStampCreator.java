package com.wechat.util;

import org.junit.jupiter.api.Test;

/**
 * 获取时间戳，精确到毫秒级别
 *
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/7/22 19:07
 */
public class TimeStampCreator {
    @Test
    public static String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis());
    }
}
