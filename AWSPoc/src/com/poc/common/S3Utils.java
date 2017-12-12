package com.poc.common;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

public class S3Utils {

	public static Bucket getBucket(String bucketName) {
		AmazonS3 s3Client = AWSConfig.getInstance().getAmazonS3();
		List<Bucket> buckets = s3Client.listBuckets();
		Optional<Bucket> opBucket = buckets.stream().filter(b -> b.getName().equals(bucketName)).findFirst();
		return opBucket.orElse(null);
	}
	
	public static Bucket createBucket(String bucketName, Log log) {
		AmazonS3 s3Client = AWSConfig.getInstance().getAmazonS3();
		Bucket b = null;
		if(s3Client.doesBucketExist(bucketName)) {
			b = getBucket(bucketName);
		} else {
			try {
				b = s3Client.createBucket(bucketName);
			} catch (AmazonS3Exception e) {
				log.error("failed to create bucket : " + e.getErrorMessage());
			}
		}
		return b;
	}
	
	public static PutObjectResult write(String bucket, InputStream is, String filename, Log log) {
		AmazonS3 s3 = AWSConfig.getInstance().getAmazonS3();
		try {
			return s3.putObject(bucket, filename, is, null);
		} catch (AmazonServiceException e) {
			log.error("failed to upload file : " + e.getErrorMessage());
		}
		
		return null;
	}
	
}
