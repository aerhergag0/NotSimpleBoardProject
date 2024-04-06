package com.rmrdo.notsimpleboardproject.reply.mapper;

import com.rmrdo.notsimpleboardproject.common.mapper.GenericMapper;
import com.rmrdo.notsimpleboardproject.reply.dto.SubReplyRequest;
import com.rmrdo.notsimpleboardproject.reply.entity.SubReplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SubReplyMapper extends GenericMapper<SubReplyRequest, SubReplyEntity> {

	SubReplyMapper INSTANCE = Mappers.getMapper(SubReplyMapper.class);
}
