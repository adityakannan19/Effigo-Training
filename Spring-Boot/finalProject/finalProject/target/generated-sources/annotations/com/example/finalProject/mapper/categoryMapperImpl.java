package com.example.finalProject.mapper;

import com.example.finalProject.dto.categoryDTO;
import com.example.finalProject.entity.categoryEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T14:42:21+0530",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class categoryMapperImpl implements categoryMapper {

    @Override
    public categoryDTO categoryEntityToCategoryDTO(categoryEntity category) {
        if ( category == null ) {
            return null;
        }

        categoryDTO categoryDTO = new categoryDTO();

        categoryDTO.setCategoryId( category.getCategoryId() );
        categoryDTO.setName( category.getName() );

        categoryDTO.setCreatedOn( dateTimeFormatter.formatTimestamp(user.getCreatedOn()) );
        categoryDTO.setUpdatedOn( dateTimeFormatter.formatTimestamp(user.getUpdatedOn()) );

        return categoryDTO;
    }

    @Override
    public categoryEntity categoryDTOToCategoryEntity(categoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        categoryEntity categoryEntity = new categoryEntity();

        categoryEntity.setCategoryId( categoryDTO.getCategoryId() );
        categoryEntity.setCreatedOn( categoryDTO.getCreatedOn() );
        categoryEntity.setName( categoryDTO.getName() );
        categoryEntity.setUpdatedOn( categoryDTO.getUpdatedOn() );

        return categoryEntity;
    }
}
