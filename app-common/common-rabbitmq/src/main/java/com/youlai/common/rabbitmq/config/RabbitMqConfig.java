package com.youlai.common.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author huawei
 * @desc
 * @email huawei_code@163.com
 * @date 2021/1/17
 */
@Configuration
@EnableTransactionManagement
@Slf4j
public class RabbitMqConfig {

//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    /**
     * 使用json序列化机制，进行消息转换
     *
     * @return
     */
    @Bean
    public MessageConverter jackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }




}
