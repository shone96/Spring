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
<title>�׽�Ʈ �ڵ�</title>
</head>
<body>
																				   <!-- �� ���������� PUT�� DELETE ����� ����ϱ����� method �Ӽ��� �̿� -->
<form:form action="/SpringView/jsp/article/${article.id}" commandName="article" method="delete">
<input type="submit" value="����"/>
</form:form>

																				   <!-- �� ���������� PUT�� DELETE ����� ����ϱ����� method �Ӽ��� �̿� -->
<form:form action="/SpringView/jsp/article/${article.id}" commandName="article" method="put">
<input type="submit" value="����"/>
</form:form>

<form:form action="/SpringView/jsp/article/${article.id}" commandName="article" method="post">
<input type="submit" value="����"/>
</form:form>
</body>
</html>