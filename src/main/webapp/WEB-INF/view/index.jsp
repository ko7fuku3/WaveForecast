<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList" %>
<%
String windDirection = (String) request.getAttribute("windDirection");
String windSpeed = (String) request.getAttribute("windSpeed");
String swellDirection = (String) request.getAttribute("swellDirection");
String waveSize = (String) request.getAttribute("waveSize");
String waveCondition = (String) request.getAttribute("waveCondition");
ArrayList<String> resultList = (ArrayList) request.getAttribute("waveCondition");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>波予想</title>
</head>
<body>

	<form method="post" action="./WaveForecastServlet">
		<table>
			<tr>
				<th>風向</th>
				<td><input type="text" name="windDirection" autocomplete="off" required></td>
			</tr>
			<tr>
				<th>風速</th>
				<td><input type="text" name="windSpeed" autocomplete="off" required></td>
			</tr>
			<tr>
				<th>うねりの向き</th>
				<td><input type="text" name="swellDirection" autocomplete="off" required></td>
			</tr>
			<tr>
				<th>波高</th>
				<td><input type="text" name="waveSize" autocomplete="off" required></td>
			</tr>
		</table>
		<button type="submit">予想する</button>
	</form>
	
	<% if (resultList != null) { %>
		波のサイズ：<c:out value="${resultList.get(0)}"></c:out>
		波のコンディション：<c:out value="${resultList.get(1)}"></c:out>
	<% } %>
</body>
</html>