package com.foodexpress.adminservice.adapter.out.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodexpress.adminservice.application.port.out.ExamineStorePort;
import com.foodexpress.adminservice.common.KafkaAdapter;
import com.foodexpress.adminservice.common.kafka.properties.KafkaTopicProperties;
import com.foodexpress.adminservice.domain.Store;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.ExecutionException;

/**
 * 상점 심사 비동기 통신
 * kafka 를 통해서 심사 결과를 전달한다.
 *
 * @author seunggu.lee
 */
@Slf4j
@KafkaAdapter
@RequiredArgsConstructor
public class ExamineStorePortAdapter implements ExamineStorePort {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final KafkaTopicProperties kafkaTopicProperties;

    @Override
    public Store examineStore(Store store, String loginUserId, String examineReason) {
        String storeJson;

        try {
            storeJson =
                objectMapper.writeValueAsString(ExamineStoreRequest.of(store.storeId(), store.storeStatus(), loginUserId, examineReason));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            kafkaTemplate.send(kafkaTopicProperties.getExamineStore(), storeJson).get();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return store;
    }

}
