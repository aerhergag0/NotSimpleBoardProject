package com.rmrdo.notsimpleboardproject.board.entity;

import com.rmrdo.notsimpleboardproject.common.utils.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "board")
public class BoardEntity extends BaseTimeEntity {

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

	public void updateTitleAndContent(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
