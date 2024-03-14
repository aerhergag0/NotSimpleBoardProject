package com.rmrdo.notsimpleboardproject.board.service;

import com.rmrdo.notsimpleboardproject.board.dto.BoardRequest;
import com.rmrdo.notsimpleboardproject.board.dto.BoardResponse;
import com.rmrdo.notsimpleboardproject.board.mapper.BoardMapper;
import com.rmrdo.notsimpleboardproject.board.mapper.BoardResponseMapper;
import com.rmrdo.notsimpleboardproject.board.repository.BoardRepository;
import com.rmrdo.notsimpleboardproject.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;

	private static final BoardMapper         mapper         = BoardMapper.INSTANCE;
	private static final BoardResponseMapper responseMapper = BoardResponseMapper.INSTANCE;

	public BoardResponse postBoard(BoardRequest boardRequest) {
		var entity = mapper.toEntity(boardRequest);
		var newEntity = boardRepository.save(entity);

		return responseMapper.toDto(newEntity);
	}

	public BoardResponse getBoardOne(Long id) {
		var entity = boardRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found"));

		return responseMapper.toDto(entity);
	}

	public List<BoardResponse> getBoardAll() {
		var entity = boardRepository.findAllByOrderByIdDesc(
				PageRequest.of(0, 20));

		return responseMapper.toDtoList(entity.getContent());
	}

	public BoardResponse putBoard(Long id, BoardRequest boardRequest) {
		var entity = boardRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found"));

		entity.updateTitleAndContent(boardRequest.getTitle(), boardRequest.getContent());

		boardRepository.updateTitleAndContentById(entity.getTitle(), entity.getContent(), id);

		return responseMapper.toDto(entity);
	}

	public BoardResponse deleteBoard(Long id) {
		var entity = boardRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found"));

		boardRepository.deleteById(id);
		return responseMapper.toDto(entity);
	}

}
