<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>게시글 목록</h2>
	<c:choose>
		<c:when test="${boardList.size() == 0}">
			<h3>*** 작성된 게시물이 하나도 없습니다. ***</h3>
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
					<th>비고</th>
				</tr>
				<%-- c:forEach의 속성인 varStatus를 활용하면
					현재 사용중인 반복문의 여러가지 속성을 사용할 수 있습니다. 
					${status.count}: 1부터의 순서
					${status.index}: 0부터의 순서
					${status.current}: 현재 아이템
					--%>
				<c:forEach var="b" items="${requestScope.boardList}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${b.writer}</td>
						<td>
							<a href="/JspBasic/content.board?bId=${status.count}">${b.title}</a>
						</td>
						<td>
						<%-- <fmt:parseDate> -> 문자열로 표시된 날짜 및 시간 값을 java.util.Date로 파싱해 주는 태그 --%>
						<%-- <fmt:formatDate -> 날짜 정보를 담고 있는 객체를 포맷팅하여 출력할 때 사용하는 태그 --%>
						<%-- pattern = "패턴" -> 직접 파싱할 때 사용할 양식을 지정한다. --%>
						<%-- both 형식 : 2023. 9. 13. 오후 7:40:50 --%>
						<%-- date 형식 : 오후 7:40:50 --%>
						<%-- time 형식 : 2023. 9. 13. --%>
							<fmt:parseDate value="${b.regDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
							<fmt:formatDate value="${parsedDateTime}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" />
						</td>
						<td>
							<a href="/JspBasic/delete.board?bId=${status.count}">[삭제]</a>
						</td>
					</tr>
				</c:forEach>	
			</table>
		</c:otherwise>
	</c:choose>
	
	<br>
	
	<%-- 
		사용자가 입력창에 작성자 이름을 입력하고 검색을 누르면,
		해당 작성자가 작성한 글들을 모두 담아서 가져 오시면 됩니다.
		해당 문자열이 포함되어 있는 지의 여부를 확인하는 메서드는
		String 클래스의 contains() 입니다.
	 --%>
	<form action="/JspBasic/search.board">
		<input type="text" name="keyword" placeholder="작성자 이름을 입력하세요.">
		<input type="submit" value="검색">
	</form>
	
	<br>	
	
	<a href="/JspBasic/write.board">새 글 작성하기</a>

</body>
</html>