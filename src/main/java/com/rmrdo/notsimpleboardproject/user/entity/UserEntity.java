package com.rmrdo.notsimpleboardproject.user.entity;

import com.rmrdo.notsimpleboardproject.common.utils.BaseEntity;
import com.rmrdo.notsimpleboardproject.user.entity.enums.UserRole;
import com.rmrdo.notsimpleboardproject.user.entity.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid4")
	@UuidGenerator
	@Column(columnDefinition = "VARBINARY(16)")
	private UUID id;

	@Column(length = 50, nullable = false)
	private String userId;

	@Column(length = 100, nullable = false)
	private String password;

	@Column(length = 100, nullable = false)
	private String userName;

	@Column(length = 100, nullable = false)
	private String email;

	@Column(length = 30, nullable = false)
	private String phoneNumber;

	@Column(length = 15, nullable = false, columnDefinition = "varchar(15) default 'NORMAL'")
	@Enumerated(EnumType.STRING)
	private UserRole role;

	@Column(length = 255, nullable = false)
	private String profileImg;

	@Column(length = 50, nullable = false, columnDefinition = "varchar(50) default 'ACTIVE'")
	@Enumerated(EnumType.STRING)
	private UserStatus status;

	private LocalDateTime lastLoginAt;


}
