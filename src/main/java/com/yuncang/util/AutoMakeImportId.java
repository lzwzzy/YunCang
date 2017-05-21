package com.yuncang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lzw on 2017/5/14.
 * 生成商品ID逻辑
 */
public class AutoMakeImportId {


    private static String finalId;

    public static String MakeId(String maxImportId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String nowDate = dateFormat.format(new Date());
        if (maxImportId != null && maxImportId.contains(nowDate)) {
            String end = maxImportId.substring(8, 14);
            int endNum = Integer.parseInt(end);
            int tmpNum = 1000000 + endNum + 1;
            finalId = nowDate + subStr("" + tmpNum, 1);
            return finalId;
        } else {
            finalId = nowDate + "000001";
            return finalId;
        }
    }

    public static String subStr(String str, int start) {
        if (str == null || str.equals("") || str.length() == 0)
            return "";
        if (start < str.length()) {
            return str.substring(start);
        } else {
            return "";
        }

    }
}
