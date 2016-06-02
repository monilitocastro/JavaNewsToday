package com.javanewstoday.forum;

import java.util.Iterator;

public class ForumWriteFacade extends AbstractForumFacade{
	public ForumWriteFacade(){
		mode = WRITEMODE;
		
		
	}
	public void createStory(){
		if(forumBean==null){
			throw new NullPointerException("ForumBean is null");
		}
		if(tb!=null){
			forumBean.addThreadToForum(tb);
		}else{
			throw new NullPointerException("Threadbean tb needs to be set.");
		}
	}
	public void addMessage(String threadId, String content, String username){
		MessageBean mb = new MessageBean();
		mb.setAuthor(username);
		mb.setContent(content);
		ThreadBean localTB = this.getForumBean().getThreadBeanWithKey(threadId);
		localTB.addNewMessage(mb);
	}
	@Override
	public void promoteToModerator() {	
		if(moderator!=null){
			forumBean.setModerator(moderator ); 
		}else{
			throw new NullPointerException("moderator in Facade for " + forumType + " is null");
		}
	}

	@Override
	public boolean hasNextLoaded() {
		throw new UnsupportedOperationException("This WRITEMODE Bean does not have hasNextLoaded method");
	}


	@Override
	protected void setThreadsIDIterator() {
		throw new UnsupportedOperationException("This WRITEMODE Bean does not have setThreadsIDIterator method");
		
	}

}
