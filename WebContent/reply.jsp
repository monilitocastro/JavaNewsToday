<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="writeForum" class="com.javanewstoday.forum.ForumWriteFacade" scope="request"/>
    <jsp:useBean id="user" class="com.javanewstoday.account.UserBean" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sending reply and redirecting</title>

<%
String rfr = request.getParameter("Referer");
String content = request.getParameter("content");
String forumName = request.getParameter("forumName");
String threadId = request.getParameter("threadId");
String username = user.getUsername();
writeForum.setForumBean(forumName);
writeForum.addMessage(threadId, content, username);
%>
<meta http-equiv="refresh" content="1;URL=showthread.jsp?threadID=<%=threadId %>&forumName=<%=forumName %>">
</head>

<body>
Submitting reply and redirecting back to thread...
</body>
</html>