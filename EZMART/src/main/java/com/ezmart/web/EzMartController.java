package com.ezmart.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezmart.domain.MemberVO;
import com.ezmart.domain.tbl_basket;
import com.ezmart.domain.tbl_basketall;
import com.ezmart.domain.tbl_member;
import com.ezmart.domain.tbl_product;
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
    
    // 3. 상품목록 불러오기
    @ResponseBody
    @RequestMapping("/ProductList.do")
    public Map<String, Object> productList(){
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("datas", mapper.productList());
    	return result;
    }
    
    // 4. 상품정보 바코드로 불러오기
    @ResponseBody
    @RequestMapping("/getproduct.do")
    public Map<String, Object> getproduct(String p_barcode){
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("datas", mapper.getproduct(p_barcode));
    	
    	System.out.println(result);
    	
    	return result;
    }
    
 // 5. 상품목록 검색
    @ResponseBody
    @RequestMapping("/productSearch.do")
    public Object productSearch(String search){
   
    	  return mapper.productSearch("%"+search+"%");
    	
    }
  
    
	
    // 장바구니에 상품 담기
    @RequestMapping("/insertbasket.do")
    public String insertbasket(HttpSession session, tbl_member memvo, tbl_basket vo, Model model) {
    	String mb_id = (String)session.getAttribute("mb_id");
    	memvo.setMb_id(mb_id);
    	mapper.insertbasket(vo);
    	
    	return "insertbasket";
    }
	
    
	// 장바구니 리스트 
    @RequestMapping("/basketlist.do")
    public List<tbl_basketall> basketlist(HttpSession session, Model model, tbl_basketall vo, int b_seq) {
    	String mb_id = (String)session.getAttribute("mb_id");
    	
    	List<tbl_basketall> list = mapper.basketlist(mb_id);
    	
    	
    	model.addAttribute("list", list);
    	System.out.println(list);
    	
    	if(vo.getB_check().equals("true")) {
    		mapper.basketdelete(b_seq);
    	}

    	return list;
    }

    
    // 장바구니 상품 삭제하기
    @RequestMapping("/basketdelete.do")
    public String delete(int b_seq) {
    	mapper.basketdelete(b_seq);
    	return "basketlist";
    }
    
    
    
	    
	    
}