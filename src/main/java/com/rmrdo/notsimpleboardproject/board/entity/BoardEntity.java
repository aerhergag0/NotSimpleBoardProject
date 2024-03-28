package com.rmrdo.notsimpleboardproject.board.entity;

import com.rmrdo.notsimpleboardproject.common.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "board")
@SQLDelete(sql = "UPDATE board SET is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")
public class BoardEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255, nullable = false)
	private String title;

	@Column(length = 50, nullable = false)
	private String writer;

	@Column(columnDefinition = "text")
	private String content;

	@Column(columnDefinition = "int default 0")
	private int likeCnt;

	@Column(columnDefinition = "int default 0")
	private boolean isDeleted;

	public void updateTitleAndContent(String title, String content) {
		this.title   = title;
		this.content = content;
	}
}
