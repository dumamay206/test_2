<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
<h1>User infor</h1>
<div class = "col-md-4">
	<img src="resources/feedback_images/${user.feedbackPhoto}"
									class="img-fluid rounded-start" />
	</div>
<ul>
	<li>FBPicture:</li>
	<li>Email : ${user.email}</li>
	<li>Text: ${user.feedback}</li>
</ul>
</body>
</html>