<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="userList.do" method="post">
姓名：<input type="text" name="userName"/>
     <input type="submit" value="查询"/>
     <input type="button" value="添加" onclick="javascript:window.location='<%=basePath%>userinfo/user_add.jsp'"/>
 </form>
 <table width="80%"  border="1px" style="text-align:center">
 	<tr>
 		<td>用户编号</td>
 		<td>用户姓名</td>
 		<td>用户性别</td>
 		<td></td>
 	</tr>
 	<c:forEach items="${list}" var="user">
 	<tr>
 		<td>${user.userId}</td>
 		<td>${user.userName}</td>
 		<td>${user.userSex}</td>
 		<td>
 		<a href="loadUpdate.do?userId=${user.userId}">修改</a>
 		<a href="deleteUser.do?userId=${user.userId}">删除</a>
 		</td>
 	</tr>
 	</c:forEach>
 </table>
</body>
</html>