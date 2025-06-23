package com.learn.java.controller;

import com.learn.java.dto.ResourceCreateRequestDto;
import com.learn.java.dto.ResourceUpdateRequestDto;
import com.learn.java.model.Resource;
import com.learn.java.service.ResourceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/res")
@Tag(name = "Resource Controller")
public class ResourceController {
	private final ResourceService resourceService;
	
	@GetMapping
	@Operation(summary = "Get all resources")
	public List<Resource> getAllResource() {
		return resourceService.getAllResources();
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Get resource by ID")
	public Resource getResource(@PathVariable String id) {
		return resourceService.getById(id);
	}
	
	@PostMapping
	@Operation(summary = "Create resource")
	public Resource createResource(@RequestBody ResourceCreateRequestDto resourceCreateRequestDto) {
		return resourceService.create(resourceCreateRequestDto);
	}
	
	@PatchMapping("/{id}")
	@Operation(summary = "Update resource")
	public Resource updateResource(@PathVariable String id,
								   @RequestBody ResourceUpdateRequestDto resourceUpdateRequestDto) {
		return resourceService.update(id, resourceUpdateRequestDto);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete resource")
	public String deleteResource(@PathVariable String id) {
		return resourceService.delete(id);
	}
}
