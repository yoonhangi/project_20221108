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
    <script src="/resources/js/jquery.js"></script>
    <style>
        #save-form{
            width: 800px;
        }
    </style>
</head>
<body>
<div class="container">
  <form action="/save" method="post" id="save-form" enctype="multipart/form-data">
   email <input type="text" name="memberEmail" id="memberEmail" onblur="emailDuplicate()" class="form-control" placeholder="이메일">
   <span id="email-dup"></span>
   <span id="email-input-check"></span>
   password <input type="password" name="memberPassword" class="form-control" placeholder="비밀번호">
   name <input type="text" name="memberName" class="form-control" placeholder="이름">
   mobile <input type="text" name="memberMobile" class="form-control" placeholder="전화번호">
      <input type="file" class="form-control" name="memberFile">
      <input type="submit" value="회원가입" class="btn btn-dark">
  </form>
</div>
</body>
<script>
    const emailDuplicate = () => {
        const email = document.getElementById("memberEmail").value;
        const checkResult = document.getElementById("email-dup");
        $.ajax({
            type:"post",
            url:"/duplicate-check",
            dataType:"text",
            data:{inputEmail: email},
            success: function (result) {
                if (result == "ok") {
                    checkResult.innerHTML = "사용 가능한 이메일";
                    checkResult.style.color = "green";
                } else {
                    checkResult.innerHTML = "이미 사용중인 이메일입니다";
                    checkResult.style.color = "red";
                }
            },
            error: function () {
            }
        })
    }
</script>
</html>
