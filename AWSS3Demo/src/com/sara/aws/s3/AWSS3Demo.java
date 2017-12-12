package com.sara.aws.s3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class AWSS3Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AWSCredentials credentials = new BasicAWSCredentials("AKIAIXC5224TGDLD5RXA", "s6/5mEjd+lzW7BP/oJFzaTD+oQeidxBmrmaaeGLN");
		AmazonS3 s3client = new AmazonS3Client(credentials);
		S3Object  s3Obj = s3client.getObject(new GetObjectRequest("sarabala-test-s3","wc.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(s3Obj.getObjectContent()));
		
		reader.lines().filter(s->s.startsWith("a")).forEach(s->System.out.println(s));
		
		
		
		for (com.amazonaws.services.s3.model.Bucket bucket : s3client.listBuckets()) {
			System.out.println(" - " + bucket.getName());
		}
		
		
	}

}
