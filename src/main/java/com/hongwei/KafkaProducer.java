package com.hongwei;


import java.util.Date;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

public class KafkaProducer
{

  public static void testProducer()
  {
    // 1 set the props, just need the three values
    Properties props = new Properties();
    props.put("metadata.broker.list", "localhost:9092");
    props.put("serializer.class", StringEncoder.class.getName());
    props.put("request.required.arks", "1");

    // 2 change the Java Properties to Kafka ProducerConfig class.
    ProducerConfig config = new ProducerConfig(props);

    // 3 use the configure to set up a Kafka Producer 
    Producer<String, String> producer = new Producer<String, String>(config);

    // 4 prepare the message to send to Kafka
    String msg = new Date() + " - hello world : 测试 ";
    KeyedMessage<String, String> data = new KeyedMessage<String, String>("test", msg);
    producer.send(data);
    
    // 5 send the data and close the producer
    producer.close();
    System.out.println("--> producer sended： " + msg);
  }

  public static void main(String[] args)
  {
    testProducer();
  }
}