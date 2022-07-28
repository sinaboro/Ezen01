package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

@Service
public class SampleServiceImpl implements SampleService{

	
	
	@Override
	public Integer doAdd(String str1, String str2) throws Exception {
		return Integer.parseInt(str1) + Integer.parseInt(str2);
	}

}
