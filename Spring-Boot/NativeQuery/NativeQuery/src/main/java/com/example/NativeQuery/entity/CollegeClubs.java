package com.example.NativeQuery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CollegeClubs {
	@Id
	@Column(name = "club_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clubId;

	private String name;
	private String description;
}
