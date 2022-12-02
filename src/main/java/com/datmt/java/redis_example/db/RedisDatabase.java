package com.datmt.java.redis_example.db;

import redis.clients.jedis.Jedis;

public class RedisDatabase {
    private static final String KEY = "my-password";
    private static final String MY_CAR_KEY = "my-car";

    public static void main(String[] args) {
        // Create a new Jedis client
        Jedis jedis = new Jedis("localhost", 6379);

        // Set the value of the key
        jedis.set(KEY, "123456");

        // Retrieve the value of the key
        String value = jedis.get(KEY);
        System.out.println("My password: " + value);

        jedis.del(KEY);

        //Try to get the key after deleted
        System.out.println("My password: " + jedis.get(KEY));
    }


}

