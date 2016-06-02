<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div class="row">
<div class="col-sm-3">&nbsp;</div>
<div class="col-sm-6">
    <div class="well" style="padding:3em;">
    <form action="newuser.jsp" >
       Desired user-name <br />
    	<input type="text" name="username1" pattern="[a-zA-Z][a-zA-Z0-9]*" title="Alphanumeric sequence starting with letter"/><br />
    	Password <br />
    	<input type="password" name="password1" pattern="(?=.*[!@#$%^&*-+~])(?=.*[a-zA-Z0-9]).{8,}" title="Alphanumeric and at least one from ~!@#$%^&*-+" /><br />
    	Email <br />
    	<input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="it can look like namepossibly342@serv.er" /><br />
    	
    	<input type="submit" value="Go >>>" />
    	<input type="reset" />
    </form>
    </div>
</div>
<div class="col-sm-3">&nbsp;</div>
</div>