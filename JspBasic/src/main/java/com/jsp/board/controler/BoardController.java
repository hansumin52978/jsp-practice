package com.jsp.board.controler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.BoardRepository;
import com.jsp.board.model.BoardVO;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public BoardController() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}
		
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length()+1, uri.lastIndexOf("."));
		
		System.out.println("������ uri: " + uri);
		
		switch (uri) {
		
		case "write":
			System.out.println("�۾��� �������� �̵� ��û!");
			response.sendRedirect("board/board_write.jsp");
			break;
			
		case "regist":
			System.out.println("�� ��� ��û�� ����!");
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			BoardVO vo = new BoardVO();
			vo.setWriter(writer);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setRegDate(LocalDateTime.now()); // ���߿� DB���� �̷��� ���ؿ�;; ������
			
			BoardRepository.getInstance().regist(vo); // �� ��� �Ϸ�.
			
			/*
            �� board_list.jsp�� �ٷ� �����̷�Ʈ�� �ϸ� �ȵɱ�?
            board_list.jsp���� �����ͺ��̽��κ��� ��ü �� ����� ��������
            ������ �ۼ����� ���� ���̱� �����Դϴ�. (jsp�� �ܼ��� �������� ���Ҹ� ����)
            ��Ʈ�ѷ��� �� ��� ��û�� �ٽ� ���� �� �ְԲ�
            sendRedirect()�� ����Ͽ� �ڵ� ��� �� ��û�� ������ �ϴ� �̴ϴ�.
            */
			
			response.sendRedirect("/JspBasic/list.board");
			
			break;
			
		case "list":
			System.out.println("�� ��� ��û�� ����!");
			List<BoardVO> list = BoardRepository.getInstance().getList();
			
			//DB�κ��� ���޹��� �� ����� ���ǿ� �ֱ�� �� �Ʊ����ϴ�.
			//���� -> �����͸� ��� �����ϱ� ���� ����.-> �� ����� ��� ������? ��?
			//�� ����� �� �� �����ϸ� �� �̻� �ʿ� ����. -> ��� ���ŵǴ� �������̱� ����.
			//������ ������ �ڵ����� �Ҹ��ϴ� request ��ü�� �������.
			request.setAttribute("boardList", list);
			
			/*
			 ���⼭ sendRedirect�� �ϸ� �ȵǴ� ����.
			 request ��ü�� list�� ��Ƽ� �����Ϸ� �ϴµ�, sendRedirect�� ����ϸ�
			 ������ �ٷ� �����缭 ������ request ��ü�� �Ҹ��� �����ϴ�.
			 ���⼭�� forward����� ����ؼ� request�� ���ϴ� jsp ���Ϸ� �����ؼ�
			 ���ʿ��� ������ ���� �� �ֵ��� ó���ؾ� �մϴ�.
			 */
//			response.sendRedirect("board/board_list.jsp");
			
			//request ��ü�� ���� ȭ����� ����ϱ� ���� forward ����� �����ϴ� ��ü
			//-> RequestDispatcher, Dispatcher=���
			RequestDispatcher dp 
					= request.getRequestDispatcher("board/board_list.jsp");
			dp.forward(request, response);
			
			
			break;
			
		
		}
		
	}

}
