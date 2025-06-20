package com.learn.java.model.enums;

public enum StatusResource {
	ACTIVE,            // в рабочем состоянии, доступен для бронирования
	INACTIVE,        // отключен вручную админом
	MAINTENANCE,    // на техобслуживании
	BROKEN,            // сломан
	DECOMMISSIONED    // списан
}
