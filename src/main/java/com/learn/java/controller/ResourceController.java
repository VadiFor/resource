package com.learn.java.controller;

import com.learn.java.model.Resource;
import com.learn.java.model.enums.TypeResource;
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
		return resourceService.getResource(id);
	}
	
	@PostMapping
	public Resource createResource(@RequestParam String name,
								   @RequestParam TypeResource type,
								   @RequestParam String location) {
		return resourceService.create(name, type, location);
	}
	
	@PatchMapping
	public Resource updateResource(@RequestBody Resource resource) {
		return resourceService.update(resource.getId(), resource.getName(), resource.getType(), resource.getLocation(), resource.getAvailable());
	}
	
	@DeleteMapping("/{id}")
	public String deleteResource(@PathVariable String id) {
		return resourceService.delete(id);
	}
}
