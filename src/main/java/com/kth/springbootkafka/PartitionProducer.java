/**
 * Huihe.com Inc.
 * Copyright (c) 2022-2020 All Rights Reserved.
 */
package com.kth.springbootkafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: tianhui.ke
 * @version $Id: PartitionProducer.java, v0.1 2022/8/11  0:42 tianhui.ke
 */
//测试分区发送
@RestController
public class PartitionProducer {

    @Value("${kafka.topic.name}")
    private String                        topicName;

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    //    指定分区发送
    //    不管你key是什么，到同一个分区
    @GetMapping("/kafka/partition_send/{key}")
    public void setPartition(@PathVariable("key") String key) {
        //kafkaTemplate.send(topicName, 0, key, "key=" + key + "，msg=指定0号分区");
        kafkaTemplate.send(topicName, key);
    }

    //    指定key发送，不指定分区
    //    根据key做hash，相同的key到同一个分区
    @GetMapping("/kafka/key_send/{key}")
    public void setKey(@PathVariable("key") String key) {
        kafkaTemplate.send(topicName, key, "key=" + key + "，msg=不指定分区");
    }

}
