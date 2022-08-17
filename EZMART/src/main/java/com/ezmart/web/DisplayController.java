package com.ezmart.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezmart.domain.tbl_basketall;
import com.ezmart.mapper.DisplayMapper;

@Controller
public class DisplayController {
	
	 @Autowired
	  DisplayMapper mapper;
	   
	   
	   
	   @ResponseBody
	   @RequestMapping("/DisplayList.do")
	   public List<tbl_basketall> displaylist(Model model, String mb_id) {
	       List<tbl_basketall> list = mapper.displaylist(mb_id);
	       model.addAttribute("list", list);
	     System.out.println(list.get(1).getB_amount());
	       System.out.println(list);     

	       return list;
	   }
	 
	 

}
