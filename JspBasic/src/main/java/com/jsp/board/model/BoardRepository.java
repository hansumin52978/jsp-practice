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
	
	//�� ��ȣ�� ������ Ư�� �Խù� ��ü�� �����ϴ� �޼���
	public BoardVO getContent(int bId) {
		return boardList.get(bId-1);
	}
	
	//��ü�� �����ϴ� �޼���
	public void update(BoardVO vo, int bId) {
		boardList.set(bId-1, vo);
	}
	
	//��ü�� �����ϴ� �޼���
	public void delete(int bId) {
		boardList.remove(bId-1);
	}
	
	//��ü�� �˻��ϴ� �޼���
	public List<BoardVO> search(String keyword) {
		List<BoardVO> searchList = new ArrayList<>();
		
		for(BoardVO vo : boardList) {
			if(vo.getWriter().contains(keyword)) {
				searchList.add(vo);
			}
		}
		
		return searchList;
	}
	
}
