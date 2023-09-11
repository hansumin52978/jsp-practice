package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	- �����̶� �� �������� �ڹ� ���θ� �����ϴ� ���Դϴ�.
	��, jsp ������ �ڹ� ���θ� �����ϴ� ���Դϴ�. 
	��Ĺ�� ����ؼ� jsp ������ �ڵ����� class�� ��ȯ�ߴٸ�
	������ ���� Ŭ������ �����ؼ� Ŭ������ ��û�� ó���� ���ڴ� ���Դϴ�.
*/

public class ServletBasic extends HttpServlet{
	
	//# ���� Ŭ������ ����� ���
	//1. HttpServlet Ŭ������ ���
	
	//2. �����ڸ� ���� (����)
	public ServletBasic() {
		System.out.println("�������� ��û�� ����!");
		System.out.println("���� ��ü�� ������!!!");
	}
	
	//3. HttpServlet�� �����ϴ� ��� �޼��带 ������ �°� �������̵�(������)�մϴ�.
    //Ŭ���̾�Ʈ�� ��� ��û�� ���� �� ������ ��� ó���� �Բ� ������ �� ���ΰ�?
    //init(), doGet(), doPost(), service(), destroy()...
	
	@Override
	public void init() throws ServletException {
		/*
        - ������ ��û�� ������ �� ó�� ������ ������ �ۼ�.
        - init()�� �����̳�(���� ���α׷�)�� ���� ���� ��ü�� ������ ��
        ���� 1ȸ �ڵ����� ȣ��˴ϴ�.
        - ��ü�� �����ڿ� ����� ������ �����մϴ�.
        */
       System.out.println("init �޼��� ȣ��!");
		super.init();
	}
	
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		/*
//        - ������ ��û�� ������ �� �ڵ����� ȣ��.
//        - get, post ���� ���� ������ ��� ��û�� ������ ������ �� �ִ�.
//    	- �Ű������� ��û, ���� ���� ��ü�� ���޵˴ϴ�. 
//        */
//		
////		// ��û ����� ����?
////		String method = request.getMethod();
////		// ��û URL�� ����?
////		String uri = request.getRequestURI();
////		// ��û �Ķ����
////		String queryString = request.getQueryString();
////		// ��û�� ���� IP �ּ�
////		String addr = request.getRemoteAddr();
////		
////		System.out.println("----- �� Ȯ���ϱ� -----");
////		System.out.println("method: " + method);
////		System.out.println("uri " + uri);
////		System.out.println("queryString: " + queryString);
////		System.out.println("addr: " + addr);
//		
//		//��û�� �Բ� ���޵� �Ƕ���͸� ������ ��� ���
//		String account = request.getParameter("account");
//		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		
//		System.out.println("���̵�: " + account);
//		System.out.println("��й�ȣ: " + password);
//		System.out.println("�̸�: " + name);
//		
//		//�����ϰ��� �ϴ� content�� Ÿ�԰� ���ڿ� ���ڵ��� ����.
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		
//		//���� ȭ�� ����
//		//�ڹ� Ŭ�������� �������� �ٷ� ������ �����ϱ� ���ؼ���
//		//PrintWriter ��ü�� ����մϴ�.
//		PrintWriter w = response.getWriter();
//		
//		String htmlCode = "";
//		
//		htmlCode += "<!DOCTYPE html> \r\n" 
//                + "<html>\r\n" 
//                + "<head>\r\n" 
//                + "<meta charset=\"UTF-8\"> \r\n"
//                + "<title>���� ��û�� ���� ����!</title>"
//                + "</head>\r\n"
//                + "<body>\r\n" 
//                + "\r\n"
//                + "\t���̵�: " + account + "<br>\r\n"
//                + "\t��й�ȣ: " + password + "<br>\r\n"
//                + "\t�̸�: " + name + "\r\n"
//                + "</body>\r\n"
//                + "</html>";
//		
//		w.write(htmlCode); //���ۿ� �����ϰ��� �ϴ� ������ �ۼ��ϱ�
//		w.flush(); //���۸� ���鼭 �ۼ��� ������ �������� �о��
//		w.close(); //��ü ����
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//http ��� �� get ��û�� �߻����� �� �ڵ����� ȣ��Ǵ� �޼���
		//�Ű������� ���尴ü request�� response�� ���޵ǹǷ�
		//��ü�� �޼��带 ���� �Ķ���͸� �������ų�, ������ �̵��� �����մϴ�.
		System.out.println("doGet �޼��尡 ȣ���!");
		
		System.out.println("���̵�: " + req.getParameter("account"));
		System.out.println("��й�ȣ: " + req.getParameter("password"));
		System.out.println("�̸�: " + req.getParameter("name"));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//http ��� �� post ��û�� �߻����� �� �ڵ����� ȣ��Ǵ� �޼���
        //doGet�� ���������� ���尴ü request�� response�� �Ű������� �޽��ϴ�.
		//post������� ��û�� ������ ��, �Բ� ���۵� �Ķ���͸� ������ ����
		//���ڵ� �۾��� �ٽ� ��ġ�ž� �մϴ�.
		
		req.setCharacterEncoding("UTF-8");
		
		System.out.println("doPost �޼��尡 ȣ���!");
		
		System.out.println("���̵�: " + req.getParameter("account"));
		System.out.println("��й�ȣ: " + req.getParameter("password"));
		System.out.println("�̸�: " + req.getParameter("name"));
	}
	
	@Override
	public void destroy() {
		//���� ��ü�� �Ҹ�� �� ȣ��Ǵ� �޼��� (��ü �Ҹ� �� 1ȸ �ڵ����� ȣ��)
		//��κ� ��ü �ݳ��̳� �Ҹ� � ���.
		System.out.println("destroy �޼��尡 ȣ���!");
	}
		


}
