package com.example.LearningPortal.mapper;

import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.EnrollmentDTO;
import com.example.LearningPortal.entity.EnrollmentEntity;

public interface EnrollmentMapper {
	EnrollmentMapper MAPPER = Mappers.getMapper(EnrollmentMapper.class);

	EnrollmentDTO mapToEnrollmentDto(EnrollmentEntity enrollment);

	EnrollmentEntity mapToEnrollment(EnrollmentDTO enrollmentDto);
}
