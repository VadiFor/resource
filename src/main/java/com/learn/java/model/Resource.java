package com.learn.java.model;

import com.learn.java.model.enums.StatusResource;
import com.learn.java.model.enums.TypeResource;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "resource")
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
	@Id
	@Builder.Default
	private String id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
	
	@Column(nullable = false)
	@NotNull(message = "Name resource required")
	private String name;
	
	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Type resource required")
	private TypeResource type;
	
	@Column(nullable = false)
	@NotNull(message = "Location resource required")
	private String location;
	
	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Status resource required")
	private StatusResource status;
	
	@Column(nullable = false)
	@NotNull(message = "Portable resource required")
	private Boolean portable;            // Переносимость
	
	@Column(nullable = false)
	@NotNull(message = "RequiresApproval resource required")
	private Boolean requiresApproval;    // Требуется ли подтверждение бронирования админом
	
	@Column(nullable = false)
	@NotNull(message = "IsShared resource required")
	private Boolean isShared;            // Может ли использоваться несколькими пользователями одновременно
}
