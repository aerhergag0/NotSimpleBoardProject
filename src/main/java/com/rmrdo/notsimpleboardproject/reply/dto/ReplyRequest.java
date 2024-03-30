package com.rmrdo.notsimpleboardproject.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyRequest {

	private Long    id;
	private String  content;
	private Long    postId;
	private UUID    userId;
	private boolean parentComment;
	private int     parentCommentId;
}
