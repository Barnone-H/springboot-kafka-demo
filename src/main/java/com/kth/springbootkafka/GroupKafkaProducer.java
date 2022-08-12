/**
 * Huihe.com Inc.
 * Copyright (c) 2022-2020 All Rights Reserved.
 */
package com.kth.springbootkafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: tianhui.ke
 * @version $Id: GroupKafkaProducer.java, v0.1 2022/8/11  1:10 tianhui.ke
 */
@RestController
public class GroupKafkaProducer {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/kafka/test/{msg}")
    public void sendMessage(@PathVariable("msg") String msg) {
        kafkaTemplate.send("test", msg);
    }
}
