package com.learn.java.mapper;

import com.learn.java.dto.ResourceCreateRequestDto;
import com.learn.java.dto.ResourceUpdateRequestDto;
import com.learn.java.model.Resource;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ResourceMapper {
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void fromUpdateDtoToResource(ResourceUpdateRequestDto resourceUpdateRequestDto, @MappingTarget Resource resource);
	
	Resource fromCreateDtoToResource(ResourceCreateRequestDto resourceCreateRequestDto);
}