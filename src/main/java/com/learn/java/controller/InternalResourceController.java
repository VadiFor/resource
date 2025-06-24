package com.learn.java.controller;

import com.learn.java.mapper.ResourceMapper;
import com.learn.java.model.Resource;
import com.learn.java.service.ResourceService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/res")
@Hidden
public class InternalResourceController {
	private final ResourceService resourceService;
	private final ResourceMapper resourceMapper;
	
	@GetMapping("/{id}")
	public Resource getById(@PathVariable String id) {
		return resourceService.getById(id);
	}
}
