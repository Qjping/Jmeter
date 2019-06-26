package com.kafaka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 在jmeter里面测试需要把kafka的jar放进去，不需要写main方法
 */
public class kafakaProducerMsg {
    public static void main(String[]args){
        Properties properties=new Properties();

        //制度kafka配置

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"IP");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serializable.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serializable.serializableString");

        Producer produce=new KafkaProducer(properties);
        produce.send(new ProducerRecord("test","1111"));
        produce.close();

    }
}
