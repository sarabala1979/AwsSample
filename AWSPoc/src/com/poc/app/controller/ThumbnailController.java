package com.poc.app.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poc.app.model.ThumbnailInfo;
import com.poc.service.FactoryService;
import com.poc.service.S3Service;
import com.poc.service.SQSService;

@Controller
@EnableAutoConfiguration
@RequestMapping("/thumbnail")
public class ThumbnailController {
	
	Log log = new Log4JLogger("ThumbnailController");


	public ThumbnailController() {
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void getThumbnail() {
		// TODO Auto-generated method stub
		
	}

	public void listThumbnails() {
		// TODO Auto-generated method stub
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public void putThumbnail() {
		// TODO Auto-generated method stub
		
	}

	//@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PostMapping("/{thumbId}")
	public ResponseEntity<Void> postThumbnail(@PathVariable String thumbId, 
			@RequestParam("File") MultipartFile uploadfile,
			@RequestParam ThumbnailInfo info) {
		info.name = thumbId;
		S3Service service = FactoryService.getS3Service();
		try {
			service.upload(uploadfile.getInputStream(), info);	
		}catch(Exception ex) {
			log.error("Thumbnail upload failed. " + ex.getMessage());
		}

		SQSService sqs = FactoryService.getSQSService();
		sqs.put(info);
				
		return null;
	}

	public void deleteThumbnail() {
		// TODO Auto-generated method stub
		
	}
	
	
}
