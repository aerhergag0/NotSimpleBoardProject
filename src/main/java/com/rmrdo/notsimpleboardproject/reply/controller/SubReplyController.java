package com.rmrdo.notsimpleboardproject.reply.controller;

import com.rmrdo.notsimpleboardproject.common.utils.ApiUtils;
import com.rmrdo.notsimpleboardproject.reply.dto.SubReplyRequest;
import com.rmrdo.notsimpleboardproject.reply.dto.SubReplyResponse;
import com.rmrdo.notsimpleboardproject.reply.service.SubReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.rmrdo.notsimpleboardproject.common.utils.ApiUtils.success;

@RestController
@RequestMapping("/v1/board/reply")
@RequiredArgsConstructor
public class SubReplyController {

	private final SubReplyService subReplyService;

	@PostMapping("/{replyId}")
	public ApiUtils.ApiResult<SubReplyResponse> postSubReply(@PathVariable Long replyId, @RequestBody SubReplyRequest subReplyRequest) {

		subReplyRequest.setParentId(replyId);

		var response = subReplyService.postSubReply(subReplyRequest);
		return success(response);
	}

	@PatchMapping("/{replyId}")
	public ApiUtils.ApiResult<SubReplyResponse> updateSubReply(@PathVariable Long replyId, @RequestBody SubReplyRequest subReplyRequest) {

		subReplyRequest.setParentId(replyId);

		var response = subReplyService.updateSubReply(subReplyRequest);
		return success(response);
	}

	@DeleteMapping("/{replyId}")
	public ApiUtils.ApiResult<SubReplyResponse> deleteReply(@PathVariable Long replyId, @RequestBody SubReplyRequest subReplyRequest) {

		subReplyRequest.setParentId(replyId);

		var response = subReplyService.deleteSubReply(subReplyRequest);
		return success(response);
	}
}
