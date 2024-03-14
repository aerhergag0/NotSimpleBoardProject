package com.rmrdo.notsimpleboardproject.board.mapper;

import com.rmrdo.notsimpleboardproject.board.dto.BoardResponse;
import com.rmrdo.notsimpleboardproject.board.entity.BoardEntity;
import com.rmrdo.notsimpleboardproject.common.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BoardResponseMapper extends GenericMapper<BoardResponse, BoardEntity> {
	BoardResponseMapper INSTANCE = Mappers.getMapper(BoardResponseMapper.class);
}
