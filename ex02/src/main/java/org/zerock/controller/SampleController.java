package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDAO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample2/*")
@Log4j
public class SampleController {
	
	@GetMapping("/basic")
	public String basic(SampleDAO dao, Model model) {
		log.info("basic--------------------------");
		log.info("dao ==> " + dao);
		model.addAttribute("list", dao);
		return "sample/basic";
	}
	
}
