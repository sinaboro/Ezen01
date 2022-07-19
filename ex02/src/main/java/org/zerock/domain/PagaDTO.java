package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PagaDTO {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
}
