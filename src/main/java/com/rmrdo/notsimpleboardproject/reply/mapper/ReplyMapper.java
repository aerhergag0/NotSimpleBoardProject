package com.rmrdo.notsimpleboardproject.reply.mapper;

import com.rmrdo.notsimpleboardproject.common.mapper.GenericMapper;
import com.rmrdo.notsimpleboardproject.reply.dto.ReplyRequest;
import com.rmrdo.notsimpleboardproject.reply.entity.ReplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReplyMapper extends GenericMapper<ReplyRequest, ReplyEntity> {

	ReplyMapper INSTANCE = Mappers.getMapper(ReplyMapper.class);
}
