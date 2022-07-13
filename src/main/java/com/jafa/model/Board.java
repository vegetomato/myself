package com.jafa.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private long bno;
	private String title;
	private String content;
	private String writer;
	private int replyCnt;
	private Long viewCount;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	
	private List<BoardAttachVO> attachList;
	
}
