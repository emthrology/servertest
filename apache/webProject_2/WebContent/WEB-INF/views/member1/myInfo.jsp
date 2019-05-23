<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//Member m = (Member)request.getAttribute("member"); //header에서 m이란 인스턴스로 Member객체를 사용하고 있음, duplicated
    	Member m1 = (Member)request.getAttribute("member1");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
      <form action="/update" method="post" style="width:800px;margin:0 auto; color:black;">
         <h1>회원 정보</h1>
         <table class="table">
            <tr>
               <th>아이디</th>
               <td><input type="text" name="memberId" class="form-control" value="<%=m1.getMemberId() %>" readonly></td>
            </tr>
            
            <tr>
               <th>비밀번호</th>
               <td><input type="password" name="memberPw" class="form-control" value="<%=m1.getMemberPw() %>"></td>
            </tr>
            
            <tr>
               <th>이름</th>
               <td><input type="text" name="memberName" class="form-control" value="<%=m1.getMemberName() %>"></td>
            </tr>
            
            <tr>   
               <th>나이</th>
               <td><input type="text" name="age" class="form-control" value="<%=m1.getAge() %>" readonly></td>
            </tr>
            
            <tr>
               <th>이메일</th>
               <td><input type="text" name="email" class="form-control" value="<%=m1.getEmail() %>"></td>
            </tr>
            
            <tr>
               <th>전화번호</th>
               <td><input type="text" name="phone" class="form-control" value="<%=m1.getPhone() %>"></td>
            </tr>
            
            <tr>
               <th>주소</th>
               <td><input type="text" name="address" class="form-control" value="<%=m1.getAddress() %>"></td>
            </tr>
            
            <tr>
               <th>가입일</th>
               <td><input type="text" name="enrollDate" class="form-control" value="<%=m1.getEnrollDate() %>" readonly></td>
            </tr>
            
            <tr>
               <th colspan="2" style="text-align: center">
                  <button type="submit" class="btn btn-outline-danger btn-lg" onclick="location.href='/update'">수정하기</button>
                  <%if(m1.getMemberId().equals("admin")){ %>
                  <button type="button" class="btn btn-outline-danger btn-lg" onclick="location.href='/adminPage'">회원관리</button>
                  <%}else{ %>
                  <button type="button" class="btn btn-outline-danger btn-lg" onclick="location.href='/delete?memberId=<%=m1.getMemberId() %>'">회원탈퇴</button>
                  <%} %>
               </th>
            </tr>
         </table>
      </form>
   </section>
</body>
</html>