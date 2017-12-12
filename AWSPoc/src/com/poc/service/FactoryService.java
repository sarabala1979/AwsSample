package com.poc.service;

public class FactoryService {
	private static S3Service s3;
	private static SQSService sqs;
	
	public static S3Service getS3Service() {
		if(s3 == null) 
			s3 = new S3ServiceImpl();
		return s3;
	}
	public static SQSService getSQSService() {
		if(sqs == null) 
			sqs = new SQSServiceImpl();
		return sqs;
	}
}
