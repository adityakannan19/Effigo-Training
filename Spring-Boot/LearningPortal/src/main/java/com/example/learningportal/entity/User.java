package com.example.learningportal.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String username;
	private String password;

	@Enumerated(EnumType.STRING)
	private UserRoleEnum role;

	@OneToMany(mappedBy = "author")
	private List<Course> authoredCourses;

	@OneToMany(mappedBy = "learner")
	private List<Enrollment> enrollments;

	@Column(name = "created_on", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreatedDate
	private LocalDateTime createdOn;

	@Column(name = "updated_on", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@LastModifiedDate
	private LocalDateTime updatedOn;

	public String getPasswordHash() {
		return password;
	}

}
