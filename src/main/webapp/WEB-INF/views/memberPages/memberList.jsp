<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-10
  Time: 오전 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원 목록</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="container text-center">
  <table class="table table-hover">
    <tr>
      <th>번호</th>
      <th>이메일</th>
      <th>비밀번호</th>
      <th>이름</th>
      <th>조회</th>
      <th>삭제</th>
    </tr>
    <c:forEach items="${memberList}" var="member">
    <tr>
      <td>${member.id}</td>
      <td>${member.memberEmail}</td>
      <td>${member.memberPassword}</td>
      <td>${member.memberName}</td>
      <td><a href="/member?id=${member.id}">조회</a></td>
    </tr>
    </c:forEach>
  </table>
</div>

</body>
</html>
