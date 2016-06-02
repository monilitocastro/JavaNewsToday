<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="documentdependencies.jsp" />
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <div class="row">
        <div class="col-sm-3"><%@include file="navigation.jsp" %></div>
        <div class="col-sm-9">
            <!-- Content goes here -->
            <h1>Static information:</h1><br/>
            <table class="table">
            	<tr>
            		<th>Description</th>
            		<th>Value from Request object</th>
            	</tr>
            	<tr>
            		<td>Authorization type</td>
            		<td><%= request.getAuthType() %></td>
            	</tr>
            	<tr>
            		<td>Method your browser called</td>
            		<td><%= request.getMethod() %></td>
            	</tr>
            	<tr>
            		<td>Character encoding of this page</td>
            		<td><%= request.getCharacterEncoding() %></td>
            	</tr>
            	<tr>
            		<td>Protocol used</td>
            		<td><%= request.getProtocol() %></td>
            	</tr>
            	<tr>
            		<td>Scheme portion of this URL</td>
            		<td><%= request.getScheme() %></td>
            	</tr>
            	<tr>
            		<td>Our domain name</td>
            		<td><%= request.getServerName() %></td>
            	</tr>
            	<tr>
            		<td>Port we used to communicate</td>
            		<td><%= request.getServerPort() %></td>
            	</tr>
            	<tr>
            		<td>Your IP Address</td>
            		<td><%= request.getRemoteAddr() %></td>
            	</tr>
            	<tr>
            		<td>The name of your computer</td>
            		<td><%= request.getRemoteHost() %></td>
            	</tr>
            	<tr>
            		<td>Path info</td>
            		<td><%= request.getPathInfo() %></td>
            	</tr>
            	<tr>
            		<td>Path translated</td>
            		<td><%= request.getPathTranslated() %></td>
            	</tr>
            	<tr>
            		<td>Key value pairs after ? symbol in the URL</td>
            		<td><%= request.getQueryString() %></td>
            	</tr>
            	<tr>
            		<td>The name you used to log in</td>
            		<td><%= request.getRemoteUser() %></td>
            	</tr>
            	<tr>
            		<td>Your requested URI</td>
            		<td><%= request.getRequestURI() %></td>
            	</tr>
            	<tr>
            		<td>Your browser's agent string</td>
            		<td><%= request.getHeader("User-Agent")%></td>
            	</tr>
            	<tr>
            		<td>File types accepted</td>
            		<td><%= request.getHeader("Accept") %></td>
            	</tr>
            </table><br />
            <jsp:useBean id="user" class="com.javanewstoday.account.UserBean" scope="session"/>
            <%if(user.getUsername()!=null){%>
	            <h1>Session information</h1><br />
	            <table class="table">
	            	<tr>
	            		<th>Description of User info</th>
	            		<th>Value?</th>
	            	</tr>
	            	<tr>
	            		<td>Username</td>
	            		<td><jsp:getProperty name="user" property="username"/></td>
	            	</tr>
	            	<tr>
	            		<td>Email</td>
	            		<td><jsp:getProperty name="user" property="email"/></td>
	            	</tr>
	            	<tr>
	            		<td>Rating</td>
	            		<td><jsp:getProperty name="user" property="rating"/></td>
	            	</tr>
	            </table>
	        <%} %>
        </div>
        </div>
    </div>
</body>
</html>