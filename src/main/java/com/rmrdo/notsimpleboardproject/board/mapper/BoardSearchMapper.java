package com.rmrdo.notsimpleboardproject.board.mapper;

import com.rmrdo.notsimpleboardproject.board.dto.BoardResponse;
import com.rmrdo.notsimpleboardproject.board.entity.BoardDoc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BoardSearchMapper {

	BoardSearchMapper INSTANCE = Mappers.getMapper(BoardSearchMapper.class);

	@Mapping(target = "replies", ignore = true)
	BoardResponse toResponse(BoardDoc boardDoc);
}
