package com.diary.mypet.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// �α��� ���ͼ���

public class LoginInterceptor implements HandlerInterceptor {

	// ��û ó�� �� �� ������ �̵� ��
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	// ��û ó�� �� �� ������ �̵� ��
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

		// 1) �α��� ���θ� Ȯ���ϱ� ���� ��Ʈ�ѷ����� �𵨿� ������ ���� ��������
		ModelMap modelMap = arg3.getModelMap();

		// 2) Object ��ü�� �𵨿��� ������ login ���� ����
		Object login = modelMap.get("login");

		// 3) �α��� ���� ���� �Ǵ�
		if (login == null) {
			// �α��� ����
			// �α��� �������� �����̷�Ʈ
			HttpSession session = arg0.getSession();
			session.setAttribute("loginmsg", "false");
			arg1.sendRedirect("login");

		} else {
			// �α��� ����
			// (1) session�� �α��� ���� ����
			HttpSession session = arg0.getSession();
			session.setAttribute("login", login);
			// (2) ��û�� ���� �ּ� Ȯ��
			String dest = (String) session.getAttribute("dest");
			if (dest == null) {
				arg1.sendRedirect("/mypet");
			} else {
				arg1.sendRedirect(dest);
			}

		}

	}

	// ��û ó�� ��
	// true ���� - Controller�� ���� ���� ��û ó��
	// false ���� - Controller�� �̵� ����
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {

		// �α��� ó�� �� ���� �α��� ������ ������ ����

		// 1) ���� ��������
		HttpSession session = arg0.getSession();
		// 2) �α��� ������ ������ ����
		if (session != null) {
			session.removeAttribute("login");
			session.removeAttribute("loginmsg");
		}

		// 3) ��Ʈ�ѷ��� ��û ó��
		return true;
	}

}
