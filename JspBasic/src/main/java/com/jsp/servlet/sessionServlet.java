package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/login")
public class sessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public sessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //���ڿ� ���ڵ�
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("abc1245") && pw.equals("aaa1111!")) {
			
			/*
            - ������ http ��� �����͸� �����ϱ� ���� �������� ����մϴ�.
            - ���ǿ� �����͸� ������ ���� session ��ü�� �޼��� setAttribute()
             �޼��带 ����մϴ�.
            - �ش� �޼����� ù��° �Ű������� ���� �������� �̸��� ���ϰ�, �� ��° �Ű�������
             ���ǿ� ������ ���� �����մϴ�.
            */
			HttpSession session = request.getSession();
			session.setAttribute("user_id", id);
			
			response.sendRedirect("/JspBasic/session/session_welcome.jsp");
			
	} else {
		response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter w = response.getWriter();
        
        String htmlCode = "";
        htmlCode += "<script>\r\n"
                + "        alert('�α��ο� �����߽��ϴ�.');\r\n"
                + "        history.back();\r\n"
                + "    </script>\r\n"
                + "";
        
        w.write(htmlCode);
        w.flush();
        w.close();
	}
}
}
