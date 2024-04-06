package com.rmrdo.notsimpleboardproject.reply.entity;

import com.rmrdo.notsimpleboardproject.common.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sub_reply")
@SQLDelete(sql = "UPDATE sub_reply SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = false")
public class SubReplyEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "parent_id")
	private Long parentId;

	@Column(name = "user_id", columnDefinition = "BINARY(16)")
	private UUID userId;

	@Column(length = 1024, nullable = false)
	private String content;

	@Column(columnDefinition = "int default 0")
	private int likeCnt;

	@Column(columnDefinition = "int default 0")
	private boolean deleted;


	public void updateContent(String content) {
		this.content = content;
	}
}
