<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="quiz1" class="com.javanewstoday.quiz.QuizBean" scope="application">
<small>QuizBean started.</small>
</jsp:useBean><br />
<h4>Pop quiz: <jsp:getProperty name="quiz1" property="question" /></h4>
	<form action="quizresult.jsp" method="post">
		<input type="radio" name="quiz" value="Apache/JSP" />Apache/JSP<br />
		<input type="radio" name="quiz" value="Jakarta" />Jakarta<br />
		<input type="radio" name="quiz" value="JaSPer" />JaSPer<br />
		<input type="submit" id="Go" value="Go" />
	</form>
