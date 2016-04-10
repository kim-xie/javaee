<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="updateUser.do" method="post">
编号：<input type="text" name="userId" value="${user.userId}" readonly="readonly"/><br>
姓名：<input type="text" name="userName" value="${user.userName}"/><br>
性别：<input type="text" name="userSex" value="${user.userSex}"/><br>
     <input type="submit" value="修改"/>
</form>

</body>
</html>