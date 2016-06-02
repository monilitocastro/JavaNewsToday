package com.javanewstoday.quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizBean {
	private String question;
	private String answer;
	private List<String> choices;
	/**
	 * beans are not allowed to have arguments in constructors
	 */
	public QuizBean(){
		question = "Just choose JaSPer?";
		answer="JaSPer";
		setChoices("Jax-RS;JaSPer;Money");
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public List<String> getChoices() {
		return choices;
	}
	public void setChoices(String a){
		List<String>choices = new ArrayList<String>();
		String [] items = a.split(";");
		for(String item : items){
			choices.add(item);
		}
		setChoices(choices);
	}
	private void setChoices(List<String> choices) {
		this.choices = choices;
	}

}
