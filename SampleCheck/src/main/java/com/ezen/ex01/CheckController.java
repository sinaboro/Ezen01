package com.ezen.ex01;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class CheckController {
	
	@RequestMapping("/check")
	public void testcheck(Model model) {
		System.out.println("------------------");
		System.out.println("model + " + model);
		model.addAttribute("model", "abcdefg");
	}
}
