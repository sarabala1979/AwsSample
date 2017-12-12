package com.poc.service;

import com.poc.app.model.ThumbnailInfo;

public interface SQSService {
	
	public void put(ThumbnailInfo info);

}
