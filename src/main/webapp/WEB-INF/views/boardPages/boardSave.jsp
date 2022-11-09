<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-08
  Time: 오후 4:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 작성</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #writer{
            margin-top: 100px;
            width: 800px;
        }
    </style>
</head>
<body>
<div class="container" id="writer">
    <form action="/board/save" method="post" enctype="multipart/form-data">
        <input type="text" name="boardTitle" placeholder="제목" class="form-control">
        <input type="text" name="boardWriter" placeholder="작성자" class="form-control" value="${sessionScope.loginEmail}">
        <textarea name="boardContents" cols="30" rows="10" class="form-control" placeholder="내용을 입력하세요"></textarea>
        <input type="submit" value="작성" class="btn btn-primary">
    </form>
</div>
</body>
</html>
