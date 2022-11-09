<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오전 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>글 목록</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #List-form {
            width: 800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div class="container" id="List-form">
<table class="table table-active text-center">
   <tr>
       <th>번호</th>
       <th>제목</th>
       <th>작성자</th>
       <th>작성날짜</th>
       <th>조회수</th>
   </tr>
    <c:forEach items="${boardList}" var="board">
    <tr>
        <td>${board.id}</td>
        <td>
            <a href="/board?id=${board.id}">${board.boardTitle}</a>
        </td>
        <td>${board.boardWriter}</td>
        <td>
            <fmt:formatDate value="${board.boardCreatedDate}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate>
        </td>
        <td>${board.boardHits}</td>
    </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
