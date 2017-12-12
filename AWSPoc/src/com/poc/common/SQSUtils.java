package com.poc.common;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.google.gson.Gson;
import com.poc.app.model.ThumbnailInfo;

public class SQSUtils {

	public static void putMessage(String queuename, ThumbnailInfo thumnail) {
		AmazonSQS sqs = AWSConfig.getInstance().getSQS();
		Gson gson = new Gson();
		String body = gson.toJson(thumnail);
		SendMessageRequest request = new SendMessageRequest(queuename, body);
		sqs.sendMessage(request);
	}
}
