<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><spring:message code="login.form.title"/></title>
</head>
<body>
<form:form commandName="login">
<form:errors/>
<p>
											<!-- label.properties���� ������ �ڵ� �� -->
	<label for="loginType"><spring:message code="login.form.type"></spring:message></label>
	<form:select path="loginType" items="${loginTypes}"/>
									<!-- LoginController�� referenceData�޼ҵ��� @ModelAttribute�� -->
</p>
<p>
	<label for="id"><spring:message code="login.form.id"></spring:message></label>
	<form:input path="id" id="id"/> <!-- path���� �ڹٺ�(LoginCommand)�� �ʵ��� ��ġ -->
	<form:errors path="id"/>
</p>
<p>
	<label for="password"><spring:message code="login.form.password"></spring:message></label>
	<form:password path="password" id="password"/>
	<form:errors path="password"/>
</p>
<p>
	<input type="submit" value="<spring:message code="login.form.submit"/>">
</p>
</form:form>
</body>
</html>