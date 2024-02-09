package com.example.LearningPortal.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class UserEntity {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;

	@Column(unique = true)
	private String username;
	private String password;
	private boolean enabled;

	//	@Enumerated(EnumType.STRING)
	//	private UserRoleEnum role;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Roles> roles = new HashSet<>();

	//	public Long getId() {
	//		return userID;
	//	}

	@OneToMany(mappedBy = "author")
	private List<CourseEntity> authoredCourses;

	@OneToMany(mappedBy = "learner")
	private List<EnrollmentEntity> enrollments;

	@OneToMany(mappedBy = "learner")
	private List<FavoriteEntity> favorites;

	//	@Column(name = "created_on", nullable = false, updatable = false)
	//	private Timestamp createdOn;
	//
	//	@Column(name = "updated_on")
	//	private Timestamp updatedOn;

}
