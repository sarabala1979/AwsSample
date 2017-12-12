package com.poc.service;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import com.poc.app.model.ThumbnailInfo;
import com.poc.common.S3Utils;

public class S3ServiceImpl implements S3Service {

	static final String BUCKET_NAME = "sarabala-test-s3";
	Log s3Log = new Log4JLogger("S3ServiceImp");
	
	
	@Override
	public void upload(InputStream is, ThumbnailInfo info) {
		
		S3Utils.write(BUCKET_NAME, is, info.name, s3Log);
	}

	@Override
	public void get(String fileName, OutputStream os) {

		
	}

}
