<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-14
  Time: 오후 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 수정</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <style>
    #update-form1 {
      width: 800px;
    }
  </style>
</head>
<body>
<div class="container" id="update-form1">
  <h2 class="text-center">회원 수정</h2>
  <form action="/update" method="post" name="updateForm">
    id: <input type="hidden" name="id" value="${member.id}" class="form-control" readonly>
    email: <input type="text" name="memberEmail" value="${member.memberEmail}" class="form-control" readonly>
    password: <input type="text" name="memberPassword" id="memberPassword" class="form-control">
    name: <input type="text" name="memberName" value="${member.memberName}" class="form-control">
    mobile: <input type="text" name="memberMobile" value="${member.memberMobile}" class="form-control">
    <input type="button" value="수정" class="btn btn-dark" onclick="updateMb()">
  </form>
</div>
</body>
<script>
  const updateMb = () => {
    const passwordDB = '${member.memberPassword}';
    const password = document.getElementById("memberPassword").value;
    if (passwordDB == password) {
      document.updateForm.submit();
    } else {
      alert("비밀번호가 일치하지 않습니다");
    }
  }
</script>
</html>
