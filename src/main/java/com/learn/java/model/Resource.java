package com.learn.java.model;

import com.learn.java.model.enums.TypeResource;
import jakarta.persistence.*;
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
	private String name;
	
	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeResource type;
	
	private String location;
	
	@Column(nullable = false)
	private Boolean available;
}
