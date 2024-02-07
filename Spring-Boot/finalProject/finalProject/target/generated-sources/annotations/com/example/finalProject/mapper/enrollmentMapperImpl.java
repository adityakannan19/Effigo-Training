package com.example.finalProject.mapper;

import com.example.finalProject.dto.enrollmentDTO;
import com.example.finalProject.entity.enrollmentEntity;
import com.example.finalProject.entity.userEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T14:25:33+0530",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class enrollmentMapperImpl implements enrollmentMapper {

    @Override
    public enrollmentDTO enrollmentToEnrollmentDTO(enrollmentEntity enrollment) {
        if ( enrollment == null ) {
            return null;
        }

        enrollmentDTO enrollmentDTO = new enrollmentDTO();

        enrollmentDTO.setLearnerId( enrollmentLearnerUserId( enrollment ) );
        enrollmentDTO.setEnrollmentId( enrollment.getEnrollmentId() );

        enrollmentDTO.setCreatedOn( dateTimeFormatter.formatTimestamp(user.getCreatedOn()) );
        enrollmentDTO.setUpdatedOn( dateTimeFormatter.formatTimestamp(user.getUpdatedOn()) );

        return enrollmentDTO;
    }

    @Override
    public enrollmentEntity enrollmentDTOToEnrollment(enrollmentDTO enrollmentDTO) {
        if ( enrollmentDTO == null ) {
            return null;
        }

        enrollmentEntity enrollmentEntity = new enrollmentEntity();

        enrollmentEntity.setCreatedOn( enrollmentDTO.getCreatedOn() );
        enrollmentEntity.setEnrollmentId( enrollmentDTO.getEnrollmentId() );
        enrollmentEntity.setUpdatedOn( enrollmentDTO.getUpdatedOn() );

        return enrollmentEntity;
    }

    private Long enrollmentLearnerUserId(enrollmentEntity enrollmentEntity) {
        userEntity learner = enrollmentEntity.getLearner();
        if ( learner == null ) {
            return null;
        }
        return learner.getUserId();
    }
}
