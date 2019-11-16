package com.kq.api.kafka.consumer;

import com.kq.api.kafka.common.Constants;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * ConsumerDemo1
 *
 * @author kq
 * @date 2019-11-05
 */
public class ConsumerDemo1 {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", Constants.SERVER);
        props.put(CommonClientConfigs.CLIENT_ID_CONFIG, "consumer-1");
        // 设置消费组
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        String topic = "test";

        System.out.println("=====================================================================");

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);) {
            // 订阅topics
            consumer.subscribe(Arrays.asList(topic));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1L));
                for (ConsumerRecord<String, String> record : records)
                    System.out.printf("消费者-1：partition = %d,offset = %d, key = %s, value = %s%n", record.partition(), record.offset(), record.key(),
                            record.value());
            }
        }
    }

}
