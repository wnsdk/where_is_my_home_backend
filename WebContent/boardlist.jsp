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
        
        <!-- 인기글 & 최신글 start -->
        <div class="row mt-3">
          
          <div class="col-md-12 row">
          <div class="col-md-2"><h4>[ 공지사항 ]</h4></div>
          <div class="col-md-8"></div>
          <div class="col-md-2"><a href="./notice?action=bfwrite">글쓰기</a></div>
          </div>
              
            <table class="table table-dark" id="_boardtable">
              <thead>
                <tr class="text-center">
                  <th>제목</th>
                  <th>작성자</th>
                  <th>조회수</th>
                </tr>
              </thead>
              <tbody>
                <c:if test="${empty notices }">
	                <tr>
						<td colspan="5">작성된 글이 없습니다.</td>
					</tr>
                </c:if>
                <c:forEach items="${notices}" var="notice">
	                <tr>
	                  <td><a href="./notice?action=detail&id=${notice.id}">${notice.title}</a></td>
	                  <td class="text-center">${notice.writer}</td>
	                  <td class="text-center">${notice.hit}</td>
	                </tr>
				</c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <!-- 인기글 & 최신글 end -->
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