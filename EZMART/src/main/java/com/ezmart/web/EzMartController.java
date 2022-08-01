package com.ezmart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezmart.mapper.EzMartMapper;

@Controller
public class EzMartController {
	@Autowired
	EzMartMapper mapper;
	
	@RequestMapping("/main.do")
	public void main() {}
}
