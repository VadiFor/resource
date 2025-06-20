package com.learn.java.service;

import com.learn.java.dto.ResourceCreateRequestDto;
import com.learn.java.dto.ResourceUpdateRequestDto;
import com.learn.java.model.Resource;

import java.util.List;

public interface ResourceService {
	Resource create(ResourceCreateRequestDto resourceCreateRequestDto);
	
	Resource update(String id, ResourceUpdateRequestDto resourceUpdateRequestDto);
	
	String delete(String id);
	
	Resource getById(String id);
	
	List<Resource> getAllResources();
}
