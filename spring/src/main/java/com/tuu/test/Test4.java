package com.tuu.test;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.hazelcast.internal.util.HashUtil;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.BitSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test4 {

    public static void main(String[] args) throws Exception {
        String s = "汉2子";
        String[] split = s.split(null);
        System.out.println(split);
    }

    public static final boolean isIntegers(String str) {
        Pattern p = Pattern.compile("[0-9]\\d*");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean isChineseChar(String str) {
        Pattern p = Pattern.compile("^[\u4e00-\u9fa5]{0,}$");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }


}
