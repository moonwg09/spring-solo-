package com.vam.service;

import com.vam.model.MemberVO;

public interface MemberService {
	
	//ȸ������
	public void memberJoin(MemberVO member) throws Exception;
	
	//���̵� �ߺ� �˻�
	public int idCheck(String memberId) throws Exception;

	//�α���
	public MemberVO memberLogin(MemberVO member) throws Exception;
}
