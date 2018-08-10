<%@page import="com.ict.erp.common.DBCon"%>
<%@page import="com.ict.erp.common.DBUtils"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/common.jsp" %>
<%!
public List<Map<String,String>> getMemberList(){
	List<Map<String,String>> memberList = null;
	DBUtils dbu = new DBUtils(DBCon.getCon());
	try{
		memberList = dbu.selectList("select * from member_info ");
	}catch(SQLException e){
		System.out.println(e);
	}
	return memberList;
}
%>
<body>
<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>이메일주소</th>
				<th>생성자</th>
				<th>부서번호</th>
			</tr>
		</thead>
		<tbody>
<%
List<Map<String,String>> memberList = getMemberList();
for(Map<String,String> member : memberList){
%>
			<tr>
				<td><%=member.get("MINO")%></td>
				<td><%=member.get("MINAME")%></td>
				<td><%=member.get("MIID")%></td>
				<td><%=member.get("MIEMAIL")%></td>
				<td><%=member.get("CREUSR")%></td>
				<td><%=member.get("DINO")%></td>
			</tr>
<%
}
%>
		</tbody>
	</table>
</div>
</body>
</html>