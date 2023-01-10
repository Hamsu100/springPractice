<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<style>
    label {
        font-size: 20px;
        margin-right: 10px;
    }
    input{
        font-size:20px;
    }
    table{
        border:1px solid black;
        padding: 10px;
        margin:auto
    }
    input[type=submit]{
        margin:auto;
    }
</style>
<form action="${path }/member/login.do" method="post">
    <table>
        <tr>
            <td><label for="id">ID</label></td>
            <td><input type="text" name="id" id="id"></td>
        </tr>
        <tr>
            <td><label for="pwd">Password</label></td>
            <td><input type="password" name="pwd" id="pwd"></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:right"><input type="submit" value="Login" style="font-size: 20px;"></td>
        </tr>
    </table>
</form>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>