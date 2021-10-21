package com.example.demo_ibm_mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class IBMMQController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MQListener.class);

	@Value("${project.mq.queue-name}")
	private String queueName;

	@Autowired
	private JmsOperations jmsOperations;

	@GetMapping("/send/{message}")
	public String send(@PathVariable String message) {
		jmsOperations.convertAndSend(queueName, message);
		LOGGER.info("Sent Message successfully to Q1 [{}]", message);
		return "Send message successfully";
	}

	@GetMapping("/receive")
	public String retrieve() {
		try {
			String messages = jmsOperations.receiveAndConvert(queueName).toString();
			LOGGER.info("Receive Message from Q1 [{}]", messages);
			return "Received Messages";
		} catch (NullPointerException e) {
			LOGGER.error("Message Queue is Empty");
			return "Fail";
		}
	}
}
