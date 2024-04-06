package com.rmrdo.notsimpleboardproject.reply.mapper;

import com.rmrdo.notsimpleboardproject.common.mapper.GenericMapper;
import com.rmrdo.notsimpleboardproject.reply.dto.ReplyResponse;
import com.rmrdo.notsimpleboardproject.reply.entity.ReplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReplyResponseMapper extends GenericMapper<ReplyResponse, ReplyEntity> {

	ReplyResponseMapper INSTANCE = Mappers.getMapper(ReplyResponseMapper.class);
}
