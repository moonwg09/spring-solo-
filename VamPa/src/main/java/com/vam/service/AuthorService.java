package com.vam.service;

import java.util.List;

import com.vam.model.AuthorVO;
import com.vam.model.Criteria;

public interface AuthorService {
	
	//�۰� ���
	public void authorEnroll(AuthorVO author) throws Exception;
	
	//�۰� ���
	public List<AuthorVO> authorGetList(Criteria cri) throws Exception;
	
	//�۰� �� ��
	public int authorGetTotal(Criteria cri) throws Exception;
	
	// �۰� �� ������
	public AuthorVO authorGetDetail(int authorId) throws Exception;
	
	// �۰� ���� ����
	public int authorModify(AuthorVO author) throws Exception;
	
	// �۰� ���� ����
	public int authorDelete(int authorId);

}
