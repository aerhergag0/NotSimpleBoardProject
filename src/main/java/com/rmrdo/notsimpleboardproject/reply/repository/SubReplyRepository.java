package com.rmrdo.notsimpleboardproject.reply.repository;

import com.rmrdo.notsimpleboardproject.reply.entity.SubReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SubReplyRepository extends JpaRepository<SubReplyEntity, Long> {
	@Transactional
	@Modifying
	@Query("update SubReplyEntity s set s.content = ?1 where s.id = ?2")
	void updateContentById(@NonNull String content, @Nullable Long id);
}
