package com.ead.authuser.dtos;

import java.util.UUID;

import com.ead.authuser.enums.CourseLevel;
import com.ead.authuser.enums.CourseStatus;

import lombok.Data;

@Data
public class CourseDto {
	
	private UUID courseId;
	private String name;
	private String description;
	private String imageUrl;
	private CourseStatus courseStatus;
	private UUID userInstructor;
	private CourseLevel courseLevel;

}
