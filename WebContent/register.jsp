<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/include/head.jsp" flush="true"></jsp:include>
</head>


    <div class="container">
      <div style="height: 70px"></div>

      <main class="form-signin w-100 m-auto">
        <form method="post" action="user" id="_form">
          <h1 class="h3 mb-3 fw-normal">회원가입</h1>
  		  <input type="hidden" name="action" value="registry">
          <div class="form-floating mb-1">
            <input type="text" class="form-control" id="_id" name="user_id" placeholder="ID">
            <label for="id">ID</label>
          </div>
          <div class="form-floating mb-1">
            <input type="password" class="form-control" id="_password" name="password" placeholder="Password">
            <label for="password">Password</label>
          </div>
          <div class="form-floating mb-1">
            <input type="email" class="form-control" id="_email" name="address" placeholder="email">
            <label for="email">email</label>
          </div>
          <div class="form-floating mb-1">
            <input type="text" class="form-control" id="_name" name="name" placeholder="name">
            <label for="name">name</label>
          </div>
          <div class="form-floating mb-1">
            <input type="text" class="form-control" id="_phone" name="phone" placeholder="phone">
            <label for="phone">phone</label>
          </div>
          <button class="w-100 btn btn-lg btn-primary" id="btn-submit" type="button" onclick="btn_click()">회원등록</button>
        </form>
      </main>
    </div>
<script>


function btn_click(){
	let id = document.querySelector("#_id").value;
	let password = document.querySelector("#_password").value;
	let email = document.querySelector("#_email").value;
	let name = document.querySelector("#_name").value;
	let btn = document.querySelector("#btn-submit");
	
	if (id === '') {
		alert("아이디 입력");
		return;
	}
	else if (password === '') {
		alert("비밀번호 입력");
		return;
	}
	else if (email === '') {
		alert("이메일 입력");
		return;
	}
	else if (name === '') {
		alert("이름 입력");
		return;
	}
	
	let form = document.querySelector("#_form");
	form.submit();
	
}


	

</script>


<!-- footer -->
<%@ include file="/include/footer.jsp" %>

  </body>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
  <script src="./assets/js/main.js"></script>
</html>
