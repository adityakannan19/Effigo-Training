package com.example.finalProject.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enrollment")
public class enrollmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enrollmentId;

	@ManyToOne
	@JoinColumn(name = "learner_id")
	private userEntity learner;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private courseEntity course;

	@Column(name = "created_on", nullable = false, updatable = false)
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

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

	public Long getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(Long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public userEntity getLearner() {
		return learner;
	}

	public void setLearner(userEntity learner) {
		this.learner = learner;
	}

	public courseEntity getCourse() {
		return course;
	}

	public void setCourse(courseEntity course) {
		this.course = course;
	}

}
