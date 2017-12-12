package com.poc.common;

import java.util.List;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

public class SQSUtil {

	public static List<Message> getMessage(String queuename) {
		AmazonSQS sqs = AWSConfig.getInstance().getSQS();
		ReceiveMessageResult msgResult = sqs.receiveMessage(queuename);
		return msgResult.getMessages();
	}
}
