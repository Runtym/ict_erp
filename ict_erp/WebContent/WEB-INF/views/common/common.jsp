<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%

String uri = request.getRequestURI();
String rPath = request.getContextPath();
String title = "클라우드 프로젝트";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title><%=title%></title>
    <link href="<%=rPath%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=rPath%>/css/simple-sidebar.css" rel="stylesheet" />
	<link href="<%=rPath%>/css/common.css" rel="stylesheet"/>
	<script src="<%=rPath%>/vendor/jquery/jquery.min.js"></script>
    <script src="<%=rPath%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="<%=rPath%>/vendor/common.js"></script>
</head>

<script>
	window.addEventListener('load',function(){
		var btns = document.querySelectorAll('button[data-page]');
		for(var i=0,max=btns.length;i<max;i++){
			btns[i].setAttribute('type','button');
			btns[i].onclick = function(){
				location.href = this.getAttribute('data-page');
			}
		}
		btns = document.querySelectorAll('button[data-action]');
		for(var i=0,max=btns.length;i<max;i++){
			btns[i].setAttribute('type','button');
			btns[i].onclick = function(){
				this.form.action = this.getAttribute('data-action');
				this.form.submit();
			}
		}
	});
</script>