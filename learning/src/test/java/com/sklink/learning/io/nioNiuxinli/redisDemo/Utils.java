package com.sklink.learning.io.nioNiuxinli.redisDemo;

import java.util.Map;

public class Utils {
    public static int LOG_LEVEL = 0;
    public static void logDebug(String str) {
        if (LOG_LEVEL >= 1) {
            System.out.println(str);
        }
    }
    public static  void logInfo(String str) {
        if (LOG_LEVEL >= 0) {
            System.out.println(str);
        }
    }
    public static byte[] addLength(String str, boolean prefixLength) {
        if (!prefixLength) {
            return str.getBytes();
        }
        byte len = (byte)str.length();
        byte[] ret = new byte[len + 1];
        ret[0] = len;
        for(int i = 0; i < len; i++) {
            ret[i+1] = (byte)str.charAt(i);
        }
        return ret;
    }

    public static byte[] processRequest(Map<String, String> cache, byte[] request, int length, boolean prefixLength) {
        if (request == null) {
            return addLength("2|bad command", prefixLength);
        }
        String req = new String(request, 0, length);
        logDebug("command: " + req);
        String[] params = req.split("\\|");

        if (params.length < 2 || params.length >3 || !(params[0].equals("get") || params[0].equals("set"))) {
            return addLength("2|bad command", prefixLength);
        }
        if (params[0].equals("get")) {
            String value = cache.get(params[1]);
            return value == null ? addLength("1|null", prefixLength) : addLength("0|" + value, prefixLength);
        }

        if (params[0].equals("set") && params.length >= 3) {
            cache.put(params[1], params[2]);
            return addLength("0|success", prefixLength);
        }else{
            return addLength("2|bad command", prefixLength);
        }
    }
}
