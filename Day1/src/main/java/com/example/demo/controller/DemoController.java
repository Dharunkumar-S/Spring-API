package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	
	@Value("World")
	private String data;
	
	@ResponseBody
	@RequestMapping("/")
	public String Hello() {
		return "Hello "+data;
	}
	
}
