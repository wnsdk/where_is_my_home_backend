<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>

<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Where Is My Home</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css" />
  <link rel="stylesheet" href="./assets/css/main.css" />
</head>

<body>
  <!-- 상단 navbar start -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
    <div class="container">
      <a class="navbar-brand text-primary fw-bold" href="index.jsp">
        <img src="./assets/img/ssafy_logo.png" alt="" width="60" />
        Where Is My Home
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-lg-0">
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="./notice?action=list">공지사항</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="aptdongprice.jsp">동별 아파트 매매정보</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="aptprice.jsp">아파트별 매매정보</a>
          </li>
        </ul>
        <!-- 로그인 전 -->
        <c:if test="${empty loginUser}">
	        <ul class="navbar-nav mb-2 me-2 mb-lg-0" id="navbar1">	          
	          <li class="nav-item">
	            <a class="nav-link" aria-current="page" href="register.jsp">회원가입</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" aria-current="page" href="login.jsp">로그인</a>
	          </li>
	        </ul>
        </c:if>
        <!-- 로그인 후 -->
        <c:if test="${not empty loginUser}">
	        <ul class="navbar-nav mb-2 me-2 mb-lg-0" id="navbar2">
	          <li class="nav-item">
	          <a class="nav-link">${loginUser.name} 님 반갑습니다. </a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" aria-current="page" href="user?action=logout">로그아웃</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" aria-current="page" href="user?action=userinfo">회원정보</a>
	          </li>
	        </ul>
        </c:if>
      </div>
    </div>
  </nav>
  <!-- 상단 navbar end -->
  <c:if test="${not empty msg}">
	  <script>
	 	alert("${msg}");
	  </script>
  </c:if>
  
  