package com.damon.bgmt.utils;

import java.util.UUID;

public class DamonUtil {
    /**
     * 获得UUID值
     *
     * @param b 如果b = true，去掉横线，如果b=false,保留横线
     * @return UUID值
     */
    public static String getUUID(boolean b) {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        if (b) {
            return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        } else {
            return str;
        }
    }


    public static void main(String[] args) {

    }
}
