package com.rmrdo.notsimpleboardproject.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardResponse {
	private Long          id;
	private String        title;
	private String        writer;
	private String        content;
	private int           likeCnt;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
