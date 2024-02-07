package com.example.finalProject.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
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
public class courseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;

	private String title;
	private String description;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private userEntity author;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private categoryEntity category;

	@OneToMany(mappedBy = "course")
	private List<enrollmentEntity> enrollments;

	@OneToMany(mappedBy = "course")
	private List<favoriteEntity> favorites;

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

	public userEntity getAuthor() {
		return author;
	}

	public void setAuthor(userEntity author) {
		this.author = author;
	}

	public categoryEntity getCategory() {
		return category;
	}

	public void setCategory(categoryEntity category) {
		this.category = category;
	}

	public List<enrollmentEntity> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<enrollmentEntity> enrollments) {
		this.enrollments = enrollments;
	}

	public List<favoriteEntity> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<favoriteEntity> favorites) {
		this.favorites = favorites;
	}

}
