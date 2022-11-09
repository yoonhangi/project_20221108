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
<a href="/save" class="btn btn-primary">회원가입</a>
<a href="/login" class="btn btn-dark">로그인</a>
<button class="btn btn-primary" onclick="listFn()">글목록</button>
</body>
<script>
    const listFn = () => {
        const page = '${page}';
        location.href = "/board/paging?page=" + page;
    }
</script>
</html>
