package com.rmrdo.notsimpleboardproject.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubReplyResponse {

	private Long    id;
	private Long    parentId;
	private String  content;
	private int     likeCnt;
	private boolean deleted;
}
