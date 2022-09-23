<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/include/head.jsp" flush="true"></jsp:include>
</head>

<!-- 중앙 content start -->
<div class="container">
  <div style="height: 70px"></div>
  <div class="row">
    <!-- 중앙 left content  start -->
    
    <!-- 중앙 left content end -->
    <div class="col-md-12">
      <!-- Kakao Map start -->
      <div class="mt-3 text-center">
        <h3>아파트 실거래가 조회</h3>
        <div class="container justify-content-center">
          <div style="height: 70px"></div>
          <div class="row col-md-12 justify-content-center mb-2">
            <div class="form-group col-md-2">
              <select class="form-select bg-secondary text-light" id="sido">
                <option value="">시도선택</option>
              </select>
            </div>
            <div class="form-group col-md-2">
              <select class="form-select bg-secondary text-light" id="gugun">
                <option value="">구군선택</option>
              </select>
            </div>
            <div class="form-group col-md-2">
              <select class="form-select bg-secondary text-light" id="dong">
                <option value="">동선택</option>
              </select>
            </div>
            <div class="form-group col-md-2">
              <select class="form-select bg-dark text-light" id="year">
                <option value="">매매년선택</option>
              </select>
            </div>
            <div class="form-group col-md-2">
              <select class="form-select bg-dark text-light" id="month">
                <option value="">매매월선택</option>
              </select>
            </div>
            <div class="form-group col-md-2">
              <button type="button" id="list-btn" class="btn btn-outline-primary col-md-12">
                검색
              </button>
            </div>
          </div>
      </div>
      <div id="_searchresult" style="width: 100%; height: 800px; overflow: scroll;">
        <table class="table table-hover text-center" style="display: none">
          <tr>
            <th>아파트이름</th>
            <th>층</th>
            <th>면적</th>
            <th>법정동</th>
            <th>거래금액</th>
          </tr>
          <tbody id="aptlist"></tbody>
        </table>
      </div>
      
      
    </div>
  </div>
</div>

<!-- footer -->
<%@ include file="/include/footer.jsp" %>

  

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
  <script src="./assets/js/main.js"></script>
</body>

</html>