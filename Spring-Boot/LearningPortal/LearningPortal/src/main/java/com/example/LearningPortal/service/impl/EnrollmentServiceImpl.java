package com.example.LearningPortal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.dto.EnrollmentDTO;
import com.example.LearningPortal.entity.EnrollmentEntity;
import com.example.LearningPortal.mapper.EnrollmentMapper;
import com.example.LearningPortal.repository.EnrollmentRepository;
import com.example.LearningPortal.service.EnrollmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
	private EnrollmentRepository enrollmentRepository;
	private ModelMapper modelMapper;

	public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository, ModelMapper modelMapper) {
		super();
		this.enrollmentRepository = enrollmentRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<EnrollmentDTO> getAllEnrollments() {
		List<EnrollmentEntity> enrollments = enrollmentRepository.findAll();
		return enrollments.stream().map((enroll) -> EnrollmentMapper.MAPPER.mapToEnrollmentDto(enroll))
				.collect(Collectors.toList());
	}

	@Override
	public EnrollmentDTO getEnrollmentById(long enrollid) {
		EnrollmentEntity enrollment = enrollmentRepository.findById(enrollid).get();
		return EnrollmentMapper.MAPPER.mapToEnrollmentDto(enrollment);
	}

	@Override
	public EnrollmentDTO createEnrollment(EnrollmentDTO enrollmentDto) {

		EnrollmentEntity enroll = EnrollmentMapper.MAPPER.mapToEnrollment(enrollmentDto);

		EnrollmentEntity savedEnroll = enrollmentRepository.save(enroll);

		EnrollmentDTO savedEnrollmentDto = EnrollmentMapper.MAPPER.mapToEnrollmentDto(savedEnroll);

		return savedEnrollmentDto;
	}
}
