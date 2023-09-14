package com.jsp.board.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.jsp.board.model.BoardRepository;
import com.jsp.board.model.BoardVO;
import com.jsp.board.service.ContentService;
import com.jsp.board.service.DeleteService;
import com.jsp.board.service.GetListService;
import com.jsp.board.service.IBoardService;
import com.jsp.board.service.ModifyService;
import com.jsp.board.service.RegistService;
import com.jsp.board.service.SearchService;
import com.jsp.board.service.UpdateService;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   private IBoardService sv;
   private RequestDispatcher dp;
   
   public BoardController() {
      super();
   }

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      if(request.getMethod().equals("POST")) {
         request.setCharacterEncoding("UTF-8");
      }

      String uri = request.getRequestURI();
      uri = uri.substring(request.getContextPath().length()+1,uri.lastIndexOf("."));

      System.out.println("������ uri: "+uri);

      switch (uri) {

      case "write": 
         System.out.println("�۾��� �������� �̵� ��û!");
         response.sendRedirect("board/board_write.jsp");
         break;
         
      case "regist":
         System.out.println("�� ��� ��û�� ����!");
         sv = new RegistService();
         sv.execute(request, response);
         
         /*
            �� board_list.jsp�� �ٷ� �����̷�Ʈ�� �ϸ� �ȵɱ�?
            board_list.jsp���� �����ͺ��̽��κ��� ��ü �� ����� ��������
            ������ �ۼ����� ���� ���̱� �����Դϴ�. (jsp�� �ܼ��� �������� ���Ҹ� ����)
            ��Ʈ�ѷ��� �� ��� ��û�� �ٽ� ���� �� �ְԲ�
            sendRedirect()�� ����Ͽ� �ڵ� ��� ���û�� ������ �ϴ� �̴ϴ�.
            */
         
         response.sendRedirect("/JspBasic/list.board");
         break;

      case "list":
         System.out.println("�� ��� ��û�� ����!");
         sv = new GetListService();
         sv.execute(request, response);
         
         /*
          ���⼭ sendRedirect�� �ϸ� �ȵǴ� ����
          request ��ü�� list�� ��Ƽ� �����Ϸ� �ϴµ�, sendRedirect�� ����ϸ�
          ������ �ٷ� �����鼭 ������ request ��ü�� �Ҹ��ع����ϴ�.
          ���⼭�� forward ����� ����ؼ� request�� ���ϴ� jsp ���Ϸ� �����ؼ�
          ���ʿ��� ������ ���� �� �ֵ��� ó���ؾ� �մϴ�.
         */
         
//         response.sendRedirect("board/board_list.jsp"); (x)
         
         //request ��ü�� ���� ȭ����� ����ϱ� ���� forward ����� �����ϴ� ��ü
         //-> RequestDispatcher
         dp = request.getRequestDispatcher("board/board_list.jsp");
         dp.forward(request, response);
         break;
         
      case "content":
         System.out.println("�� �󼼺��� ��û�� ����!");
         sv = new ContentService();
         sv.execute(request, response);
         
         dp = request.getRequestDispatcher("board/board_content.jsp");
         dp.forward(request, response);
         break;
         
      case "modify":
    	  System.out.println("�� ���� �������� �̵� ��û!");
    	  sv = new ModifyService();
    	  sv.execute(request, response);
    	  
    	  dp = request.getRequestDispatcher("board/board_modify.jsp");
    	  dp.forward(request, response);
    	  break;
    	  
      case "update":
    	  System.out.println("�� ���� ��û�� ����!");
    	  sv = new UpdateService();
    	  //���Ӱ� �Է¹��� ���������� BoardVO ��ü�� �����ؼ� ������ �����ϼ���.
    	  //(���� ����Ʈ�� �����ϴ� ��ü�� ���ο� ��ü�� ��ü)
    	  //������ �Ϸ�Ǹ� ������ ���� �󼼺��� �������� ������ ������ �մϴ�.
    	  sv.execute(request, response);
    	  
    	  response.sendRedirect("/JspBasic/content.board?bId=" + request.getParameter("boardNo"));
    	  break;
    	  
      case "delete":
    	  System.out.println("�� ���� ��û�� ����!");
    	  sv = new DeleteService();
    	  sv.execute(request, response);
         
    	  response.sendRedirect("/JspBasic/list.board");
    
      case "search":
    	  System.out.println("�� �˻� ��û�� ����!");
    	  sv = new SearchService();
    	  sv.execute(request, response);
    	  
    	  dp = request.getRequestDispatcher("board/board_list.jsp");
    	  dp.forward(request, response);
    	  break;
    	  
      }

   }

}