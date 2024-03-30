package com.rmrdo.notsimpleboardproject.reply.repository;

import com.rmrdo.notsimpleboardproject.reply.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {

	@Transactional
	@Modifying
	@Query("update ReplyEntity r set r.content = ?1 where r.id = ?2")
	void updateContentById(@NonNull String content, @NonNull Long id);


}
