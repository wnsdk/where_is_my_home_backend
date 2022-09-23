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
    <main class="form-signin w-100 m-auto" id="user-info">
      <form method="post" action="user">
          <h1 class="h3 mb-3 fw-normal">회원 정보</h1>
  		  <input type="hidden" name="action" value="userupdate">
          <div class="form-floating mb-1">
            <input type="text" class="form-control" id="_id" name="user_id" value="${loginUser.id}" readonly>
            <label for="id">ID</label>
          </div>
          <div class="form-floating mb-1">
            <input type="password" class="form-control" id="_password" name="password">
            <label for="password">Password</label>
          </div>
          
          <div class="form-floating mb-1">
            <input type="email" class="form-control" id="_email" name="address" value="${user.address}">
            <label for="email">email</label>
          </div>
          <div class="form-floating mb-1">
            <input type="text" class="form-control" id="_name" name="name" value="${user.name}">
            <label for="name">name</label>
          </div>
          <div class="form-floating mb-1">
            <input type="text" class="form-control" id="_phone" name="phone" value="${user.phone}">
            <label for="phone">phone</label>
          </div>
          
          <button class="w-100 btn btn-lg btn-primary" id="btn-update" type="submit">수정</button>
        </form>
        <button class="w-100 btn btn-lg btn-primary" id="btn-delete">회원 탈퇴</button>
    </main>
  </div>
  
  <script>
  document.querySelector("#btn-delete").addEventListener("click", function(event) {
	 location.href = "user?action=userdelete";
  });
  </script>


<!-- footer -->
<%@ include file="/include/footer.jsp" %>



  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
  <script src="./assets/js/main.js"></script>
</body>

</html>