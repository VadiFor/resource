package com.learn.java.service;

import com.learn.java.model.Resource;
import com.learn.java.model.enums.StatusResource;
import com.learn.java.model.enums.TypeResource;

import java.util.List;

public interface ResourceService {
	Resource create(String name, TypeResource type, String location, StatusResource status);
	
	Resource update(String id, String name, TypeResource type, String location, StatusResource status);
	
	String delete(String id);
	
	Resource getResource(String id);
	
	List<Resource> getAllResources();
}
