package com.cts.iiht.estock.stock.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cts.iiht.estock.util.AppConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafKaConsumerService {

	@KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
	public void consume(String message) {
		log.info(String.format("Message recieved -> %s", message));
	}
}