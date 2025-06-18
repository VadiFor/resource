package com.learn.java.service.impl;

import com.learn.java.model.Resource;
import com.learn.java.model.enums.StatusResource;
import com.learn.java.model.enums.TypeResource;
import com.learn.java.repository.ResourceRepository;
import com.learn.java.service.ResourceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {
	
	private final ResourceRepository resourceRepository;
	
	@Override
	public Resource create(String name, TypeResource type, String location, StatusResource status) {
		Resource newResource = Resource.builder()
				.name(name)
				.type(type)
				.location(location)
				.status(status)
				.build();
		resourceRepository.save(newResource);
		return newResource;
	}
	
	@Override
	public Resource update(String id, String name, TypeResource type, String location, StatusResource status) {
		Resource foundResource = getResource(id);
		if (name != null) foundResource.setName(name);
		if (type != null) foundResource.setType(type);
		if (location != null) foundResource.setLocation(location);
		if (status != null) foundResource.setStatus(status);
		Resource updatedResource = resourceRepository.save(foundResource);
		return updatedResource;
	}
	
	@Override
	public String delete(String id) {
		Resource foundResource = getResource(id);
		resourceRepository.delete(foundResource);
		return "Resource has been successfully deleted";
	}
	
	@Override
	public Resource getResource(String id) {
		return resourceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Resource with id «" + id + "» not found"));
	}
	
	@Override
	public List<Resource> getAllResources() {
		return resourceRepository.findAll();
	}
}
