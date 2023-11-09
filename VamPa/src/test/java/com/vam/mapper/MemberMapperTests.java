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
	private MemberMapper membermapper; //MemberMapper.java 인터페이스 의존성 주입
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	/*
	//회원가입 쿼리 테스트 메서드
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
		
		membermapper.memberJoin(member); //쿼리 메서드 실행
		
	}*/
	/*
	//아이디 중복검사
	@Test
	public void memberIdChk() throws Exception{
		String id="admin";
		String id2 = "test123";
		membermapper.idCheck(id);
		membermapper.idCheck(id2);
	}
	
	*/
	
	// MimeMessage 객체를 직접 생성하여 메일을 발송하는 방법
	/*
	@Test
	public void mailSendTest() throws Exception	{
		String subject = "test 메일";
		String content = "안녕하세요" + "<img src=\"https://t1.daumcdn.net/cfile/tistory/214DCD42594CC40625\">";
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
	
	/* 로그인 쿼리 mapperm 메서드 테스트 */
	@Test
	public void memberLogin() throws Exception{
		
		MemberVO member = new MemberVO(); // MemverVO 변수 선언 및 초기화
		
		/* 올바른 아이디 비번 입력경우 */
		member.setMemberId("admin23");
		member.setMemberPw("admin");
		
		/* 올바르지 않은 아이디 비번 입력경우 */
		//member.setMemberId("test1123");
		//member.setMemberPw("test1321321");
	
		membermapper.memberLogin(member);
		System.out.println("결과 값 : " + membermapper.memberLogin(member));
	}
}
