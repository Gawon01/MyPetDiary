package com.diary.mypet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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
	// �̹��� ���ε带 ���� �Ű� ���� MultipartHttpSerlvetRequest�� ����
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String writePost(MultipartHttpServletRequest request, RedirectAttributes attr) {

		// 1) ����ڰ� �ۼ��� id(�ϴ� default 'root'), title, content ���̺� �Է�
		int result = service.insertDiary(request);

		if (result < 1) {

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

	// 5. �󼼺��� ó�� �޼ҵ� - �󼼺��� �������� �̵�
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(@RequestParam("no") int no, @RequestParam("id") String id, Model model) {
		// 1) ���� �Լ��� �Ű������� ����ϱ� ���� DiaryVO ��ü ����
		DiaryVO vo = new DiaryVO();
		vo.setId(id);
		vo.setNo(no);

		// 2) 1���� �Ű� ������ ��ġ�ϴ� �����͸� ����ϴ� �Լ� ���� �� ����
		DiaryVO detail = service.selectOneDiary(vo);

		// 3) model ��ü�� ����
		model.addAttribute("detail", detail);

		// 4) detail �������� �̵�
	}

	// 6. ���� ó�� �޼ҵ�
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("no") int no, @RequestParam("id") String id, RedirectAttributes attr) {

		// 1) ���� �Ű� ������ ����� VO Ŭ���� �����ͼ� no�� id ����
		DiaryVO vo = new DiaryVO();
		vo.setNo(no);
		vo.setId(id);

		// 2) ���� �Լ� ����
		int res = service.deleteDiary(vo);
		System.out.println("Result for delete : " + res);

		// 3) ���� �޼��� ����
		attr.addFlashAttribute("msg", "�ϱ⸦ �����Ͽ����ϴ�.");

		// 4) ��� �������� �̵�
		return "redirect:result";

	}

	// 7. ���� �������� �̵� �޼ҵ�
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void goUpdate(@RequestParam("no") int no, @RequestParam("id") String id, Model model) {
		// 1) ���� �Ű� ���� VO Ŭ������ ���� -> ������...
		DiaryVO vo = new DiaryVO(no, id);
		// 2) ���� �޼ҵ� ����
		DiaryVO detail = service.goUpdate(vo);
		// 3) �� ��ü�� ������ ����
		model.addAttribute("detail", detail);
		// 4) ���� �������� �̵�
	}

	// 8. �Խñ� ���� �޼ҵ�
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MultipartHttpServletRequest request, RedirectAttributes attr) {

		// 1) service ���� �޼ҵ� ȣ��
		int result = service.updateDiary(request);
		System.out.println("Result for update : " + result);

		// 2) ���� ���� �޼��� ����
		attr.addFlashAttribute("msg", "�ϱ⸦ �����Ͽ����ϴ�.");

		// 3) ��� �������� �����̷�Ʈ
		return "redirect:result";
	}

}
