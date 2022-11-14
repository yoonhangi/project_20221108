<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-11
  Time: 오전 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>수정 페이지</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="/board/update" method="post" name="updateFx">
        <input type="hidden" name="id" value="${board.id}" class="form-control" readonly>
        <input type="text" name="boardTitle" value="${board.boardTitle}" class="form-control">
        <input type="text" name="boardWriter" placeholder="작성자" class="form-control" value="${sessionScope.loginEmail}" readonly>
        <textarea name="boardContents" cols="30" rows="10" class="form-control" placeholder="수정할 내용을 입력하세요">${board.boardContents}</textarea>
<%--        <input type="file" class="form-control" name="boardFile">--%>
        <input type="button" value="수정" onclick="updateFn()" class="btn btn-primary">
    </form>
</div>
</body>
<script>
    const updateFn=()=>{
        document.updateFx.submit();
    }
</script>
</html>
