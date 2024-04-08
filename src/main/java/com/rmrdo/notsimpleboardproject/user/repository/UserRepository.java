package com.rmrdo.notsimpleboardproject.user.repository;

import com.rmrdo.notsimpleboardproject.user.entity.UserEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

	Optional<UserEntity> findByUserId(String userId);

	void deleteById(UUID id);
}
