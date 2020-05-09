package com.gupao.edu.vip.lion.tools.common;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author yuanlishuai
 * @projectName lion
 * @description: TODO
 * @date 2019-06-1516:54
 */

public class Url {

    public static void main(String[] args) {
        String  url = "http://test-api.lecturer.i.vipcode.com/teacher/resume/page/list";
        String s = toBase62(10044);
        System.out.println(s);
        System.out.println();

        long l = toBase10(s);
        System.out.println(l);


        System.out.println();
        long l1 = insertRandomBitPer5Bits(999998);
        System.out.println(l1);

    }

    private static final String BASE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    //十进制转62进制
    public static String toBase62(long num) {
        StringBuilder sb = new StringBuilder();
        int targetBase = BASE.length();
        do {
            int i = (int) (num % targetBase);
            sb.append(BASE.charAt(i));
            num /= targetBase;
        } while (num > 0);

        return sb.reverse().toString();
    }

    //63进制转十进制
    public static long toBase10(String input) {
        int srcBase = BASE.length();
        long id = 0;
        String r = new StringBuilder(input).reverse().toString();

        for (int i = 0; i < r.length(); i++) {
            int charIndex = BASE.indexOf(r.charAt(i));
            id += charIndex * (long) Math.pow(srcBase, i);
        }

        return id;
    }

    /**
     *
     * @param val
     * @return
     */
    private static long insertRandomBitPer5Bits(long val) {
        long result = val;
        long high = val;
        for (int i = 0; i < 10; i++) {
            if (high == 0) {
                break;
            }
            int pos = 5 + 5 * i + i;
            high = result >> pos;
            result = ((high << 1 | RandomUtils.nextInt(0, 2)) << pos)
                    | (result & (-1L >>> (64 - pos)));
        }
        return result;
    }
}
