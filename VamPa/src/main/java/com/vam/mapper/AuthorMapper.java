package com.vam.mapper;

import java.util.List;

import com.vam.model.AuthorVO;
import com.vam.model.Criteria;

public interface AuthorMapper {
	
	// �۰� ���
	public void authorEnroll(AuthorVO author);
	
	// �۰� ���
	public List<AuthorVO> authorGetList(Criteria cri);
	
	// �۰� �� ��
	public int authorGetTotal(Criteria cri);
	
	// �۰� ��
	public AuthorVO authorGetDetail(int authorId);
	
	// �۰� ���� ����
	public int authorModify(AuthorVO author);
	
	// �۰� ���� ����
	public int authorDelete(int authorId);

}
