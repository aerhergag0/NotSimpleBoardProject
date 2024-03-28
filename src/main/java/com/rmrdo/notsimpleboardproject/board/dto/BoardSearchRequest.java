package com.rmrdo.notsimpleboardproject.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardSearchRequest {

	private String keyword;

	private String startDate;

	private String endDate;
}
