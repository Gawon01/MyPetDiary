package com.diary.mypet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.diary.mypet.domain.DiaryVO;
import com.diary.mypet.service.DiaryService;

// diary/�� ���۵Ǵ� ��û ó�� ��Ʈ�ѷ�
@Controller
@RequestMapping("diary/*")
public class DiaryController {

	@Autowired
	private DiaryService service;

	// 1. �۾��� �������� �̵��ϴ� �޼ҵ�
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public void writeGet() {
		// /board/write.jsp�� �ܼ� �̵� �޼ҵ�
	}

	// 2. �ϱ� �ۼ� �� ���̺� �����ϴ� �޼ҵ�
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String writePost(DiaryVO vo, RedirectAttributes attr) {

		// 1) ����ڰ� �ۼ��� id(�ϴ� default 'root'), title, content ���̺� �Է�
		int result = service.insertDiary(vo);

		if (result < 0) {

			// �� ���� ���н� �ٽ� �� ���� ��������
			return "redirect:write";

		} else {

			// �� ���� ������ ���� ��� �������� �̵�
			// �̵��ϸ鼭 �� �ۼ� ���� �޼��� �����ؼ� ������
			attr.addFlashAttribute("msg", "�ϱⰡ ��ϵǾ����ϴ�.");
			return "redirect:result";
		}

	}

	// 3. �� ����/�� ����/�� ���� �� ���� �޼��� �����ִ� result.jsp�� �̵��ϴ� �޼ҵ�
	@RequestMapping(value = "result", method = RequestMethod.GET)
	public void toResult() {

	}

	// 4. ��� ���� ȭ������ �̵��ϴ� �޼ҵ�
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void goList(Model model) {
		// 1) ���̵� �������� ���̺� ������ �������� �Լ� ���� �� ����Ʈ�� ����
		List<DiaryVO> list = service.selectAllDiary("root");
		// 2) ����Ʈ �������� �� �����ϱ� ���ؼ� �� ��ü�� ����
		model.addAttribute("list", list);
		// 3) diary/list.jsp �������� �̵�

	}

}
