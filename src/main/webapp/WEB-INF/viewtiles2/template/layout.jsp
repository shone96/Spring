<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset=EUC-KR">
<title><tiles:getAsString name="title"/></title>
</head>
<body>
<tiles:insertAttribute name="header"/>
<hr/>
<tiles:insertAttribute name="body"/>
<hr/>
<tiles:insertAttribute name="footer"/>
<hr/>
</body>
</html>