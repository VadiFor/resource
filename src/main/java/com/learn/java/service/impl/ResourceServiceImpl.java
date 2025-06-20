package com.learn.java.service.impl;

import com.learn.java.dto.ResourceCreateRequestDto;
import com.learn.java.dto.ResourceUpdateRequestDto;
import com.learn.java.mapper.ResourceMapper;
import com.learn.java.model.Resource;
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
	private final ResourceMapper resourceMapper;
	
	@Override
	public Resource create(ResourceCreateRequestDto resourceCreateRequestDto) {
		Resource newResource = resourceMapper.fromCreateDtoToResource(resourceCreateRequestDto);
		resourceRepository.save(newResource);
		return newResource;
	}
	
	@Override
	public Resource update(String id, ResourceUpdateRequestDto resourceUpdateRequestDto) {
		Resource foundResource = getById(id);
		resourceMapper.fromUpdateDtoToResource(resourceUpdateRequestDto, foundResource);
		Resource updatedResource = resourceRepository.save(foundResource);
		return updatedResource;
	}
	
	@Override
	public String delete(String id) {
		Resource foundResource = getById(id);
		resourceRepository.delete(foundResource);
		return "Resource has been successfully deleted";
	}
	
	@Override
	public Resource getById(String id) {
		return resourceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Resource with id «" + id + "» not found"));
	}
	
	@Override
	public List<Resource> getAllResources() {
		return resourceRepository.findAll();
	}
	
}
