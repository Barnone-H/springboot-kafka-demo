/**
 * Huihe.com Inc.
 * Copyright (c) 2022-2020 All Rights Reserved.
 */
package com.kth.springbootkafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author: tianhui.ke
 * @version $Id: PartitionConsumer.java, v0.1 2022/8/11  0:44 tianhui.ke
 */
@Component
public class PartitionConsumer {
    private final Logger logger = LoggerFactory.getLogger(PartitionConsumer.class);

    //分区消费
    @KafkaListener(topics = { "kth_topic_0811_01" }, groupId = "consumer_group_kth_01", topicPattern = "0")
    public void onMessage(ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> optional = Optional.ofNullable(consumerRecord.value());
        if (optional.isPresent()) {
            Object msg = optional.get();
            logger.info("partition=0,message:[{}]", msg);
        }
    }

    @KafkaListener(topics = { "kth_topic_0811_01" }, groupId = "consumer_group_kth_02", topicPattern = "1")
    public void onMessage1(ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> optional = Optional.ofNullable(consumerRecord.value());
        if (optional.isPresent()) {
            Object msg = optional.get();
            logger.info("partition=1,message:[{}]", msg);
        }
    }
}
