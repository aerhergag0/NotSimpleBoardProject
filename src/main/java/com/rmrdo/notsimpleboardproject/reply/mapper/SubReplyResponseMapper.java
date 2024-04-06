package com.rmrdo.notsimpleboardproject.reply.mapper;

import com.rmrdo.notsimpleboardproject.common.mapper.GenericMapper;
import com.rmrdo.notsimpleboardproject.reply.dto.SubReplyResponse;
import com.rmrdo.notsimpleboardproject.reply.entity.SubReplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SubReplyResponseMapper extends GenericMapper<SubReplyResponse, SubReplyEntity> {

	SubReplyResponseMapper INSTANCE = Mappers.getMapper(SubReplyResponseMapper.class);
}
