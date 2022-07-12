package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample/*")
public class SampleController {
	
	@RequestMapping("/basic")
	public void basic() {
		log.info("basic-------------");
	}
	@RequestMapping("/basic2")
	public String basic2() {
		log.info("basic-------------");
		return "basic";
	}
}
