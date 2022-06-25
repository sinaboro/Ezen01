package com.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("Select sysdate from dual")
	public String getTime();
	
	public String getTime2();

}
