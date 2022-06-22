package com.jafa.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReplyVO {
	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	@Getter
	private LocalDateTime regDate;
	@Getter
	private LocalDateTime updateDate;
}
