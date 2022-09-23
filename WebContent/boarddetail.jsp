<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>
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
          <div class="col-md-12">
            <h4>[ 글 보기 ]</h4>
            <form action="./" method="post">
            <table id="_tboard">
			    <tr>
					<td>번호</td>
					<td><input type="text" name="id" readonly
					     value="${notice.id}" width="30"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" readonly
					     value="${notice.writer}" width="30"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"  readonly
					value="${notice.title}" width="30"></td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><input type="text" name="writetime"  readonly
					value="${notice.writedate}" width="30"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="20" cols="50" readonly
					name="content">${notice.content}</textarea></td>
				</tr>
			</table>
			</form>
          </div>
        </div>
        <!-- 인기글 & 최신글 end -->
        <c:if test="${loginUser.id eq notice.writer}">
		    <div id="_shows">		    
		    
				<form action="./notice" method="post" style="display:inline">
				 <input type="hidden" name="action" value="bfupdate">
				 <input type="submit" value="글수정" >
				 <input type="hidden" name="id" value="${notice.id}">
				</form>
				<form action="./notice" method="post" style="display:inline">
				 <input type="hidden" name="action" value="delete">
				 <input type="submit" value="글삭제" >
				 
				 <input type="hidden" name="id" value="${notice.id}">
				</form>
			
			</div>
		</c:if>
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