package com.example.LearningPortal.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class CourseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseId;

	private String title;
	private String description;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private UserEntity author;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	@OneToMany(mappedBy = "course")
	private List<EnrollmentEntity> enrollments;

	@OneToMany(mappedBy = "course")
	private List<FavoriteEntity> favorites;

	//	@Column(name = "created_on", nullable = false, updatable = false)
	//	private Timestamp createdOn;
	//
	//	@Column(name = "updated_on")
	//	private Timestamp updatedOn;

}