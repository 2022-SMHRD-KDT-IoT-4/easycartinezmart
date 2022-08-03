package com.ezmart.mapper;

import java.util.List;

import com.ezmart.domain.MemberVO;
import com.ezmart.domain.tbl_product;

public interface EzMartMapper {
	
	public int memberJoin(MemberVO vo);
	
	public MemberVO memberLogin(MemberVO vo);
	
	public List<tbl_product> productList();

}
