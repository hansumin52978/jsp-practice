package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@webServlet�� �����ϸ� ���� ������ ����ϰ� url mapping�ϴ� ������ ������ �� �ֽ��ϴ�.
@WebServlet("/resp")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResponseServlet() {
        super();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service �޼��尡 ȣ���!");
		
		//��û�� �Բ� �Ѿ�� ���̵� ����
		//�Ķ���� ������ ����� �Է� ���ϸ� null�� �ɴϴ�.
		int age = Integer.parseInt(request.getParameter("customerAge"));
		
		if(age > 20) {
			//���� �������� �̵���Ű�� �ʹ�.
			response.sendRedirect("/JspBasic/response/res_adult.jsp");
		} else {
			//�̼����� �������� �̵���Ű�� �;��.
			response.sendRedirect("/JspBasic/response/res_underage.jsp");
		}
	}

}
