package com.rmrdo.notsimpleboardproject.board.repository;

import com.rmrdo.notsimpleboardproject.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
