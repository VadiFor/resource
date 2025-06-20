package com.learn.java.dto;

import com.learn.java.model.enums.StatusResource;
import com.learn.java.model.enums.TypeResource;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResourceCreateRequestDto {
	@NotNull(message = "Name resource required")
	private String name;
	
	@NotNull(message = "Type resource required")
	private TypeResource type;
	
	@NotNull(message = "Location resource required")
	private String location;
	
	@NotNull(message = "Status resource required")
	private StatusResource status;
	
	@NotNull(message = "Portable resource required")
	private Boolean portable;
	
	@NotNull(message = "RequiresApproval resource required")
	private Boolean requiresApproval;
	
	@NotNull(message = "IsShared resource required")
	private Boolean isShared;
}
