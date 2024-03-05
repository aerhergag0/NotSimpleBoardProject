package com.rmrdo.notsimpleboardproject.board.repository;

import com.rmrdo.notsimpleboardproject.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
	@Transactional
	@Modifying
	@Query("update BoardEntity b set b.title = ?1, b.content = ?2 where b.id = ?3")
	void updateTitleAndContentById(@NonNull String title, @NonNull String content, @NonNull Long id);
}
