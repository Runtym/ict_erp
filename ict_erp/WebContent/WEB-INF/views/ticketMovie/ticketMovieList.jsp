<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
		<div class="container">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>선택</th>
						<th>번호</th>
						<th>영화명</th>
						<th>표가격</th>
						<th>상영시작일</th>
						<th>상영종료일</th>
						<th>개봉일</th>
						<th>설명</th>
						<th>포스터</th>
					</tr>
				</thead>
				<tbody id='menuTbody'>
				<c:forEach items="${tmList}" var="tm">
					<tr>
						<td><input type="checkbox" name="tmNum" value="${tm.tmNum}"></td>
						<td>${tm.tmNum}</td>
						<td>${tm.tmName}</td>
						<td>${tm.tmPrice}</td>
						<td>${tm.tmStartdat}</td>
						<td>${tm.tmEnddat}</td>
						<td>${tm.tmCredat}</td>
						<td>${tm.tmDesc}</td>
						<td><img src="${tm.tmImg}" width="100"></td>
					</tr>
				</c:forEach>
				</tbody>				
			</table>
			<button data-page="/views/tm/tmInsert">노래입력</button>
			<button type="button" onclick="deleteTM()">노래삭제</button>
		</div>
	</div>
</div>
<script>
	function deleteTM(){
		var obj = document.querySelector("input[type=checkbox]:checked");
		location.href ="/ticketMovie/ticketMovieDelete?tmNum=" + obj.value;
	}

</script>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />