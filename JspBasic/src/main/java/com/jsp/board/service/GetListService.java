package com.jsp.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.BoardRepository;
import com.jsp.board.model.BoardVO;

public class GetListService implements IBoardService {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
      
      List<BoardVO> list = BoardRepository.getInstance().getList();
      
      //DB�κ��� ���޹��� �� ����� ���ǿ� �ֱ�� �� �Ʊ����ϴ�.
      //����-> �����͸� ��� �����ϱ� ���� ���� -> �� ����� ��� ������? ��?
      //�� ����� �� �� �����ϸ� ���̻� �ʿ䰡 ����. -> ��� ���ŵǴ� �������̱� ����
      //������ ������ �ڵ����� �Ҹ��ϴ� request ��ü�� �������
      
      request.setAttribute("boardList", list);

   }

}