package com.learn.java.dto;

import com.learn.java.model.enums.StatusResource;
import com.learn.java.model.enums.TypeResource;
import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "Name resource", example = "ROOM A")
	private String name;
	
	@NotNull(message = "Type resource required")
	@Schema(description = "Type resource", example = "ROOM")
	private TypeResource type;
	
	@NotNull(message = "Location resource required")
	@Schema(description = "Location resource", example = "Office A")
	private String location;
	
	@NotNull(message = "Status resource required")
	@Schema(description = "Status resource", example = "ACTIVE")
	private StatusResource status;
	
	@NotNull(message = "Portable resource required")
	@Schema(description = "Resource portable", example = "false")
	private Boolean portable;
	
	@NotNull(message = "RequiresApproval resource required")
	@Schema(description = "Resource requires approval", example = "true")
	private Boolean requiresApproval;
	
	@NotNull(message = "IsShared resource required")
	@Schema(description = "Resource shared", example = "true")
	private Boolean isShared;
}
