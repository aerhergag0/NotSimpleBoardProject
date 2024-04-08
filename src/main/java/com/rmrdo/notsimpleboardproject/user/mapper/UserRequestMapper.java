package com.rmrdo.notsimpleboardproject.user.mapper;

import com.rmrdo.notsimpleboardproject.common.mapper.GenericMapper;
import com.rmrdo.notsimpleboardproject.user.dto.UserRegisterRequest;
import com.rmrdo.notsimpleboardproject.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserRequestMapper extends GenericMapper<UserRegisterRequest, UserEntity> {

	UserRequestMapper INSTANCE = Mappers.getMapper(UserRequestMapper.class);
}
