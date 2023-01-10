<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<style>
    table{
        margin:auto;
        border-collapse: collapse;
        width : 100%;
    }
    .table-head td{
        border-bottom : 1px solid skyblue;
        padding : 10px;
        font-size: 20px;
        font-weight: 900;
        text-align: center;
    }
    .table-body td{
        font-size:20px;
        text-align: center;
    }
    .title-container{
        text-align: center;
    }

</style>
<div class="title-container"><h1>게시판</h1></div>
    <table>
        <tr class="table-head">
            <td>번호</td>
            <td>제목</td>
            <td>작성자</td>
            <td>파일</td>
            <td>날짜</td>
        </tr>
        <tr class="table-body">
            <td><a></a></td>
            <td><a></a></td>
            <td>aaaa</td>
            <td><img src="./resources/file-image.png" style="width:20px"></td>
            <td>aaaa</td>
        </tr>
    </table>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>