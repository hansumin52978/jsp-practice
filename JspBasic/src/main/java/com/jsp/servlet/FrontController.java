package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ���� ���� url ���� ����

//1. ���丮 ����: ���丮 ���·� ������ �ش� ������Ʈ�� ã�Ƽ� �����ϴ� ����
//-> ������ url�θ� ������ ��û�� ���� ���� �ֽ��ϴ�.

//2. Ȯ���� ����: Ȯ���� ���·� ������ �ش� ������Ʈ�� ã�Ƽ� �����ϴ� ����
//*.board -> �տ� ��� ��ΰ� �����ϴ��� .board ��û���θ� ������ �ش� ������ �����ϰڴ�.

@WebServlet("*.user")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public FrontController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getRequestURI() -> String - ��û URI�� ����ϴ�.
		System.out.println("��û URI: " + request.getRequestURI());
		
		String uri = request.getRequestURI();
		//getContextPath() -> String - �� ���ø����̼��� ���ؽ�Ʈ ��Ʈ�� ��θ� ����ϴ�.
		String conPath =  request.getContextPath(); // -> /JspBasic (���ؽ�Ʈ ��Ʈ)
		
		// /JspBasic/join.user
		//substring -> ���ڿ��� Ư�� �κ��� �߶󳻴� �� ����մϴ�.
		//lastIndexOf -> "."�ڿ������� Ž�� ex)/JspBasic/join.user -> user�� ���´�
		uri = uri.substring(conPath.length() +1, uri.lastIndexOf("."));
		System.out.println("������ uri: " + uri);
		
		if(uri.equals("join")) {
			System.out.println("ȸ�� ���� ��û�� ���Ա���!");
		} else if(uri.equals("login")) {
			
		}
		
	}

}
