package com.example.finalProject.mapper;

import com.example.finalProject.dto.userDTO;
import com.example.finalProject.entity.UserRoleEnum;
import com.example.finalProject.entity.userEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T14:49:18+0530",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class userMapperImpl implements userMapper {

    @Override
    public userDTO userEntityToUserDTO(userEntity user) {
        if ( user == null ) {
            return null;
        }

        userDTO userDTO = new userDTO();

        if ( user.getRole() != null ) {
            userDTO.setRole( user.getRole().name() );
        }
        userDTO.setPassword( user.getPassword() );
        userDTO.setUserId( user.getUserId() );
        userDTO.setUsername( user.getUsername() );

        userDTO.setCreatedOn( dateTimeFormatter.formatTimestamp(user.getCreatedOn()) );
        userDTO.setUpdatedOn( dateTimeFormatter.formatTimestamp(user.getUpdatedOn()) );

        return userDTO;
    }

    @Override
    public userEntity userDTOToUserEntity(userDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        userEntity userEntity = new userEntity();

        userEntity.setCreatedOn( userDTO.getCreatedOn() );
        userEntity.setPassword( userDTO.getPassword() );
        if ( userDTO.getRole() != null ) {
            userEntity.setRole( Enum.valueOf( UserRoleEnum.class, userDTO.getRole() ) );
        }
        userEntity.setUpdatedOn( userDTO.getUpdatedOn() );
        userEntity.setUserId( userDTO.getUserId() );
        userEntity.setUsername( userDTO.getUsername() );

        return userEntity;
    }
}
