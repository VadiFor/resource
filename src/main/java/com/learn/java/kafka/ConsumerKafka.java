package com.learn.java.kafka;

import com.learn.java.dto.ResourceUpdateRequestDto;
import com.learn.java.model.enums.StatusResource;
import com.learn.java.service.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerKafka {
	private final ResourceService resourceService;
	
	@KafkaListener(topics = "booking.service.resource.status", groupId = "booking-consumer")
	public void listenCreate(@Payload String message) {
		log.info("Listen: " + message);
		String resourceId = message.replace("\"", "").split("-")[0];
		String statusResource = message.replace("\"", "").split("-")[1];
		resourceService.update(resourceId, ResourceUpdateRequestDto.builder()
				.status(StatusResource.valueOf(statusResource))
				.build());
	}
}
