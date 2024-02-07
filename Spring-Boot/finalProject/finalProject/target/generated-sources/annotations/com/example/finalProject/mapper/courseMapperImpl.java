package com.example.finalProject.mapper;

import com.example.finalProject.dto.courseDTO;
import com.example.finalProject.entity.categoryEntity;
import com.example.finalProject.entity.courseEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T14:25:41+0530",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class courseMapperImpl implements courseMapper {

    @Override
    public courseDTO courseEntityToCourseDTO(courseEntity course) {
        if ( course == null ) {
            return null;
        }

        courseDTO courseDTO = new courseDTO();

        courseDTO.setCategory( courseCategoryName( course ) );
        courseDTO.setCourseId( course.getCourseId() );
        courseDTO.setDescription( course.getDescription() );
        courseDTO.setTitle( course.getTitle() );

        courseDTO.setCreatedOn( dateTimeFormatter.formatTimestamp(user.getCreatedOn()) );
        courseDTO.setUpdatedOn( dateTimeFormatter.formatTimestamp(user.getUpdatedOn()) );

        return courseDTO;
    }

    @Override
    public courseEntity courseDTOToCourseEntity(courseDTO courseDTO) {
        if ( courseDTO == null ) {
            return null;
        }

        courseEntity courseEntity = new courseEntity();

        courseEntity.setCategory( courseDTOTocategoryEntity( courseDTO ) );
        courseEntity.setCourseId( courseDTO.getCourseId() );
        courseEntity.setCreatedOn( courseDTO.getCreatedOn() );
        courseEntity.setDescription( courseDTO.getDescription() );
        courseEntity.setTitle( courseDTO.getTitle() );
        courseEntity.setUpdatedOn( courseDTO.getUpdatedOn() );

        return courseEntity;
    }

    private String courseCategoryName(courseEntity courseEntity) {
        categoryEntity category = courseEntity.getCategory();
        if ( category == null ) {
            return null;
        }
        return category.getName();
    }

    protected categoryEntity courseDTOTocategoryEntity(courseDTO courseDTO) {
        if ( courseDTO == null ) {
            return null;
        }

        categoryEntity categoryEntity = new categoryEntity();

        categoryEntity.setName( courseDTO.getCategory() );

        return categoryEntity;
    }
}
