package com.foodexpress.adminservice.common.kafka.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter @Setter
@ConfigurationProperties("kafka")
public class KafkaTopicProperties {

    private String examineStore;

}
