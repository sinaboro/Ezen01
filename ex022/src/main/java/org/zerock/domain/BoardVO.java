package org.zerock.domain;

import java.util.Date;

import lombok.Data;

/*
 * BNO        NOT NULL NUMBER(10)     
TITLE      NOT NULL VARCHAR2(200)  
CONTENT    NOT NULL VARCHAR2(2000) 
WRITER     NOT NULL VARCHAR2(20)   
REGDATE            DATE           
UPDATEDATE          DATE
 */

@Data
public class BoardVO {
	private Long bno;
	private String title, content, writer;
	private Date regdate, updatedate;
	
	private int replyCnt;
}
