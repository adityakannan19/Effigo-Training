package com.example.learningportal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.learningportal.dto.EnrollmentDto;
import com.example.learningportal.entity.Enrollment;

@Mapper(componentModel = "spring", uses = { UserMapper.class, CourseMapper.class })

public interface EnrollmentMapper {

	EnrollmentMapper INSTANCE = Mappers.getMapper(EnrollmentMapper.class);

	@Mapping(source = "enrollment.learner.userId", target = "learnerId")
	EnrollmentDto enrollmentToEnrollmentDTO(Enrollment enrollment);

	Enrollment enrollmentDTOToEnrollment(EnrollmentDto enrollmentDTO);

}
