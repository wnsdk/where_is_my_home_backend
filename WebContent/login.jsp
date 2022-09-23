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
      <form method="POST" action="user">
      	<input type="hidden" name="action" value="login">
        <h1 class="h3 mb-3 fw-normal">Please Login</h1>

        <div class="form-floating mb-1">
          <input type="text" class="form-control" id="_id" name="user_id" placeholder="ID">
          <label for="id">ID</label>
        </div>
        <div class="form-floating mb-1">
          <input type="password" class="form-control" id="_password" name="password" placeholder="Password">
          <label for="password">Password</label>
        </div>
        <button id="btn-login" class="w-100 btn btn-lg btn-primary mb-1" type="submit">Login</button>
        <button class="w-100 btn btn-lg btn-primary" onclick="location.replace('find.jsp');" type="button">Find Password</button>
        <c:if test="${!empty msg}">
		<p style="color:red">${msg}</p>
		</c:if>
      </form>
    </main>
  </div>



<!-- footer -->
<%@ include file="/include/footer.jsp" %>



  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
  <script src="./assets/js/main.js"></script>
</body>
</html>