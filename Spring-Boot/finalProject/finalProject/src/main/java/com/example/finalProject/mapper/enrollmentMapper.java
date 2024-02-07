package com.example.finalProject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.finalProject.dto.enrollmentDTO;
import com.example.finalProject.entity.enrollmentEntity;

@Mapper(componentModel = "spring", uses = { userMapper.class, courseMapper.class })
public interface enrollmentMapper {
	enrollmentMapper INSTANCE = Mappers.getMapper(enrollmentMapper.class);

	@Mapping(target = "createdOn", expression = "java(dateTimeFormatter.formatTimestamp(user.getCreatedOn()))")
	@Mapping(target = "updatedOn", expression = "java(dateTimeFormatter.formatTimestamp(user.getUpdatedOn()))")
	@Mapping(source = "enrollment.learner.userId", target = "learnerId")
	enrollmentDTO enrollmentToEnrollmentDTO(enrollmentEntity enrollment);

	enrollmentEntity enrollmentDTOToEnrollment(enrollmentDTO enrollmentDTO);
}
