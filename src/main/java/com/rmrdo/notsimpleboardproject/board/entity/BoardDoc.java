package com.rmrdo.notsimpleboardproject.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "nsbp-board")
public class BoardDoc {

	private Long id;

	private String title;

	private String writer;

	private String content;

	private int likeCnt;

	private boolean deleted;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
}
