package com.javanewstoday.forum;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import com.javanewstoday.observer.Observable;
import com.javanewstoday.observer.SerializingObserver;

public abstract class AbstractForumBean implements java.io.Serializable, Observable {
	/**
	 * 
	 */
	private SerializingObserver observer;
	private static final long serialVersionUID = 1L;
	private String purpose;
	private String moderator;
	private boolean isEditAll;
	private Hashtable<String, ThreadBean> threads;
	private List<String> orderedThreads;
	private final int length=32;
	protected AbstractForumBean(){
		orderedThreads = new ArrayList<String>();
		threads = new Hashtable<String, ThreadBean>();      //this should be the only place these two statements exist
	}
	/*  //Need to implement this static method in sub classes
	public static ForumBean getInstance(String p, String m){
		if(instance==null){
			instance = new ForumBean();
			instance.setPurpose(p);
			instance.setModerator(m);
		}
		return instance;
	}*/
	
	//////////////////////////////////////////////////////////////////////////////////securely gets ordered threads
	private List<String> getListThreadsPrivate(){
		List<String> result = new ArrayList<String>();
		synchronized(orderedThreads){
			System.out.println("(....getListThreadsPrivate with " + "orderedThreads"+ "....)");
			System.out.println("   Synchronized START: " + purpose);
			result.addAll(orderedThreads);
			System.out.println("   Synchronized END: " + purpose);
		}
		return result;
	}
	public List<String> getListThreads(){
		return getListThreadsPrivate();
	}
	/////////////////////////////////////////////////////////////////////////////securely adds new articles to list
	private void addNewsToListPrivate(String uid){
		synchronized(orderedThreads){
			System.out.println("(....addNewsToListPrivate with " + "orderedThreads"+ "....)");
			System.out.println("   Synchronized START: " + purpose);
			orderedThreads.add(uid);
			System.out.println("   Synchronized END: " + purpose);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////securely add new article to hashtable
	private void addNewsToHashtablePrivate(String uid, ThreadBean tb){
		synchronized(threads){
			System.out.println("(....addNewsToHashtablePrivate with " + "orderedThreads"+ "....)");
			System.out.println("   Synchronized START: " + purpose);
			threads.put(uid, tb);
			System.out.println("   Synchronized END: " + purpose);
		}
	}
	
	
	////////////////////////////////////////////////////////////////////////////public method to add ThreadBean
	public void addThreadToForum(ThreadBean tb){
		String uid = ForumHelper.generateAlphanumericCode(length);
		addNewsToListPrivate(uid);
		addNewsToHashtablePrivate(uid, tb);
		//sortList();
	}
	
	///////////////////////////////////////////////////////////////////////////flat arguments for adding thread
	public void addThreadToForum(	String title,
									String content, 
									String author, 
									String dateposted, 
									boolean active,
									MessageBean messages){
		ThreadBean tb = new ThreadBean();
		tb.setActive(active);
		tb.setAuthor(author);
		tb.setContent(content);
		tb.setDateposted(dateposted);
		tb.setTitle(title);
		tb.addNewMessage(messages);
		this.addThreadToForum(tb);
	}
	
    ///////////////////////////////////////////////////////////////////////flat arguments for adding thread without messagebean
	public void addThreadToForum(	String title,
									String content, 
									String author, 
									String dateposted, 
									boolean active){
		ThreadBean tb = new ThreadBean();
		tb.setActive(active);
		tb.setAuthor(author);
		tb.setContent(content);
		tb.setDateposted(dateposted);
		tb.setTitle(title);
		this.addThreadToForum(tb);
	}
	///////////////////////////////////////////////////////////////////////////////////////////sort the threads
	/*  //don't use
	private void sortList(){
		if(orderedThreads==null){
			throw new NullPointerException("orderedThreads is null");
		}
		synchronized(orderedThreads){
			Collections.sort(orderedThreads);
		}
	}*/
	
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getModerator() {
		return moderator;
	}
	public void setModerator(String moderator) {
		this.moderator = moderator;
	}
	public Set<String> getKeySet(){
		Set<String> result;
		synchronized(this){
			result =  threads.keySet();
		}
		return result;
	}
	public String getTitleWithID(String id){
		if(threads.containsKey(id) ){
			ThreadBean tb = threads.get(id);
			return tb.getTitle();
		}else{
			throw new IllegalStateException("key '" + id + "' does not exist in threads Hashtable");
		}
	}
	public ThreadBean getThreadBeanWithKey(String key){
		if(threads.containsKey(key)){
			return threads.get(key);
		}else{
			throw new RuntimeException("The key " + key + " does not exist in thread beans collection.");
		}		
	}

	public boolean isEditAll() {
		return isEditAll;
	}

	public void setEditAll(boolean isEditAll) {
		this.isEditAll = isEditAll;
	}
	//////////////////////////////////////////////////////////////////////////////////////////Observable interface methods
	public void getObserver(){
		if(observer==null)observer = SerializingObserver.getInstance();
	}
	public void registerSelf(){
		if(observer==null){
			getObserver();
		}
		observer.register(this);
	}
	/*
	////////////////////////////////////////////////////////////////////////////////////////////implements observable
	@Override
	public void setObserver(Observer o) {
		this.observer=(SerializingObserver)o;
		registerSelf();
	}
	@Override
	public void registerSelf() {
		// TODO Auto-generated method stub
		if(observer==null){
			throw new NullPointerException("observer attribute need to be set");
		}
		observer.register(this);
	}
	public abstract String getSerializableFilename();
	*/

}
