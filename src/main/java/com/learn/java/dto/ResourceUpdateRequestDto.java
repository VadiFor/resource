package com.learn.java.dto;

import com.learn.java.model.enums.StatusResource;
import com.learn.java.model.enums.TypeResource;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResourceUpdateRequestDto {
	@Schema(description = "Name resource", example = "ROOM A")
	private String name;
	@Schema(description = "Type resource", example = "ROOM")
	private TypeResource type;
	@Schema(description = "Location resource", example = "Office A")
	private String location;
	@Schema(description = "Status resource", example = "ACTIVE")
	private StatusResource status;
	@Schema(description = "Resource portable", example = "false")
	private Boolean portable;
	@Schema(description = "Resource requires approval", example = "true")
	private Boolean requiresApproval;
	@Schema(description = "Resource shared", example = "true")
	private Boolean isShared;
}
