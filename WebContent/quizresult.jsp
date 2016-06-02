<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="documentdependencies.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-sm-3"><%@include file="navigation.jsp" %></div>
        <div class="col-sm-9">
            <!-- Content goes here -->
            <h3>Quiz Results</h3><br/><br/>
            <p>The question was: <jsp:getProperty name="quiz1" property="question" /></p>
            <%String myAnswer =  request.getParameter("quiz");%>
            <p>You responded <%=myAnswer %></p>
           <p>
                That is <% if(!myAnswer.equals(quiz1.getAnswer()) ){%>
                	<%="<span class='warning'>not</span>" %>
                <% } %>
           correct.</p>
        </div>
    </div>
</div> 
</body>
</html>