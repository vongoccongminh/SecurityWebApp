<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<h3>Login Page</h3>
	
	<p style="color:red;">${errorMessage}</p>
	
	<form method="post" action="${pageContext.request.contextPath}/login">
		<input type="hidden" name="redirectID" value="${param.redirectID}" />
		<table border="0">
			<tr>
				<td>User Name</td>
				<td><input type="text" name="userName" value="${user.userName}" /></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td> <input type="password" name="password" value="${user.password}" /></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="Submit" />
					<a href="${pageContext.request.contextPath}">Cancel</a>
				</td>
		</table>
	</form>
	
	<p style="color:blue;">Login with:</p>
	employee/123
	manager/456
</body>
</html>