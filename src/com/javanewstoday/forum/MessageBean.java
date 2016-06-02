package com.javanewstoday.forum;

import java.util.Date;

public class MessageBean implements java.io.Serializable{
	private String author;
	private String dateposted;
	private String content;
	private Date date;
	private String uniqueId;
	private String respondingTo;
	MessageBean(){
		initDate();
		dateposted = date.toString();
		setUniqueId(ForumHelper.generateAlphanumericCode(32 ));
	}
	public String getDateFormat(){
		return "dow mon dd hh:mm:ss zzz yyyy";
	}
	private void initDate(){
		date = new Date();
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDateposted() {
		return dateposted;
	}
	public void setDateposted(String dateposted) {
		this.dateposted = dateposted;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getRespondingTo() {
		return respondingTo;
	}
	public void setRespondingTo(String respondingTo) {
		this.respondingTo = respondingTo;
	}
}
