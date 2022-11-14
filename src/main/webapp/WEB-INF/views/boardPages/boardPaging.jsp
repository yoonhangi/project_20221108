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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <style>
        #List-form {
            width: 800px;
            margin-top: 50px;
        }
        #search-form {
            width: 600px;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<div class="container" id="List-form">
<table class="table  table-striped table-active text-center">
   <tr>
       <th>번호</th>
       <th>제목</th>
       <th>작성자</th>
       <th>작성날짜</th>
       <th>조회수</th>
       <th>상세조회</th>
   </tr>
    <c:forEach items="${boardList}" var="board">
    <tr>
        <td>${board.id}</td>
        <td>
            <a href="/board?id=${board.id}&page=${paging.page}">${board.boardTitle}</a>
        </td>
        <td>${board.boardWriter}</td>
        <td>
            <fmt:formatDate value="${board.boardCreatedDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
        </td>
        <td>${board.boardHits}</td>
        <td>
        <c:if test="${sessionScope.loginEmail == board.boardWriter}">
            <a href="/board?id=${board.id}&page=${paging.page}" class="btn btn-primary">상세조회</a>
        </c:if>
        </td>
    </tr>
    </c:forEach>
</table>
</div>
<div class="container">
    <ul class="pagination justify-content-center">
        <c:choose>
            <%-- 현재 페이지가 1페이지면 이전 글자만 보여줌 --%>
            <c:when test="${paging.page<=1}">
                <li class="page-item disabled">
                    <a class="page-link">[이전]</a>
                </li>
            </c:when>
            <%-- 1페이지가 아닌 경우에는 [이전]을 클릭하면 현재 페이지보다 1 작은 페이지 요청 --%>
            <c:otherwise>
                <li class="page-item">
                    <a class="page-link" href="/board/paging?page=${paging.page-1}">[이전]</a>
                </li>
            </c:otherwise>
        </c:choose>

        <%--  for(int i=startPage; i<=endPage; i++)      --%>
        <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
            <c:choose>
                <%-- 요청한 페이지에 있는 경우 현재 페이지 번호는 텍스트만 보이게 --%>
                <c:when test="${i eq paging.page}">
                    <li class="page-item active">
                        <a class="page-link">${i}</a>
                    </li>
                </c:when>

                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="/board/paging?page=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:choose>
            <c:when test="${paging.page>=paging.maxPage}">
                <li class="page-item disabled">
                    <a class="page-link">[다음]</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="page-item">
                    <a class="page-link" href="/board/paging?page=${paging.page+1}">[다음]</a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
    <div class="text-center">
    <c:if test="${sessionScope.loginEmail == 'admin'}">
        <a href="/admin" class="btn btn-primary">관리자 페이지</a>
    </c:if>
    </div>
    <div class="text-center">

    </div>
</div>
<form action="/board/search" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
<div class="input-group" id="search-form">
    <select name="type" class="form-select ">
        <option value="boardTitle" selected>제목</option>
        <option value="boardWriter">작성자</option>
    </select>
    <input type="search" name="q" class="form-control form-control-dark text-bg-dark" placeholder="Search..."
           aria-label="Search">
    <button class="btn btn-outline-light"><i class="bi bi-search"></i></button>
</div>
<div class="container text-center">
    <form action="/update" method="get">
        <input type="button" value="마이페이지" onclick="updateMember()" class="btn btn-primary">
    </form>
</div>

</form>
<div class="text-center">
<button class="btn btn-danger" onclick="logout()">로그아웃</button>
<button class="btn btn-dark" onclick="boardSave()">글작성</button>
</div>
</body>
<script>
    const logout = () => {
        location.href = "/logout";
    }
    const boardSave=()=>{
        location.href = "/board/save";
    }
    const updateMember = () => {
        location.href = "/update";
    }
</script>
</html>

