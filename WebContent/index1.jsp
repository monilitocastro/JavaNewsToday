<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.javanewstoday.account.UserBean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="documentdependencies.jsp" />
</head>
<body>
    <jsp:include page="header.jsp" />
<div class="container">
    <div class="row">
        <div class="col-sm-3"><jsp:include page="navigation.jsp" /></div>
        <div class="col-sm-9">
            <!-- Content goes here -->
            <%if(user.getUsername()==null ){ %>
            <%String uri = request.getRequestURI(); %>
                <% if((uri!=null) && (uri.contains("logout")) ){%>
                        <div class="alert alert-warning" >
                        	<h3>Logged out</h3>
                        </div>
                <% } %>
                <jsp:include page="loginbox.jsp" />
            <%}else{
            	
            	
            } %>
        </div>
    </div>
</div>    
</body>
</html>