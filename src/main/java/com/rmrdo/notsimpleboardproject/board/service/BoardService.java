package com.rmrdo.notsimpleboardproject.board.service;

import com.rmrdo.notsimpleboardproject.board.dto.BoardRequest;
import com.rmrdo.notsimpleboardproject.board.dto.BoardResponse;
import com.rmrdo.notsimpleboardproject.board.mapper.BoardMapper;
import com.rmrdo.notsimpleboardproject.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;

	private static final BoardMapper mapper = BoardMapper.INSTANCE;

	public BoardResponse postBoard(BoardRequest boardRequest) {
		var entity = mapper.toEntity(boardRequest);
		var newEntity = boardRepository.save(entity);
		var response = mapper.boardEntityToBoardResponse(newEntity);

		return response;
	}
}
