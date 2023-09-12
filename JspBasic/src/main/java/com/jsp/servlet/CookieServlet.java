package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/login")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("kim1234") && pw.equals("kkk1111!")) {
			
			//# ��Ű ���� ���
			//1. ��Ű ��ü�� ���� - �������� �Ű������� ��Ű�� �̸��� ������ ������ �Է�(String)
			Cookie loginCoo = new Cookie("login_cookie", id);
			
			//2. ��Ű Ŭ������ setter �޼���� ��Ű�� �Ӽ��� ����.
			loginCoo.setMaxAge(5); //��Ű�� ��ȿ �ð� ����(��) 1�ð� -> 60 * 60
			
			//3. http ���� �� response ��ü�� ������ ��Ű�� ž���ؼ� Ŭ���̾�Ʈ���� ����.
			response.addCookie(loginCoo);
			
			response.sendRedirect("/JspBasic/cookie/cookie_welcome.jsp");
			
		} else {
			response.sendRedirect("/JspBasic/cookie/cookie_login.jsp");
		}
	}

}
