package com.rmrdo.notsimpleboardproject.board.mapper;

import com.rmrdo.notsimpleboardproject.board.dto.BoardResponse;
import com.rmrdo.notsimpleboardproject.board.entity.BoardDoc;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BoardSearchMapper {

	BoardSearchMapper INSTANCE = Mappers.getMapper(BoardSearchMapper.class);

	BoardResponse toResponse(BoardDoc boardDoc);
}
