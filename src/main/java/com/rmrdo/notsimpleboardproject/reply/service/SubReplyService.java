package com.rmrdo.notsimpleboardproject.reply.service;

import com.rmrdo.notsimpleboardproject.exception.NotFoundException;
import com.rmrdo.notsimpleboardproject.reply.dto.SubReplyRequest;
import com.rmrdo.notsimpleboardproject.reply.dto.SubReplyResponse;
import com.rmrdo.notsimpleboardproject.reply.mapper.SubReplyMapper;
import com.rmrdo.notsimpleboardproject.reply.mapper.SubReplyResponseMapper;
import com.rmrdo.notsimpleboardproject.reply.repository.SubReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubReplyService {

	private final SubReplyRepository subReplyRepository;

	private static final SubReplyMapper         subReplyMapper         = SubReplyMapper.INSTANCE;
	private static final SubReplyResponseMapper subReplyResponseMapper = SubReplyResponseMapper.INSTANCE;

	public SubReplyResponse postSubReply(SubReplyRequest subReplyRequest) {

		var entity = subReplyMapper.toEntity(subReplyRequest);
		var newEntity = subReplyRepository.save(entity);

		return subReplyResponseMapper.toDto(newEntity);
	}

	public SubReplyResponse updateSubReply(SubReplyRequest subReplyRequest) {

		var entity = subReplyRepository.findById(subReplyRequest.getId())
				.orElseThrow(() -> new NotFoundException("Not Found"));

		entity.updateContent(subReplyRequest.getContent());

		subReplyRepository.updateContentById(entity.getContent(), entity.getId());

		return subReplyResponseMapper.toDto(entity);
	}

	public SubReplyResponse deleteSubReply(SubReplyRequest subReplyRequest) {

		var entity = subReplyRepository.findById(subReplyRequest.getId())
				.orElseThrow(() -> new NotFoundException("Not Found"));

		subReplyRepository.deleteById(entity.getId());

		return subReplyResponseMapper.toDto(entity);
	}
}
