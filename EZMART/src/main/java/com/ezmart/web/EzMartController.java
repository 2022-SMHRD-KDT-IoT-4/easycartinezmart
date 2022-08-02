package com.ezmart.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezmart.domain.MemberVO;
import com.ezmart.mapper.EzMartMapper;
import org.springframework.ui.Model;

@Controller
public class EzMartController {
	@Autowired
	EzMartMapper mapper;
	
	@RequestMapping("/main.do")
	public void main() {}
	
	// 1. 회원가입
	@RequestMapping("/Join.do")
	public @ResponseBody String memerJoin(MemberVO vo) {
		
		System.out.println(vo);
		
		mapper.memberJoin(vo);
		return "redirect:/main.do";
		
	}
	
	   @RequestMapping("/Login.do")
	   public String gologin() {
	      return "login";
	   }
	   
	   // 2. 로그인
	    @PostMapping("/Login.do")
	    public String login(MemberVO vo, Model model) {
	        MemberVO result = mapper.memberLogin(vo);
	        String url = "";
	        model.addAttribute("vo", vo);
	        if (result != null) {
	          url = "redirect:/main.do";
	       } else {
	          url = "redirect:/login.do";
	       }
	       
	       return url;
	    }
}