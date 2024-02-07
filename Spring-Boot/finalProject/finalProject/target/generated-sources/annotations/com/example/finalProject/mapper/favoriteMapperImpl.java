package com.example.finalProject.mapper;

import com.example.finalProject.dto.favoriteDTO;
import com.example.finalProject.entity.favoriteEntity;
import com.example.finalProject.entity.userEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T14:25:33+0530",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class favoriteMapperImpl implements favoriteMapper {

    @Override
    public favoriteDTO favoriteToFavoriteDTO(favoriteEntity favorite) {
        if ( favorite == null ) {
            return null;
        }

        favoriteDTO favoriteDTO = new favoriteDTO();

        favoriteDTO.setLearnerId( favoriteLearnerUserId( favorite ) );
        favoriteDTO.setFavoriteId( favorite.getFavoriteId() );

        favoriteDTO.setCreatedOn( dateTimeFormatter.formatTimestamp(user.getCreatedOn()) );
        favoriteDTO.setUpdatedOn( dateTimeFormatter.formatTimestamp(user.getUpdatedOn()) );

        return favoriteDTO;
    }

    @Override
    public favoriteEntity favoriteDTOToFavorite(favoriteDTO favoriteDTO) {
        if ( favoriteDTO == null ) {
            return null;
        }

        favoriteEntity favoriteEntity = new favoriteEntity();

        favoriteEntity.setCreatedOn( favoriteDTO.getCreatedOn() );
        favoriteEntity.setFavoriteId( favoriteDTO.getFavoriteId() );
        favoriteEntity.setUpdatedOn( favoriteDTO.getUpdatedOn() );

        return favoriteEntity;
    }

    private Long favoriteLearnerUserId(favoriteEntity favoriteEntity) {
        userEntity learner = favoriteEntity.getLearner();
        if ( learner == null ) {
            return null;
        }
        return learner.getUserId();
    }
}
