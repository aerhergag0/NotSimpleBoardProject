package com.rmrdo.notsimpleboardproject.user.mapper;

import com.rmrdo.notsimpleboardproject.user.dto.OAuthAttributes;
import com.rmrdo.notsimpleboardproject.user.dto.SessionUser;
import com.rmrdo.notsimpleboardproject.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OAuth2UserMapper {

	OAuth2UserMapper INSTANCE = Mappers.getMapper(OAuth2UserMapper.class);

	@Mapping(target = "userName", source = "name")
	@Mapping(target = "profileImg", source = "picture")
	UserEntity oAuthAttributesToUserEntity(OAuthAttributes attributes);

	@Mapping(target = "name", source = "userName")
	@Mapping(target = "picture", source = "profileImg")
	SessionUser userEntityToSessionUser(UserEntity userEntity);
}
