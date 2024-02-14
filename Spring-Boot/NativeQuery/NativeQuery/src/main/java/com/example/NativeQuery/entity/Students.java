package com.example.NativeQuery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Students {
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;

	private String firstName;
	private String lastName;
	private String mailId;
	private long contactNo;

	//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//	@JoinTable(name = "student_clubs", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "club_id"))
	//	private Set<CollegeClubs> clubs = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "student_stream")
	private Streams stream;
}
