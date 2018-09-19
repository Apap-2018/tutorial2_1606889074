package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping({"/challenge", "challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required = false, defaultValue = "0") String a, @RequestParam(value = "b", required = false, defaultValue = "0") String b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		String hm = "h";
		String multipleHm = "";
		
		if (Integer.parseInt(a) == 0) {
			a = "1";
		}
		
		if (Integer.parseInt(b) == 0) {
			b = "1";
		}
		
		for (int i = 0; i<Integer.parseInt(a); i++) {
			hm+="m";
		}
		
		for (int i = 0; i<Integer.parseInt(b); i++) {
			multipleHm+=hm+" ";
		}
		
		model.addAttribute("kataHm", multipleHm);
		
		return "generator";
	}
}
