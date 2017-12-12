package com.poc.service;

import java.io.InputStream;
import java.io.OutputStream;

import com.poc.app.model.ThumbnailInfo;

public interface S3Service {
	public void upload(InputStream is, ThumbnailInfo info);
	public void get(String fileName, OutputStream os);
}
