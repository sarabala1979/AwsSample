package com.poc.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import com.amazonaws.services.s3.internal.S3QueryStringSigner;
import com.poc.app.model.ThumbnailInfo;
import com.poc.common.SQSUtils;

public class SQSServiceImpl implements SQSService{

	Log s3Log = new Log4JLogger("SQSService");
	final String QUEUENAME= "AWSPocThumb";
	
	public SQSServiceImpl() {
		
	}
	
	public void put(ThumbnailInfo thoumbNail) {
	
		SQSUtils.putMessage(QUEUENAME, thoumbNail);
	}
	
}
