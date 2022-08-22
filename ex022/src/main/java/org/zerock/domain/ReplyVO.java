package org.zerock.domain;

import java.util.Date;

import lombok.Data;

/*
 * RNO        NOT NULL NUMBER(10)     
BNO        NOT NULL NUMBER(10)     
REPLY      NOT NULL VARCHAR2(1000) 
REPLYER    NOT NULL VARCHAR2(50)   
REPLYDATE           DATE           
UPDATEDATE          DATE 
 */

@Data
public class ReplyVO {
	private Long rno, bno;
	private String reply, replyer;
	private Date replyDate, updateDate;
}
