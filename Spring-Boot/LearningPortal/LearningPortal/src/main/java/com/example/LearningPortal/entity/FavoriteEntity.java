package com.example.LearningPortal.entity;

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
@Table(name = "favorite")
public class FavoriteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long favoriteId;

	@ManyToOne
	@JoinColumn(name = "learner_id")
	private UserEntity learner;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private CourseEntity course;

	//	@Column(name = "created_on", nullable = false, updatable = false)
	//	private Timestamp createdOn;
	//
	//	@Column(name = "updated_on")
	//	private Timestamp updatedOn;

}
