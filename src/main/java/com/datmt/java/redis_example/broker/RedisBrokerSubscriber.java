package com.datmt.java.redis_example.broker;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisBrokerSubscriber {
    private static final String CHANNEL_NAME = "sample-channel";

    public static void main(String[] args) {
        // Create a new Jedis client
        Jedis jedis = new Jedis("localhost", 6379);

        // Subscribe to the channel
        jedis.subscribe(new MyMessageListener(), CHANNEL_NAME);
    }

    private static class MyMessageListener extends JedisPubSub {
        @Override
        public void onMessage(String channel, String message) {
            // Handle incoming message
            System.out.println("Received message: " + message);
        }
    }
}
