package com.rmrdo.notsimpleboardproject.user.mapper;

import com.rmrdo.notsimpleboardproject.user.dto.UserUnregisterResponse;
import com.rmrdo.notsimpleboardproject.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserUnregisterResponse userUnregisterRequestToUserUnregisterResponse(UserEntity userEntity);
}
