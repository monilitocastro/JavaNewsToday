<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.javanewstoday.account.UserBean" scope="session" />
<jsp:useBean id="javanewsforum" class="com.javanewstoday.forum.ForumReadFacade" scope="request" />
<jsp:setProperty name="user" property="mode" value="EnterpriseJava" />
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
            <!--------------------------- Content goes here----------------------------------------->
            
             <jsp:include page="forumOptions.jsp" />
               <!-- table.articleList>tr>(th>h3>lorem2)*4^tr*8>(td>p>lorem2)*4 -->
                <table class="articleList">
                	<tr>
                		<th>
                			<h3 style="padding-left:2em;padding-right:2em;">Title&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3>
                		</th>
                		<th>
                			<h3>Author&nbsp;&nbsp;&nbsp;</h3>
                		</th>
                		<th>
                			<h3>Rating&nbsp;&nbsp;&nbsp;</h3>
                		</th>
                		<th>
                			<h3>Date</h3>
                		</th>
                	</tr>
                	<tr>
                		<td>
                			<p>&nbsp;&nbsp;&nbsp;</p>
                		</td>
                		<td>
                			<p>&nbsp;&nbsp;&nbsp;</p>
                		</td>
                		<td>
                			<p>&nbsp;&nbsp;&nbsp;</p>
                		</td>
                		<td>
                			<p>&nbsp;&nbsp;&nbsp;</p>
                		</td>
                	</tr>
                	<%javanewsforum.setForumBean("EnterpriseJava"); %>
                	<%while(javanewsforum.hasNextLoaded()){ %>
                	<tr>
                		<td style="padding-left:2em;padding-right:2em;">
                			<p><a href="showthread.jsp?threadID=<%=javanewsforum.getThreadId() %>&forumName=EnterpriseJava"  ><jsp:getProperty name="javanewsforum" property="title" /></a></p>
                		</td>
                		<td>
                			<p><jsp:getProperty name="javanewsforum" property="author" /></p>
                		</td>
                		<td>
                			<p><jsp:getProperty name="javanewsforum" property="rating" /></p>
                		</td>
                		<td>
                			<p><jsp:getProperty name="javanewsforum" property="dateposted" /></p>
                		</td>
                	</tr>
                	<%} %>
                	
                </table>     
                
            <!------------------------- End of content here----------------------------------------->
        </div>
    </div>
</div>    
</body>
</html>