<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>

<style>
button {
	font-size: 50px;
	display: block;
	margin: auto;
	width: 200px;
	padding: 10px;
	margin-bottom: 10px;
	background-color: antiquewhite;
}
</style>
<script>
	function moveMember(url) {
		var uri = '${path}/member/'+url;
		location.href = uri;
	}

	function moveBoard(url) {
		var uri = '${path}/board/'+url;
		location.href = uri;
	}

	function moveHome() {
		var uri = '${path}';
		location.href = uri;
	}
	
	// scope -> 범위 4가지 : Context(application) / session / request / page
	// context : 서버 전체에서 사용되는 변수나 그런거
	// session : 브라우저 상에서 사용되는 변수
	// reqeust : 요청 시에 사용되는 거
	// page : page 안에서만 사용되는 변수
	// Get vs Post
	// Get method : URL에 파라미터를 넣어서 보냄 -> 예) https://naver.com?id=asdf&password=12345678
	// Post method : Http request Body에 집어 넣는것
	// http request -> 1st line : http/1.1(version 정보) / method 정보 / target(url 정보)
	// header : ip / host / 어디서 어디로 보내냐
	// body : data가 있을 때는 넣어서 보내고 없으면 없이 보냄 : {"aaa" : "aaa", "bbb" :"bbb"}
</script>
<body>
	<c:if test="${loginMember == null }">
	<button onclick="moveMember('login.do')">Login</button>
	<button onclick="moveMember('join.do')">Join</button>
	</c:if>
	
	<c:if test="${loginMember != null }">
	<button onclick="moveMember('update.do')">Update</button>
	<button onclick="moveMember('logout.do')">Logout</button>
	</c:if>
	
	
	<button onclick="moveBoard('list.do')">Board</button>
	<button onclick="moveHome()">Home</button>
</body>
</html>