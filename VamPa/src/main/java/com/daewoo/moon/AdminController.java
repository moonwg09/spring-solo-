package com.daewoo.moon;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vam.model.AuthorVO;
import com.vam.model.BookVO;
import com.vam.model.Criteria;
import com.vam.model.PageDTO;
import com.vam.service.AdminService;
import com.vam.service.AuthorService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private AdminService adminService;
	
	//������ ���� ������ �̵�
	@RequestMapping(value="main", method = RequestMethod.GET)
	public void adminMainGET() throws Exception{
		
		logger.info("������ ������ �̵�");
	}
	
	@RequestMapping(value = "goodsManage", method = RequestMethod.GET)
	public void goodsManageGET(Criteria cri, Model model) throws Exception {
			
			logger.info("��ǰ ���(��ǰ ���) ������ ����");
			
			
			//��ǰ ����Ʈ ������
			List list = adminService.goodsGetList(cri);
			
			if(!list.isEmpty()) {
				model.addAttribute("list", list);
			} else {
				model.addAttribute("list", list);
				return;
			}
			
			// ������ �������̽� ������
			model.addAttribute("pageMaker", new PageDTO(cri, adminService.goodsGetTotal(cri)));
		}
	
	@RequestMapping(value = "goodsEnroll", method = RequestMethod.GET)
	public void goodsEnrollGET(Model model) throws Exception{
		logger.info("��ǰ ��� ������ ����");
		
		ObjectMapper objm = new ObjectMapper();
		
		List list = adminService.cateList();
		
		String cateList = objm.writeValueAsString(list);
		
		model.addAttribute("cateList", cateList);
		
		logger.info("���� ��............." + list);
		logger.info("���� ��............." + cateList);
	}
	
	//��ǰ ��ȸ ������
	@GetMapping({"/goodsDetail", "/goodsModify"})
	public void goodsGetInfoGET(int bookId, Criteria cri, Model model) throws JsonProcessingException {
		
		logger.info("goodsGetInfo()........." + bookId);
		
		ObjectMapper mapper = new ObjectMapper();
		
		//ī�װ� ����Ʈ ������
		model.addAttribute("cateList", mapper.writeValueAsString(adminService.cateList()));
		
		//��� ������ ���� ����
		model.addAttribute("cri", cri);
		
		//��ȸ ������ ����
		model.addAttribute("goodsInfo", adminService.goodsGetDetail(bookId));
	}
	
	//��ǰ ���� ����
	@PostMapping("/goodsModify")
	public String goodsModifyPOST(BookVO vo, RedirectAttributes rttr) {
		
		logger.info("goodsModifyPOST............." + vo);
		
		int result = adminService.goodsModify(vo);
		
		rttr.addFlashAttribute("modify_result", result);
		
		return "redirect:/admin/goodsManage";
	}
	
	//��ǰ ���� ����
	@PostMapping("/goodsDelete")
	public String goodsDeletePOST(int bookId, RedirectAttributes rttr) {
		
		logger.info("goodsDeletePOST..........");
		
		int result = adminService.goodsDelete(bookId);
		
		rttr.addFlashAttribute("delete_result", result);
		
		return "redirect:/admin/goodsManage";
	}
	
	@RequestMapping(value = "authorEnroll", method = RequestMethod.GET)
	public void authorEnrollGET() throws Exception {
		logger.info("�۰� ��� ������ ����");
	}
	
	@RequestMapping(value= "authorManage", method = RequestMethod.GET)
	public void authorManageGET(Criteria cri, Model model) throws Exception {
		logger.info("�۰� ���� ������ ����.............." + cri);
		
		//�۰� ��� ��� ������
		List list = authorService.authorGetList(cri);
		
		if(!list.isEmpty()) {
			model.addAttribute("list", list); // �۰� ���� ���
			
		} else {
			model.addAttribute("listCheck", "empty"); // �۰� �������� �ʴ� ��� 
		}
		
		// ������ �̵� �������̽� ������
		/*
		int total = authorService.authorGetTotal(cri);
		
		PageDTO pageMaker = new PageDTO(cri, total);
		
		model.addAttribute("pageMaker", pageMaker);
		*/
		
		model.addAttribute("pageMaker", new PageDTO(cri, authorService.authorGetTotal(cri)));
	}
	
	@RequestMapping(value="authorEnroll.do", method = RequestMethod.POST)
	public String authorEnrollPOST(AuthorVO author, RedirectAttributes rttr) throws Exception {
		
		logger.info("authorEnroll :" + author);
		
		authorService.authorEnroll(author); //�۰� ��� ���� ����
		
		rttr.addFlashAttribute("enroll_result", author.getAuthorName());  //��� ���� �޽���(�۰��̸�)
		
		return "redirect:/admin/authorManage";
	}
	
	@GetMapping({"/authorDetail", "/authorModify"})
	public void authorGetInfoGET(int authorId, Criteria cri, Model model) throws Exception {
		
		logger.info("authorDetail......" + authorId);
		
		// �۰� ���� ������ ����
		model.addAttribute("cri", cri);
		
		// ���� �۰� ����
		model.addAttribute("authorInfo" , authorService.authorGetDetail(authorId));
	}
	
	@PostMapping("/authorModify")
	public String authorModifyPOST(AuthorVO author, RedirectAttributes rttr) throws Exception {
		
		logger.info("authorModifyPOST......." + author);
		
		int result = authorService.authorModify(author);
		
		rttr.addFlashAttribute("modify_result", result);
		
		return "redirect:/admin/authorManage";
	}
	
	//�۰� ���� ����
	@PostMapping("/authorDelete")
	public String authorDeletePOST(int authorId, RedirectAttributes rttr) {
		
		logger.info("authorDeletePOST........");
		
		int result = 0;
		
		try {
			
			result = authorService.authorDelete(authorId);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			result = 2;
			rttr.addFlashAttribute("delete_result", result);
			
			return "redirect:/admin/authorManage";
		}
		
		rttr.addFlashAttribute("delete_result", result);
		
		return "redirect:/admin/authorManage";
	}
	
	
	@PostMapping("/goodsEnroll")
	public String goodsEnrollPOST(BookVO book, RedirectAttributes rttr) {
		
		logger.info("goodsEnrollPOST......." + book);
		
		adminService.bookEnroll(book);
		
		rttr.addFlashAttribute("enroll_result", book.getBookName());
		
		return "redirect:/admin/goodsManage";
	}
	
	@GetMapping("/authorPop")
	public void authorPopGET(Criteria cri, Model model) throws Exception {
		
		logger.info("authorPopGET........");
		
		cri.setAmount(5);
		
		// �Խù� ��� ������
		List list = authorService.authorGetList(cri);
		
		if(!list.isEmpty()) {
			model.addAttribute("list", list); //�۰� ���� ���
			
		}else {
			model.addAttribute("listCheck", "empty"); //�۰� �������� ���� ���
		}
		
		//������ �̵� �������̽� ������
		model.addAttribute("pageMaker", new PageDTO(cri, authorService.authorGetTotal(cri)));
	}
	
	

}
