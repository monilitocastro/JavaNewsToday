<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.javanewstoday.account.UserBean" scope="session" />
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
%>
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
            <%String disabled=""; %>
            <%if(user.getUsername()==null){%>
                <h3>Please log-in or register before posting. There is no anonymous posting allowed.</h3>
                <jsp:include page="loginbox.jsp"/>
                <hr/>
                <%disabled = "disabled"; %>
            <%}else{ %>
                <h3>Hello, <jsp:getProperty name="user" property="username"/></h3>
            <%} %>
            <form action="processform.jsp" method="post">
            	<input type="hidden" id="mode" value="<jsp:getProperty name="user" property="mode" />" >Title
            	<br />
            	<input type="text" id="title" name="title" <%=disabled %> />
            	<br />Content
            	<br />
            	<textarea name="content" id="content" cols="50" rows="20" <%=disabled %>></textarea><br />
            	<input type="submit" id="submit" name="submit" value="Submit" <%=disabled %> />
            </form>
        </div>
    </div>
</div>    
</body>
</html>