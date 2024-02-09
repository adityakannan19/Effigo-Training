package com.example.LearningPortal.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;

	private String name;

	@OneToMany(mappedBy = "category")
	private List<CourseEntity> courses;

	//	@Column(name = "created_on", nullable = false, updatable = false)
	//	private Timestamp createdOn;
	//
	//	@Column(name = "updated_on")
	//	private Timestamp updatedOn;

}