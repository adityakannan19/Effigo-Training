package com.example.finalProject.dto;

import java.time.LocalDateTime;

public class enrollmentDTO {
	private Long enrollmentId;
	private Long learnerId;
	private Long courseId;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

	public enrollmentDTO() {
		super();
	}

	public enrollmentDTO(Long enrollmentId, Long learnerId, Long courseId, LocalDateTime createdOn,
			LocalDateTime updatedOn) {
		super();
		this.enrollmentId = enrollmentId;
		this.learnerId = learnerId;
		this.courseId = courseId;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public Long getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(Long enrollmentId) {
		this.enrollmentId = enrollmentId;
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
