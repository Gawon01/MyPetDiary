package com.diary.mypet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.diary.mypet.domain.DUserVO;
import com.diary.mypet.service.DUserService;

// user�� �����ϴ� ��û ó�� ��Ʈ�ѷ�

@Controller
@RequestMapping("user/*")
public class DUserController {

	@Autowired
	private DUserService service;

	// 1. �α��� �������� �̵��ϴ� ��û ó��
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void goLogin() {
		// �α��� �������� �ܼ� �̵�
	}

	// 2. �α��� ��û ó��
	// ����ڰ� �Է��� id�� pw�� �����ͼ� ��ġ�� �����Ͱ� ������ !null, ������ null
	// ���� ó�� -> ���� ���ͼ��ͷ�
	@RequestMapping(value = "loginPost", method = RequestMethod.POST)
	// public String login(DUserVO vo, HttpSession session, RedirectAttributes
	// attr)
	public void login(DUserVO vo, Model model, RedirectAttributes attr) {
		// 1) ���� �α��� �Լ� ����
		DUserVO login = service.login(vo);

		// 2) model�� login �� ���� (�α��� ������ ������, ���н� null)
		model.addAttribute("login", login);
		// attr.addFlashAttribute("msg", "false");

		// 3) ������� �ʴ� �������� �̵�

		// return "redirect:login";
		// ���ͼ��� ������ ���� ����
		/*
		 * // 2) �α��� ���� ���� Ȯ�� if (login == null) { // �α��� ���� // (1) session��
		 * null ���� session.setAttribute("login", null); // (2) �α��� ���� �޼��� ����
		 * attr.addFlashAttribute("msg", "false"); // (3) �α��� �������� �� �̵� return
		 * "redirect:login";
		 * 
		 * } else { // �α��� ���� // (1) ���ǿ� �α��� ���� ���� session.setAttribute("login",
		 * login); // (2) �̵��� �������� �����̷�Ʈ -> �ϴ� ��������.. return "redirect:/";
		 * 
		 * }
		 */
	}

	// 3. �α׾ƿ� ó�� -> ���� �ʱ�ȭ �ؾ���
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 1) ���� �ʱ�ȭ
		session.invalidate();
		// 2) ���� �������� �����̷�Ʈ
		return "redirect:/";

	}

}
