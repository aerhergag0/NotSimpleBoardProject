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
public class ReplyResponse {

	private Long    id;
	private Long    postId;
	private UUID    userId;
	private String  content;
	private int     likeCnt;
	private boolean deleted;
	private boolean parentComment;
	private int     parentCommentId;
}
