<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-08
  Time: 오전 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/jquery.js"></script>
</head>
<body>
<div class="container">
    <form action="/login" method="post">
        email <input type="text" name="memberEmail" class="form-control" placeholder="이메일">
        password <input type="text" name="memberPassword" class="form-control" placeholder="비밀번호">
        <input type="button" class="btn btn-primary" onclick="logFn()" value="로그인">
    </form>
</div>
</body>
<script>
    const logFn = () => {
        const page = '${page}';
        location.href = "/board/paging?page=" + page;
    }
</script>
</html>
