<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.javanewstoday.account.UserBean" scope ="session"/>
<jsp:setProperty name="user" property="username" value="<%=request.getParameter(\"username1\") %>" />
<jsp:setProperty name="user" property="password" value="<%=request.getParameter(\"password1\") %>" /> 
<jsp:setProperty name="user" property="email" />

<%RequestDispatcher rd=null;%>
<% %>
<%if(user.registerNewUser()){%>
	<%@include file="registrationsuccessful.jsp" %>
<%}else{%>
	<%@include file="registrationnotsuccessful.jsp" %>
<%}%>

