<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String servletPath = request.getRequestURI();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>테스트 코드</title>
</head>
<body>
																				   <!-- 웹 브라우저에서 PUT과 DELETE 방식을 사용하기위해 method 속성에 이용 -->
<form:form action="/SpringView/jsp/article/${article.id}" commandName="article" method="delete">
<input type="submit" value="삭제"/>
</form:form>

																				   <!-- 웹 브라우저에서 PUT과 DELETE 방식을 사용하기위해 method 속성에 이용 -->
<form:form action="/SpringView/jsp/article/${article.id}" commandName="article" method="put">
<input type="submit" value="수정"/>
</form:form>

<form:form action="/SpringView/jsp/article/${article.id}" commandName="article" method="post">
<input type="submit" value="생성"/>
</form:form>
</body>
</html>