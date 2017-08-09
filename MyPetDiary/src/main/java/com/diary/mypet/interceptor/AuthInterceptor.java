package com.diary.mypet.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// ���� ����� ���� ���� Ȯ��

public class AuthInterceptor implements HandlerInterceptor {

	// �������� �̵� ��
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	// ��û ó�� �� �� ������ �̵� ��
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	// ��Ʈ�ѷ� ���� ��
	// ��û���� �̵��ϱ� �� �α����� �Ǿ��ִ��� ���� Ȯ��
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// 1) ���� ��������
		HttpSession session = arg0.getSession();
		// 2) �α��� ���� Ȯ��
		if (session.getAttribute("login") == null) {
			// (1) �α��� �������� �̵� �� ��û�� ���� ��� �̸� ����
			String uri = arg0.getRequestURI();
			// (2) �Ķ���� ���ڿ� �������� -> �ڿ� �߰��� �Ķ���� ��
			String query = arg0.getQueryString();
			// (3) ������ ������ "" �ִٸ� ? ���·� �߰�
			if (query == null || query.equals("null")) {
				query = "";
			} else {
				query = "?" + query;
			}
			// (4) ���ǿ� dest Ű�� uri�� ���� ����
			session.setAttribute("dest", uri + query);

			// (5) �α��� �������� �����̷�Ʈ
			arg1.sendRedirect("/mypet/user/login");

			// (6) ��Ʈ�ѷ� ó�� ����
			return false;

		}
		// �α��� �� ���¶�� ��Ʈ�ѷ� ó��
		return true;
	}

}
