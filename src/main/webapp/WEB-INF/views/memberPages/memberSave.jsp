<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-08
  Time: 오전 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #save-form{
            width: 800px;
        }
    </style>
</head>
<body>
<div class="container">
  <form action="/save" method="post" id="save-form">
   email <input type="text" name="memberEmail" class="form-control" placeholder="이메일">
   password <input type="text" name="memberPassword" class="form-control" placeholder="비밀번호">
   name <input type="text" name="memberName" class="form-control" placeholder="이름">
   mobile <input type="text" name="memberMobile" class="form-control" placeholder="전화번호">
      <input type="button" value="회원가입" class="btn btn-dark" onclick="save()">
  </form>
</div>
</body>
<script>
    const save=()=>{
        location.href = "/login";
    }
</script>
</html>
