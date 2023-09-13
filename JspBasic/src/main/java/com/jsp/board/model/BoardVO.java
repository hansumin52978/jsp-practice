package com.jsp.board.model;

import java.time.LocalDateTime;

/*
 ��(model) ������ ����Ͻ� ������ ó���ϴ� ������ ����մϴ�.
 ����Ͻ� �����̶�, �ܺ� ���α׷��� ���� �۾� ���� �����ϴ� �����Դϴ�. (�����ͺ��̽� ��...)
 
 VO (value object)
 : ������ ���̽����� ��ȸ�� ��, ���� ���α׷����� ��û�� �Բ� ���� �� ����
 �����ؼ� ����ϴ� ���� ���õ� ��ü�Դϴ�.
 VO Ŭ������ �ڹ� �� Ŭ������ �����մϴ�.
 
 �ڹ� �� (java bean)
 �� ���α׷��ֿ��� ��� ��ü�� ������ ���� ���� ����̸�, �ڹ� ���� �ۼ���
 Ŭ������ �Ϲ������� �θ��� ȣĪ�Դϴ�.
 
 �ڹ� ���� �����ϱ� ���� �Ծ��� �����մϴ�.
 1. ����(ĸ��ȭ)�� �����ؼ� Ŭ������ �����մϴ�. (���� private, getter/setter)
 2. getter �޼���� �Ű������� �������� �ʾƾ� �Ѵ�.
 3. �����ڴ� �Ű����� ���� �ʴ� ������(�ʼ�), �Ű����� �޴� ������(����)�� �����Ѵ�.
 4. ��� getter/setter �޼���� ���� ������ public �̾�� �Ѵ�.
 */

public class BoardVO {
	
	private String writer;
	private String title;
	private String content;
	private LocalDateTime regDate;
	
	public BoardVO() {} // �⺻ ������ �ʼ�!

	public BoardVO(String writer, String title, String content, LocalDateTime regDate) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	} // �Ű����� �޴� ������ ����!

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardVO [writer=" + writer + ", title=" + title + ", content="
	+ content + ", regDate=" + regDate + "]";
	}
	
	// getter/setter toString ����!

}
