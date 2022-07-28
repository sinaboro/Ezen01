package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private Long rno, bno;
	private String reply, replyer;
	private Date replyDate, updateDate;
}
