<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
  		<c:when test="${!empty sessionUserInfo }">
  			
  			<article id="login_box">
  			<img id="login_title" src="img/ttl_login.png">
  			<br><br>
  			${sessionUserInfo.m_name } 님 
  			
  			<br><br>
    		<a href="./logout_process.do">로그아웃</a>
  			
  			</article>
  					
  		</c:when>
  		
  		<c:otherwise>
		
		  <article>
		  <form action="./login_process.do" method="post">
		  
		    <img id="login_title" src="img/ttl_login.png">
		    <div id="input_button">
		    <ul id="login_input">
		      <li><input type="text" name="m_id"></li>
		      <li><input type="password" name="m_pw"></li>
		    </ul>
		    <input type="image" id="login_btn" src="img/btn_login.gif">
		    </div> 
		    <div class="clear"></div>
		    <div id="join_search">
		    
		    
		      <a href="join_member_page.do"><img src="img/btn_join.gif"></a>
		      <img src="img/btn_search.gif">
		    </div>
		    </form>
		  </article>
			  		
  		</c:otherwise>
  		
  	</c:choose>



</body>
</html>