package com.ezmart.mapper;

import java.util.List;

import com.ezmart.domain.MemberVO;
import com.ezmart.domain.tbl_product;

public interface EzMartMapper {
	
	public int memberJoin(MemberVO vo);
	
	public MemberVO memberLogin(MemberVO vo);
	
	public List<tbl_product> productList();
	
	// 바코드로 상품정보 불러오기
	public List<tbl_product> getproduct(String p_barcode);
	
	// 검색
	public List<tbl_product> productSearch(String search);


}
