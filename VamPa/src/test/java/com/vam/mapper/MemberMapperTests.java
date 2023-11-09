package com.vam.mapper;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTests {
	
	@Autowired
	private MemberMapper membermapper; //MemberMapper.java �������̽� ������ ����
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	/*
	//ȸ������ ���� �׽�Ʈ �޼���
	@Test
	public void memberJoin() throws Exception {
		MemberVO member = new MemberVO();
		
		member.setMemberId("test");
		member.setMemberPw("test");
		member.setMemberName("test");
		member.setMemberMail("test");
		member.setMemberAddr1("test");
		member.setMemberAddr2("test");
		member.setMemberAddr3("test");
		
		membermapper.memberJoin(member); //���� �޼��� ����
		
	}*/
	/*
	//���̵� �ߺ��˻�
	@Test
	public void memberIdChk() throws Exception{
		String id="admin";
		String id2 = "test123";
		membermapper.idCheck(id);
		membermapper.idCheck(id2);
	}
	
	*/
	
	// MimeMessage ��ü�� ���� �����Ͽ� ������ �߼��ϴ� ���
	/*
	@Test
	public void mailSendTest() throws Exception	{
		String subject = "test ����";
		String content = "�ȳ��ϼ���" + "<img src=\"https://t1.daumcdn.net/cfile/tistory/214DCD42594CC40625\">";
		String from = "moonwg09@naver.com";
		String to = "moonwg123@naver.com";
		
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
			
			mailHelper.setFrom(from);
			
			mailHelper.setTo(to);
			mailHelper.setSubject(subject);
			mailHelper.setText(content, true);
			
			
			FileSystemResource file = new FileSystemResource(new File("C:\\test123.txt"));
			mailHelper.addAttachment("test.txt", file);
			
			mailSender.send(mail);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	/* �α��� ���� mapperm �޼��� �׽�Ʈ */
	@Test
	public void memberLogin() throws Exception{
		
		MemberVO member = new MemberVO(); // MemverVO ���� ���� �� �ʱ�ȭ
		
		/* �ùٸ� ���̵� ��� �Է°�� */
		member.setMemberId("admin23");
		member.setMemberPw("admin");
		
		/* �ùٸ��� ���� ���̵� ��� �Է°�� */
		//member.setMemberId("test1123");
		//member.setMemberPw("test1321321");
	
		membermapper.memberLogin(member);
		System.out.println("��� �� : " + membermapper.memberLogin(member));
	}
}
