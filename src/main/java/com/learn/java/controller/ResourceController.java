package com.learn.java.controller;

import com.learn.java.dto.ResourceCreateRequestDto;
import com.learn.java.dto.ResourceUpdateRequestDto;
import com.learn.java.model.Resource;
import com.learn.java.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/res")
public class ResourceController {
	private final ResourceService resourceService;
	
	@GetMapping
	public List<Resource> getAllResource() {
		return resourceService.getAllResources();
	}
	
	@GetMapping("/{id}")
	public Resource getResource(@PathVariable String id) {
		return resourceService.getById(id);
	}
	
	@PostMapping
	public Resource createResource(@RequestBody ResourceCreateRequestDto resourceCreateRequestDto) {
		return resourceService.create(resourceCreateRequestDto);
	}
	
	@PatchMapping("/{id}")
	public Resource updateResource(@PathVariable String id,
								   @RequestBody ResourceUpdateRequestDto resourceUpdateRequestDto) {
		return resourceService.update(id, resourceUpdateRequestDto);
	}
	
	@DeleteMapping("/{id}")
	public String deleteResource(@PathVariable String id) {
		return resourceService.delete(id);
	}
}
