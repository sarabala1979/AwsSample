package com.poc.common;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;


public class AWSConfig {
	
	private AWSConfig() {
		AWSCredentials credentials = new BasicAWSCredentials("AKIAIXC5224TGDLD5RXA", "s6/5mEjd+lzW7BP/oJFzaTD+oQeidxBmrmaaeGLN");
		AmazonS3 s3client = new AmazonS3Client(credentials);
	}
	

}
