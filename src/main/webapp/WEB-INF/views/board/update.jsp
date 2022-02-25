<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글수정</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
<h3>게시판 글수정</h3>
<form action="update.do" method="post">
	<input name="page" value="${pageObject.page }" type="hidden"> 
	<input name="perPageNum" value="${pageObject.perPageNum }" type="hidden"> 
  <div class="form-group">
    <label for="title">글번호</label>
    <input type="text" class="form-control" id="no" name="no" readonly="readonly" value="${vo.no }">
  </div>
  <div class="form-group">
    <label for="title">제목</label>
    <input type="text" class="form-control" id="title" name="title" value="${vo.title }">
  </div>
  <div class="form-group">
  <label for="content">내용</label>
  <textarea class="form-control" rows="5" id="content" name="content">${vo.content }</textarea>
</div>
  <div class="form-group">
    <label for="writer">작성자</label>
    <input type="text" class="form-control" id="writer" name="writer" value="${vo.writer }">
  </div>
  <button type="submit" class="btn btn-default">수정</button>
  <button type="reset" class="btn btn-default">새로입력</button>
  <button type="button" class="btn btn-default" class="cancelBtn">취소</button>
</form>

</div>
</body>
</html>