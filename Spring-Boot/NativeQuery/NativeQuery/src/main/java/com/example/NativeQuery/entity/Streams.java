package com.example.NativeQuery.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Streams {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long streamId;
	private String name;

	@OneToMany(mappedBy = "stream")
	private List<Students> registeredStudent;

}
