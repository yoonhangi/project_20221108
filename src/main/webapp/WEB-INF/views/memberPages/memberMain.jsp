<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-08
  Time: 오전 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인 페이지</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<h2>환영합니다</h2>
<button class="btn btn-danger" onclick="logout()">로그아웃</button>
</body>
<script>
    const logout = () => {
        location.href = "/logout";
    }
</script>
</html>
