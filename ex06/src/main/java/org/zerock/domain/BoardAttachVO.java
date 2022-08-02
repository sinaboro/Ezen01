package org.zerock.domain;

import lombok.Data;

/*
 * UUID       NOT NULL VARCHAR2(100) 
UPLOADPATH NOT NULL VARCHAR2(200) 
FILENAME   NOT NULL VARCHAR2(100) 
FILETYPE            CHAR(1)       
BNO                 NUMBER(10)
 * */
@Data
public class BoardAttachVO {
	private String uuid, uploadPath, fileName;
	private boolean fileType;
	private Long bno;
	
}
