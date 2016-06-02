<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="user" class="com.javanewstoday.account.UserBean" scope="session"/>
<jsp:useBean id="forumwrite" class="com.javanewstoday.forum.ForumWriteFacade" scope="request"/>
<%
String mode = user.getMode();
if(     mode.equals("IndustryNews") ||
        mode.equals("EnterpriseJava") ||
        mode.equals("StandardEditionJava") ||
        mode.equals("MicroEdition") ||
        mode.equals("Beans") ||
        mode.equals("Editorials") ){
    forumwrite.setForumBean(mode);
    System.out.println("ForumBean is set and writing to forum is now allowed");
}
System.out.println("USERNAME IS"+user.getUsername());
forumwrite.setAuthor(user.getUsername() );
forumwrite.setContent(request.getParameter("content"));
forumwrite.setTitle(request.getParameter("title"));
forumwrite.createStory();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="1;URL=<%=mode%>.jsp"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>




<h3>Submitting story...</h3>
<br />
Hello <jsp:getProperty name="user" property="username"/>
You will land back on <mark><jsp:getProperty name="user" property="mode"/>.jsp</mark>
</body>
</html>