package com.rmrdo.notsimpleboardproject.board.service;

import com.rmrdo.notsimpleboardproject.board.dto.BoardRequest;
import com.rmrdo.notsimpleboardproject.board.dto.BoardResponse;
import com.rmrdo.notsimpleboardproject.board.mapper.BoardMapper;
import com.rmrdo.notsimpleboardproject.board.repository.BoardRepository;
import com.rmrdo.notsimpleboardproject.exception.NotFoundException;
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

		return mapper.boardEntityToBoardResponse(newEntity);
	}

	public BoardResponse getBoardOne(Long id) {
		var entity = boardRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found"));

		return mapper.boardEntityToBoardResponse(entity);
	}

	public BoardResponse putBoard(Long id, BoardRequest boardRequest) {

		var entity = boardRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found"));

		entity.updateTitleAndContent(boardRequest.getTitle(), boardRequest.getContent());

		boardRepository.updateTitleAndContentById(entity.getTitle(), entity.getContent(), id);

		return mapper.boardEntityToBoardResponse(entity);
	}
	public BoardResponse deleteBoard(Long id) {

		var entity = boardRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found"));

		boardRepository.deleteById(id);
		return mapper.boardEntityToBoardResponse(entity);
	}

}
