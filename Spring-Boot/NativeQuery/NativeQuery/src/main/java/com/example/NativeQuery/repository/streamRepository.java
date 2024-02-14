package com.example.NativeQuery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.NativeQuery.entity.Streams;

public interface streamRepository extends JpaRepository<Streams, Long> {
	@Query(value = "SELECT * FROM streams c INNER JOIN students s ON c.stream_id = s.student_stream", nativeQuery = true)
	List<Object[]> getJoinedData();
}
