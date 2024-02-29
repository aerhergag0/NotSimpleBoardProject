package com.rmrdo.notsimpleboardproject.board.mapper;

import com.rmrdo.notsimpleboardproject.board.dto.BoardRequest;
import com.rmrdo.notsimpleboardproject.board.dto.BoardResponse;
import com.rmrdo.notsimpleboardproject.board.entity.BoardEntity;
import com.rmrdo.notsimpleboardproject.common.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BoardMapper extends GenericMapper<BoardRequest, BoardEntity> {

	BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

	BoardResponse boardEntityToBoardResponse(BoardEntity boardEntity);
}
