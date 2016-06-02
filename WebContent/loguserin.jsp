<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.javanewstoday.account.UserBean" scope="session" />
<jsp:setProperty name="user" property="username" value="<%=request.getParameter(\"username1\") %>" />
<jsp:setProperty name="user" property="password" value="<%=request.getParameter(\"password1\") %>" /> 
<% String username = user.getUsername(); %>
<% String password = user.getPassword(); %>
<% if((username!=null) && (password!=null)){ %>
<%          System.out.println("Before determining/ username: " + username + " password: " + password ); %>
<%    if(user.logUserIn(username, password)){   %>
<%          System.out.println("Logged in user/ username: " + username + " password: " + password ); %>
            <jsp:forward page="successfullogin.jsp"/>
            
<%    }else{ %>
<%          System.out.println("No login for user/ username: " + username + " password: " + password ); %>
<%          session.invalidate();  %>
            <jsp:forward page="index1.jsp"/>
<%             %>
<%    } %>
<% } %>
       
<%  %>
