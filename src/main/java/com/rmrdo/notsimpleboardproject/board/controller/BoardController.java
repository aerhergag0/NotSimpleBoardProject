package com.rmrdo.notsimpleboardproject.board.controller;

import com.rmrdo.notsimpleboardproject.board.dto.BoardRequest;
import com.rmrdo.notsimpleboardproject.board.dto.BoardResponse;
import com.rmrdo.notsimpleboardproject.board.service.BoardService;
import com.rmrdo.notsimpleboardproject.common.utils.ApiUtils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
