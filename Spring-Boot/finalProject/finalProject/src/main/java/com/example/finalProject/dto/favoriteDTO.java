package com.example.finalProject.dto;

import java.time.LocalDateTime;

public class favoriteDTO {
	private Long favoriteId;
	private Long learnerId;
	private Long courseId;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

	public favoriteDTO() {
		super();
	}

	public favoriteDTO(Long favoriteId, Long learnerId, Long courseId, LocalDateTime createdOn,
			LocalDateTime updatedOn) {
		super();
		this.favoriteId = favoriteId;
		this.learnerId = learnerId;
		this.courseId = courseId;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public Long getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(Long favoriteId) {
		this.favoriteId = favoriteId;
	}

	public Long getLearnerId() {
		return learnerId;
	}

	public void setLearnerId(Long learnerId) {
		this.learnerId = learnerId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
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
