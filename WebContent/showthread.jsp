<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="readForum" class="com.javanewstoday.forum.ForumReadFacade" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String tid = request.getParameter("threadID");
String forumName = request.getParameter("forumName"); 
String meta = "";
if((tid==null) || (forumName==null)){
	meta = "<meta http-equiv=\"refresh\" content=\"1;URL=index1.jsp\"> \n";%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%=meta %>
 Returning to homepage.
<%}else{
   readForum.setForumBean(forumName);
   readForum.loadThreadBeanWithKey(tid); %>
    <jsp:include page="documentdependencies.jsp" />

</head>
<body>
    <jsp:include page="header.jsp" />
<div class="container">
    <div class="row">
        <div class="col-sm-3"><jsp:include page="navigation.jsp" /></div>
        <div class="col-sm-9">
            <!-- Content goes here -->
            <div class="row"><h2 id="showTitle" style="float:right;"><%=readForum.getThreadBeanTitle() %></h2></div> 
            <div class="row"><h3 style="float:right;">Rating <big><%=readForum.getThreadBeanRating() %></big></h3></div>
            <div class="row"><p style="float:right;">Posted on <%=readForum.getThreadBeanDateposted() %></p></div> 
            <div class="row"><p style="float:right;">Written by <big><%=readForum.getThreadBeanAuthor() %></big></p></div> 
            &nbsp;<br/>&nbsp;<br/>
            <div class="row"><p class="lead" id="showContent" style="float:left;"><%=readForum.getThreadBeanContent() %></p></div> 
            <hr/>
            <div class="row" ><button class="btn btn-info" onClick="replyForm('<%=forumName %> maincontent')" id="maincontent" value='Reply')" style="float:right;">Reply</button></div>
            
                <script type="text/javascript">
                  var showContent = document.getElementById("showContent");
                  showContent.innerHTML = showContent.innerHTML.replace(/\n/g,"<br/>&nbsp;");
                  function replyForm(str){
                	  var str = str.split(" ");
                	  if(str[1]==="maincontent"){
                		 loadDoc("maincontent","replyForm.html", "<%=readForum.getForumType()%>", "<%=tid%>");
                	  }else if(str[1]!=="maincontent"){
                		  
                	  }
                  };
                  function loadDoc(dom, filename, forumName, threadId) {
                	  var xhttp = new XMLHttpRequest();
                	  xhttp.onreadystatechange = function() {
                	    if (xhttp.readyState == 4 && xhttp.status == 200) {
                            var changeThis = document.getElementById("maincontent");
                            var parent = changeThis.parentNode;
                            var respTxt = xhttp.responseText;
                            respTxt = respTxt.replace("forumNameValue", forumName);
                            respTxt = respTxt.replace("threadIdValue", threadId);
                	        parent.innerHTML = respTxt ;
                	    }
                	  };
                	  xhttp.open("GET", filename, true);
                	  xhttp.send();
                	  return xhttp.responseText;
                  };
                </script>
           <br/> 
           <%while( readForum.hasMessages() ){ %>
               <div class="well"> 
	           <p style="float:right;"><% readForum.loadNextMessage(); %>
	           reply from <%=readForum.getMessageAuthor() %>
	           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	           <%=readForum.getMessageDate() %>
	           </p><p>
	           <br />
	           <div class="lead"><%=readForum.getMessageContent() %></div>
	           <br/>
	           </div></p>
           <%} %>
           <% %>
          
          
          <div class="row" ><button class="btn btn-info" onClick="replyForm('<%=forumName %> maincontent')" id="maincontent" value='Reply')" style="float:right;">Reply</button></div>
            
        </div>
    </div>
</div>    
</body>
</html>
<%}%>

