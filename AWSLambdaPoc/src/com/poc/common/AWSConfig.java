package com.poc.common;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;

public class AWSConfig {
	private static AWSConfig obj;
	private AmazonS3 s3client;
	private AmazonSQS sqs;
	private AWSConfig() {
		AWSCredentials credentials = new BasicAWSCredentials("AKIAIXC5224TGDLD5RXA", "s6/5mEjd+lzW7BP/oJFzaTD+oQeidxBmrmaaeGLN");
		sqs = new AmazonSQSClient(credentials);
		sqs.setEndpoint("https://sqs.us-west-1.amazonaws.com/930471605917");
		
	}
	
	public static AWSConfig getInstance() {
		if(obj == null) {
			obj = new AWSConfig();
		}
		return obj;
	}
	
	public  AmazonSQS getSQS() {
		return sqs;
	}
}
