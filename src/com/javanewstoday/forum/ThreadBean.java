package com.javanewstoday.forum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ThreadBean implements Comparator<ThreadBean>, java.io.Serializable{
	private String title;
	private String author;
	private String dateposted;
	private Date date;
	private String content;
	private boolean active;
	private List<MessageBean> messages;
	private int rating;
	private String comparisonType;
	ThreadBean(){
		initDate();
		initMessageBeanList();
		setRating(0);
		setComparisonType("dateposted");
		dateposted = date.toString();
	}
	private void initMessageBeanList(){
		messages = new ArrayList<MessageBean>();
	}
	private void initDate(){
		date = new Date();
	}
	public String getTitle() {
		return title;
	}
	public String getOriginDate(){
		return date.toString();
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDateposted() {
		return dateposted;
	}
	public void setDateposted(String dateposted) {
		this.dateposted = dateposted;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean messagesIsNonempty(){
		return (messages!=null);
	}
	public List<MessageBean> getMessages(){
		if(messagesIsNonempty() ){
			return messages;
		}else{
			throw new NullPointerException("Guard against null message lists by using messagesIsNonempty() method ");
		}
	}
	public void addNewMessage(MessageBean mb){
		messages.add(mb);
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComparisonType() {
		return comparisonType;
	}
	public void setComparisonType(String comparisonType) {
		this.comparisonType = comparisonType;
	}
	@Override
	public int compare(ThreadBean o1, ThreadBean o2) {
		String cmpType = this.getComparisonType();
		if(cmpType.equals("rating")){
			return o1.getRating() - o2.getRating();
		}else if(cmpType.equals("dateposted")){
			return o1.getDateposted().compareTo(o2.getDateposted() );
		}
		return 0;
	}
}
