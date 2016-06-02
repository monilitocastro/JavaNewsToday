<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="alert alert-warning"><h1>Registration failed</h1></div>
<br />
<p>
    Please choose a different user name than <mark><jsp:getProperty name="user" property="username" /></mark>.
    <br />
    <%@include file="registrationform.jsp" %>
</p>