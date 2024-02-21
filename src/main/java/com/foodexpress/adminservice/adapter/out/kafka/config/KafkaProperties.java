package com.foodexpress.adminservice.adapter.out.kafka.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("spring.kafka.producer")
public class KafkaProperties {

    private String bootstrapServers;

}
