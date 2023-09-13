package com.jsp.board.model;

import java.util.ArrayList;
import java.util.List;

//�츮�� DB�� �ȹ����;;;;;
//DB ������ ����� List�� �ϳ� �����ؼ� BoardVO ��ü�� �����ϰڽ��ϴ�.
public class BoardRepository {
	
	//�ܺο��� �� ����Ʈ�� ���� �������� ���ϰ� �ϰڽ��ϴ�.
	private List<BoardVO> boardList = new ArrayList<>();
	
	public BoardRepository() {}
	
	private static BoardRepository repository = new BoardRepository();
	
	public static BoardRepository getInstance() {
		return repository;
	}
	
	//�Խñ� ��� �޼���
	public void regist(BoardVO vo) {
		boardList.add(vo);
	}

	//��ü �Խù�(BoardList)�� ��� �ִ� ����Ʈ�� ����
	public List<BoardVO> getList() {
		return boardList;
	}
	
}
