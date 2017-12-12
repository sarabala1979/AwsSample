package com.poc.app.model;

import java.util.Date;

import com.google.gson.annotations.Expose;

public class ThumbnailInfo {
	@Expose public String name;
	@Expose public int size;
	@Expose public Date modifiedDate;
	@Expose public String path;

}
