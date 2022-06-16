package com.saeyan.dto;



import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * create table employees(
    id varchar2(10) not null PRIMARY key,
    pass varchar2(10) not null,
    name varchar2(20),
    lev char(1) default 'A',
    enter date DEFAULT sysdate,
    gender char(1) DEFAULT 1,
    phone varchar2(30)    
);
 */
@Setter
@Getter
@ToString
public class EmployeesVO {
	private String id ;
	private String pass;
	private String name;
	private String lev;
	private Date enter;
	private String gender;
	private String phone;
	
}
