<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>부서코드</th>
					<th>부서명</th>
					<th>부서설명</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${diList}" var="di">
				<tr>
					<td>${di.diNum}</td>
					<td>${di.diCode}</td>
					<td>${di.diName}</td>
					<td>${di.diDesc}</td>
				</tr>
			</c:forEach>			
			</tbody>
		</table>
		<div class="page">
			<c:forEach	items="pList" var="p">
				${p},
			</c:forEach>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />