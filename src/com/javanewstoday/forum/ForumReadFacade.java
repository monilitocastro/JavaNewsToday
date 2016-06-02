package com.javanewstoday.forum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForumReadFacade extends AbstractForumFacade {
	private List<String> orderedThreads;
	private Iterator<String> iterator;
	private List<MessageBean> mbList;
	private Iterator<MessageBean> mbIterator;
	private MessageBean messagebean;
	private String key;
	public ForumReadFacade(){
		super();

		mode = READMODE;
	}
	public void promoteToModerator(){
		throw new UnsupportedOperationException("Cannot promote " + getModerator() + " to moderator using this READMODE Bean; you need a WRITEMODE Bean");
	}
	protected void setThreadsIDIterator(){
		orderedThreads = new ArrayList<String>();
		orderedThreads.addAll( forumBean.getListThreads() );
		iterator = orderedThreads.iterator();
	}
	public boolean hasNextLoaded(){
		if(iterator==null){
			setThreadsIDIterator();
		}
		boolean result =  iterator.hasNext();
		if(result){
			key = iterator.next();
			loadThreadBeanWithKey(key);
			return true;
		}
		return false;
	}
	public String getThreadId(){
		return key;
	}
	public boolean loadThreadBeanWithKey(String key){
		tb = forumBean.getThreadBeanWithKey(key);
		mbList = new ArrayList<MessageBean>();
		synchronized(tb){
			mbList.addAll(tb.getMessages() );
		}
		mbIterator = mbList.iterator();
		return (tb!=null);
	}
	public String getThreadBeanTitle(){
		guardThreadBean();
		return tb.getTitle();
	}
	public String getThreadBeanAuthor(){
		guardThreadBean();
		return tb.getAuthor();
	}
	public String getThreadBeanContent(){
		guardThreadBean();
		return tb.getContent();
	}
	public String getThreadBeanDateposted(){
		guardThreadBean();
		return tb.getDateposted();
	}
	public int getThreadBeanRating(){
		guardThreadBean();
		return tb.getRating();
	}

	
	public boolean hasMessages(){
		return mbIterator.hasNext();
	}
	public void loadNextMessage(){
		messagebean = mbIterator.next();
	}
	public String getMessageContent(){
		return messagebean.getContent();
	}
	public String getMessageAuthor(){
		return messagebean.getAuthor();
	}
	public String getMessageDate(){
		return messagebean.getDateposted();
	}
	
	private void guardThreadBean(){
		if(tb==null){
			throw new NullPointerException("ThreadBean is null, you can use loadThreadBeanWithKey(String key)");
		}
	}

}
