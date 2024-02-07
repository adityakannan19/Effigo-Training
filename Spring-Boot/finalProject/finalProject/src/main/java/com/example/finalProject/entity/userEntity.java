package com.example.finalProject.entity;

import java.security.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "\"user\"")
public class userEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(unique = true)
	private String username;
	private String password;

	@Enumerated(EnumType.STRING)
	private UserRoleEnum role;

	@OneToMany(mappedBy = "author")
	private List<courseEntity> authoredCourses;

	@OneToMany(mappedBy = "learner")
	private List<enrollmentEntity> enrollments;

	@OneToMany(mappedBy = "learner")
	private List<favoriteEntity> favorites;

	@Column(name = "created_on", nullable = false, updatable = false)
	private Timestamp createdOn;

	@Column(name = "updated_on")
	private Timestamp updatedOn;

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRoleEnum getRole() {
		return role;
	}

	public void setRole(UserRoleEnum role) {
		this.role = role;
	}

	public List<courseEntity> getAuthoredCourses() {
		return authoredCourses;
	}

	public void setAuthoredCourses(List<courseEntity> authoredCourses) {
		this.authoredCourses = authoredCourses;
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
