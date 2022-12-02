package com.datmt.java.redis_example.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

public class RedisCache {
    private static final String CACHE_KEY = "new-bot-coin-hash";

    public static void main(String[] args) {
        // Create a new Jedis client
        simpleCaching();
    }

    private static void simpleCaching() {

        Jedis jedis = new Jedis("localhost", 6379);

        // Check if the value is in the cache
        if (jedis.exists(CACHE_KEY)) {
            // Retrieve the value from the cache
            String value = jedis.get(CACHE_KEY);
            System.out.println("Retrieved value from cache: " + value);
        } else {
            // Calculate the value
            String value = diggingBotCoin();
            // Store the value in the cache
            jedis.set(CACHE_KEY, value);
            System.out.println("Stored value in cache: " + value);
        }
    }

    private static String diggingBotCoin() {
        try {
            System.out.println("simulate long calculation");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Perform some computation to calculate the value
        return "Found the hash!!!!";
    }
}

