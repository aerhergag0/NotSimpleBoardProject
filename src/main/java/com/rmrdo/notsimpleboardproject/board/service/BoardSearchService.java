package com.rmrdo.notsimpleboardproject.board.service;

import co.elastic.clients.json.JsonData;
import com.rmrdo.notsimpleboardproject.board.dto.BoardResponse;
import com.rmrdo.notsimpleboardproject.board.dto.BoardSearchRequest;
import com.rmrdo.notsimpleboardproject.board.entity.BoardDoc;
import com.rmrdo.notsimpleboardproject.board.mapper.BoardSearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardSearchService {

	private final ElasticsearchOperations operations;

	private static final BoardSearchMapper boardSearchMapper = BoardSearchMapper.INSTANCE;

	public List<BoardResponse> integratedSearch(BoardSearchRequest boardSearchRequest) {

		var query = NativeQuery.builder()
				.withQuery(q -> q
						.multiMatch(m -> m
								.query(boardSearchRequest.getKeyword())
								.fields("title", "writer", "content")
								.fuzziness("1"))
				).withPageable(Pageable.ofSize(5))
				.build();

		SearchHits<BoardDoc> searchHits = operations.search(query, BoardDoc.class);

		return searchHits.stream().map(
				hit -> boardSearchMapper.toResponse(hit.getContent())
		).toList();
	}

	public List<BoardResponse> integratedSearchWithDateFilter(BoardSearchRequest boardSearchRequest) {

		var query = NativeQuery.builder()
				.withQuery(q -> q
						.bool(b -> b
								.must(m -> m
										.multiMatch(multi -> multi
												.query(boardSearchRequest.getKeyword())
												.fields("title", "writer", "content")
												.fuzziness("1")
										)
								)
								.filter(f -> f
										.range(r -> r
												.field("created_at")
												.timeZone("Asia/Seoul")
												.gte(JsonData.of(boardSearchRequest.getStartDate()))
												.lte(JsonData.of(boardSearchRequest.getEndDate()))
										)
								)
						)
				).withPageable(Pageable.ofSize(10))
				.build();

		SearchHits<BoardDoc> searchHits = operations.search(query, BoardDoc.class);

		return searchHits.stream().map(
				hit -> boardSearchMapper.toResponse(hit.getContent())
		).toList();
	}
}
