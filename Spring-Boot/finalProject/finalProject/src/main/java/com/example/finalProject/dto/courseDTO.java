package com.example.finalProject.dto;

import java.time.LocalDateTime;

public class courseDTO {
	private Long courseId;
	private String title;
	private String description;
	private Long authorId;
	private String category;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

	public courseDTO() {
		super();
	}

	public courseDTO(Long courseId, String title, String description, Long authorId, String category,
			LocalDateTime createdOn, LocalDateTime updatedOn) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.description = description;
		this.authorId = authorId;
		this.category = category;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

}
