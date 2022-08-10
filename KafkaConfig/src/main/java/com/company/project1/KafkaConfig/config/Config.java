package com.company.project1.KafkaConfig.config;

import java.util.Properties;

public class Config {
    public static String BROKER = "localhost:9092";

    public static Properties getProducerProps() {
        Properties props = new Properties();
        props.put("bootstrap.servers", BROKER);
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

    public static Properties getConsumerProps() {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", BROKER);
        props.setProperty("group.id", "testGroup");
        //Setting auto commit off , need to commit in code
        props.setProperty("enable.auto.commit", "false");
        props.setProperty("auto.offset.reset", "earliest");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }
}
