package com.example.demo_ibm_mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MQListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(MQListener.class);

	// @JmsListener(destination = "${project.mq.queue-name}")
	// public void receiveMessage(final Message jsonMessage) throws JMSException {
	// String messageData = null;
	// if (jsonMessage instanceof TextMessage) {
	// TextMessage textMessage = (TextMessage) jsonMessage;
	// messageData = textMessage.getText();
	// LOGGER.info("Receive Message from Q1 [{}]", messageData);
	// }
	// }
}
