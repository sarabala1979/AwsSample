package com.poc.common;

public class AWSConfig {
	
	private AWSConfig() {
		AWSCredentials credentials = new BasicAWSCredentials("AKIAIXC5224TGDLD5RXA", "s6/5mEjd+lzW7BP/oJFzaTD+oQeidxBmrmaaeGLN");
		AmazonS3 s3client = new AmazonS3Client(credentials);
	}
	

}
