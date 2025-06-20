package com.learn.java.dto;

import com.learn.java.model.enums.StatusResource;
import com.learn.java.model.enums.TypeResource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResourceUpdateRequestDto {
	private String name;
	private TypeResource type;
	private String location;
	private StatusResource status;
	private Boolean portable;
	private Boolean requiresApproval;
	private Boolean isShared;
}
