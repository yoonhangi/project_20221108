<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오전 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 상세조회</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #list-detail {
            width: 800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div class="container" id="list-detail">
    <table class="table table-hover text-center">
        <tr>
            <th>번호</th>
            <td>${board.id}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${board.boardTitle}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${board.boardContents}</td>
        </tr>
        <tr>
            <th>작성날짜</th>
            <td>${board.boardCreatedDate}</td>
        </tr>
        <tr>
            <th>조회수</th>
            <td>${board.boardHits}</td>
        </tr>
    </table>
</div>
</body>
</html>
