package com.rmrdo.notsimpleboardproject.board.controller;

import com.rmrdo.notsimpleboardproject.board.dto.BoardResponse;
import com.rmrdo.notsimpleboardproject.board.dto.BoardSearchRequest;
import com.rmrdo.notsimpleboardproject.board.service.BoardSearchService;
import com.rmrdo.notsimpleboardproject.common.utils.ApiUtils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rmrdo.notsimpleboardproject.common.utils.ApiUtils.success;

@RestController
@RequestMapping("/v1/board/search")
@RequiredArgsConstructor
public class BoardSearchController {

	private final BoardSearchService boardSearchService;

	@PostMapping
	public ApiResult<List<BoardResponse>> integratedSearchBoard(@RequestBody BoardSearchRequest boardSearchRequest) {
		var response = boardSearchService.integratedSearch(boardSearchRequest);

		return success(response);
	}

	@PostMapping("/filter")
	public ApiResult<List<BoardResponse>> integratedSearchWithFilter(@RequestBody BoardSearchRequest boardSearchRequest) {
		var response = boardSearchService.integratedSearchWithDateFilter(boardSearchRequest);

		return success(response);
	}
}
