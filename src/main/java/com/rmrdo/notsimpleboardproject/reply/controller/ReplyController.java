package com.rmrdo.notsimpleboardproject.reply.controller;

import com.rmrdo.notsimpleboardproject.common.utils.ApiUtils;
import com.rmrdo.notsimpleboardproject.reply.dto.ReplyRequest;
import com.rmrdo.notsimpleboardproject.reply.dto.ReplyResponse;
import com.rmrdo.notsimpleboardproject.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.rmrdo.notsimpleboardproject.common.utils.ApiUtils.success;

@RestController
@RequestMapping("/v1/board/reply")
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyService replyService;

	@PostMapping
	public ApiUtils.ApiResult<ReplyResponse> postReply(@RequestBody ReplyRequest replyRequest) {
		var response = replyService.postReply(replyRequest);
		return success(response);
	}

	@PatchMapping
	public ApiUtils.ApiResult<ReplyResponse> updateReply(@RequestBody ReplyRequest replyRequest) {
		var response = replyService.updateReply(replyRequest);
		return success(response);
	}

	@DeleteMapping
	public ApiUtils.ApiResult<ReplyResponse> deleteReply(@RequestBody ReplyRequest replyRequest) {
		var response = replyService.deleteReply(replyRequest);
		return success(response);
	}
}
