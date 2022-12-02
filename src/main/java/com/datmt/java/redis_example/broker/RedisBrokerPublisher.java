package com.datmt.java.redis_example.broker;


import redis.clients.jedis.Jedis;

public class RedisBrokerPublisher {
    private static final String CHANNEL_NAME = "sample-channel";

    public static void main(String[] args) {
        // Create a new Jedis client
        Jedis jedis = new Jedis("localhost", 6379);

        // Subscribe to the channel
        jedis.publish(CHANNEL_NAME, "Hello, can you hear me?");
    }
}