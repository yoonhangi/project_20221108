<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-08
  Time: 오전 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>시작페이지</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
    <button class="btn btn-primary" onclick="saveFn()">회원가입</button>
</body>
<script>
    const saveFn = () => {
        // memberPages/save 주소로 이동
        location.href = "/memberPages/save";
    }
</script>
</html>
