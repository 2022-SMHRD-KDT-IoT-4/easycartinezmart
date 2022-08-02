package com.ezmart.mapper;

import com.ezmart.domain.MemberVO;

public interface EzMartMapper {
	
	public int memberJoin(MemberVO vo);
	
	public MemberVO memberLogin(MemberVO vo);

}
