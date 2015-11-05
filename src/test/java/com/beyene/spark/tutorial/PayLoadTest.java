package com.beyene.spark.tutorial;


public class PayLoadTest {

    @org.junit.Test
    public void testToString() throws Exception {

        PayLoad payload = new PayLoad();
        payload.setTitle("my title");
        System.out.println(payload.toString());

    }
}