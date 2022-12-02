package com.datmt.java.redis_example.db;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class RedisDatabaseTransaction {
    private static final String KEY_1 = "key-1";
    private static final String KEY_2 = "key-2";
    private static final String KEY_3 = "key-3";
    private static final String KEY_4 = "key-4";

    public static void main(String[] args) {
       happyTransaction();
        try {
            failedTransaction();
        } catch (Exception e) {
            //
        }
       var jedis = new Jedis("localhost", 6379) ;
        //try to get the data
        System.out.println("Key 1: " + jedis.get(KEY_1));
        System.out.println("Key 2: " + jedis.get(KEY_2));
        System.out.println("Key 3: " + jedis.get(KEY_3));
        System.out.println("Key 4: " + jedis.get(KEY_4));
    }

    private static void happyTransaction() {
        Jedis jedis = new Jedis("localhost", 6379);

        // Start a new transaction
        Transaction transaction = jedis.multi();

        // Queue up some commands to be executed in the transaction
        transaction.set(KEY_1, "value-1");
        transaction.set(KEY_2, "value-2");

        // Execute the transaction
        transaction.exec();
    }

    private static void failedTransaction () throws Exception {
        Jedis jedis = new Jedis("localhost", 6379);

        // Start a new transaction
        Transaction transaction = jedis.multi();

        // Queue up some commands to be executed in the transaction
        transaction.set(KEY_3, "value-3");
        transaction.set(KEY_4, "value-4");

        //simulate bad things happen
        if (true) {
            throw new RuntimeException("Something bad happened");
        }
        // Execute the transaction
        transaction.exec();
    }
}
