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
@Table(name = "reply")
@SQLDelete(sql = "UPDATE reply SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = false")
public class ReplyEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "post_id", nullable = false)
	private Long postId;

	@Column(name = "user_id", columnDefinition = "BINARY(16)")
	private UUID userId;

	@Column(length = 1024, nullable = false)
	private String content;

	@Column(columnDefinition = "int default 0")
	private int likeCnt;

	@Column(columnDefinition = "int default 0")
	private boolean deleted;

	@Column(name = "parent_comment", columnDefinition = "boolean default true")
	private boolean parentComment;

	@Column(name = "parent_comment_id")
	private int parentCommentId;


	public void updateContent(String content) {
		this.content = content;
	}
}
