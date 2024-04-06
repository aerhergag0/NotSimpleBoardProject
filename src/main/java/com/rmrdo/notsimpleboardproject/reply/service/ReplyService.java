package com.rmrdo.notsimpleboardproject.reply.service;

import com.rmrdo.notsimpleboardproject.reply.dto.ReplyRequest;
import com.rmrdo.notsimpleboardproject.reply.dto.ReplyResponse;
import com.rmrdo.notsimpleboardproject.reply.mapper.ReplyMapper;
import com.rmrdo.notsimpleboardproject.reply.mapper.ReplyResponseMapper;
import com.rmrdo.notsimpleboardproject.reply.repository.ReplyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {

	private final ReplyRepository replyRepository;

	private static final ReplyMapper         replyMapper         = ReplyMapper.INSTANCE;
	private static final ReplyResponseMapper replyResponseMapper = ReplyResponseMapper.INSTANCE;


	public ReplyResponse postReply(ReplyRequest replyRequest) {

		var entity = replyMapper.toEntity(replyRequest);
		var newEntity = replyRepository.save(entity);

		return replyResponseMapper.toDto(newEntity);
	}

	public ReplyResponse updateReply(ReplyRequest replyRequest) {

		var entity = replyRepository.findById(replyRequest.getId())
				.orElseThrow(() -> new EntityNotFoundException("Not Found"));

		entity.updateContent(replyRequest.getContent());

		replyRepository.updateContentById(entity.getContent(), entity.getId());

		return replyResponseMapper.toDto(entity);
	}

	public ReplyResponse deleteReply(ReplyRequest replyRequest) {

		var entity = replyRepository.findById(replyRequest.getId())
				.orElseThrow(() -> new EntityNotFoundException("Not Found"));

		replyRepository.deleteById(replyRequest.getId());

		return replyResponseMapper.toDto(entity);
	}
}
