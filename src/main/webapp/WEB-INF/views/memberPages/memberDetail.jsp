<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-10
  Time: 오전 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원상세조회</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="container text-center">
    <table class="table table-hover">
        <tr>
            <th>번호</th>
            <td>${member.id}</td>
        </tr>
        <tr>
            <th>이메일</th>
            <td>${member.memberEmail}</td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td>${member.memberPassword}</td>
        </tr>
        <tr>
            <th>이름</th>
            <td>${member.memberName}</td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td>${member.memberMobile}</td>
        </tr>
    </table>
</div>
</body>
</html>
