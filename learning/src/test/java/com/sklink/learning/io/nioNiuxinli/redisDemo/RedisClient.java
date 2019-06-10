package com.sklink.learning.io.nioNiuxinli.redisDemo;

public interface RedisClient {
    public String get(String key);
    public void set(String key, String value);
    public void close();
}
