package com.rmrdo.notsimpleboardproject.board.controller;

import com.rmrdo.notsimpleboardproject.board.dto.BoardRequest;
import com.rmrdo.notsimpleboardproject.board.dto.BoardResponse;
import com.rmrdo.notsimpleboardproject.board.service.BoardService;
import com.rmrdo.notsimpleboardproject.common.utils.ApiUtils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rmrdo.notsimpleboardproject.common.utils.ApiUtils.success;

@RestController
@RequestMapping("/v1/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	@PostMapping
	public ApiResult<BoardResponse> postBoard(@RequestBody BoardRequest boardRequest) {
		var response = boardService.postBoard(boardRequest);
		return success(response);
	}

	@GetMapping("/{id}")
	public ApiResult<BoardResponse> getBoardOne(@PathVariable Long id) {
		var response = boardService.getBoardOne(id);
		return success(response);
	}

	@GetMapping
	public ApiResult<List<BoardResponse>> getBoardAll() {
		var response = boardService.getBoardAll();
		return success(response);
	}

	@PutMapping("/{id}")
	public ApiResult<BoardResponse> putBoard(@PathVariable Long id, @RequestBody BoardRequest boardRequest) {
		var response = boardService.putBoard(id, boardRequest);
		return success(response);
	}

	@DeleteMapping("/{id}")
	public ApiResult<BoardResponse> deleteBoard(@PathVariable Long id) {
		var response = boardService.deleteBoard(id);
		return success(response);
	}
}
