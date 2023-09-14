<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>게시글 등록 페이지</h2>
	<form action="/JspBasic/regist.board" method="post">
	<%-- placeholder -> <input> 요소에 입력될 값에 대한 짧은 힌트를 명시함.
		 text에 쓰기 전에 "작성자"라고 흐릿하게 써있음(작성을 하면 사라짐) --%>
		<input type="text" name="writer" placeholder="작성자"> <br>
		<input type="text" name="title" placeholder="글 제목"> <br>
		<textarea name="content" rows="5" cols="30" placeholder="게시글 내용을 입력하세요."></textarea>
		<%-- submit -> 서버의 폼 핸들러로 폼 데이터를 전송하는 제출버튼을 정의합니다. --%>
		<%-- onclick="return confirm('')" -> 지정한 문자열을 출력하면서 예,아니오 버튼이 뜨는 alert 경고창 --%>
		<button type="submit" onclick="return confirm('등록하시겠습니까?')">등록</button>
	</form>

</body>
</html>