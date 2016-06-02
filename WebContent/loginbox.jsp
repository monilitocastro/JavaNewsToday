<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row">
<div class="col-sm-3">&nbsp;</div>
<div class="col-sm-6">
	<div class="well" style="padding:2em;">
	    <h3>Login</h3> <br />
		<form action="loguserin.jsp" method="POST">
			<input type="text" name="username1" id="username1" value="Username" onClick="(function(){var u=document.getElementById('username1');if(u.value=='Username'){u.value='';} })();"/><br />
			<input type="password" name="password1" /><br />
			<a href="register.jsp">Register new user</a>
			<br />
			<input type="submit" id="submit" value="Go &gt;&gt;&gt;">
		</form>
	</div>
</div>
<div class="col-sm-3">&nbsp;</div>
</div>