<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Map<String,String> user = new HashMap<String,String>();
user.put("id",request.getParameter("id"));
user.put("pwd",request.getParameter("pwd"));
session.setAttribute("user", user);
%>
<script>
	alert("로그인 완료!!");
	location.href="/veiws/index";
</script>