<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="user" class="com.javanewstoday.account.UserBean" scope="session"/>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header"><a href="#" class="navbar-brand" style="font-size:2em;">MonilitoCastro.XYZ</a></div>
        <div style="float:right;">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Blog</a></li>
                <li><a href="#">Portfolio</a></li>
                <li><a href="#">Courses</a></li>
                <li><a href="#">About me</a></li>
                <li><a href="#">Photographs</a></li>
                <li><a href="#">Lorem ipsum...</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="jumbotron" style="background-image:url('coffeebeans.jpg');color:#FFFFFF">
    <br/>&nbsp;<br/>&nbsp;<br/>&nbsp;
    <%if(user.getUsername()!=null){%>
    <span class="label label-default"><a href="logout.jsp" style="color:#FFFFFF;">Logout</a></span><br />
    <%} %>
    <h1>All About JAVA</h1>
    <h2><mark>Your online source for up-to-the-minute JAVA news</mark></h2>
    <br/>&nbsp;<br/>&nbsp;<br/>&nbsp;

    
</div>
