package com.javanewstoday.forum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public abstract class AbstractForumFacade implements java.io.Serializable{
	protected int mode = -1;
	protected final int READMODE = 0;
	protected final int WRITEMODE = 1;
	protected String moderator;
	protected ThreadBean tb;
	protected AbstractForumBean forumBean;
	protected String forumType;
	protected List<String> orderedThreads;
	protected Iterator<String> iterator;

	protected List<String> acceptableForumTypes;
	public abstract void promoteToModerator();
	public abstract boolean hasNextLoaded();
	protected abstract void setThreadsIDIterator();
	AbstractForumFacade(){
		//setThreadsIDIterator();
		String [] addThese = {	"Beans",
								"Editorials",
								"EnterpriseJava",
								"IndustryNews", 
								"MicroEdition", 
								"StandardEditionJava"};
		acceptableForumTypes = new ArrayList<String>();
		tb = new ThreadBean();
		for(String a : addThese){
			acceptableForumTypes.add(a);
		}
	}
	public AbstractForumBean getForumBean(){
		guardForumType();
		System.out.println("Attempting to set forumBean to " + this.forumType );
		if(forumType.equals("Beans") ){
			return (Beans)forumBean;
		}else if(forumType.equals("Editorials") ){
			return (Editorials)forumBean;
		}else if(forumType.equals("EnterpriseJava") ){
			return (EnterpriseJava)forumBean;
		}else if(forumType.equals("IndustryNews") ){
			return (IndustryNews)forumBean;
		}else if(forumType.equals("MicroEdition") ){
			return (MicroEdition)forumBean;
		}else if(forumType.equals("StandardEditionJava") ){
			return (StandardEditionJava)forumBean;
		}else{
			throw new NullPointerException("Warning guardForumType is not working since it did not guard against final else case");
		}
	}
	public AbstractForumBean setForumBean(){
		guardForumType();
		System.out.println("Attempting to set forumBean to " + this.forumType );
		if(forumType.equals("Beans") ){
			return this.forumBean = Beans.getInstance();
		}else if(forumType.equals("Editorials") ){
			return forumBean = Editorials.getInstance();
		}else if(forumType.equals("EnterpriseJava") ){
			return forumBean = EnterpriseJava.getInstance();
		}else if(forumType.equals("IndustryNews") ){
			return forumBean = IndustryNews.getInstance();
		}else if(forumType.equals("MicroEdition") ){
			return forumBean = MicroEdition.getInstance();
		}else if(forumType.equals("StandardEditionJava") ){
			return forumBean = StandardEditionJava.getInstance();
		}else{
			throw new NullPointerException("Warning guardForumType is not working since it did not guard against final else case");
		}
	}
	public AbstractForumBean setForumBean(String s){
		this.setForumType(s);
		System.out.println("Attempting to set forumBean to " + this.forumType );
		if(forumType.equals("Beans") ){
			return forumBean = Beans.getInstance();
		}else if(forumType.equals("Editorials") ){
			return forumBean = Editorials.getInstance();
		}else if(forumType.equals("EnterpriseJava") ){
			System.out.println("Getting static instance of EnterpriseJava");
			return forumBean = EnterpriseJava.getInstance();
		}else if(forumType.equals("IndustryNews") ){
			return forumBean = IndustryNews.getInstance();
		}else if(forumType.equals("MicroEdition") ){
			return forumBean = MicroEdition.getInstance();
		}else if(forumType.equals("StandardEditionJava") ){
			return forumBean = StandardEditionJava.getInstance();
		}else{
			throw new NullPointerException("Warning guardForumType is not working since it did not guard against final else case");
		}
	}
	public String getForumType() {
		return forumType;
	}
	private void guardForumType(){
		if(forumType==null){
			throw new NullPointerException("forumType needs to be set.");
		}
		if(!acceptableForumTypes.contains(forumType)){
			throw new IllegalStateException("forumType '" + forumType + "' is not in any of " + acceptableForumTypes.toString() );
		}
	}
	public void setForumType(String forumType) {
		if(forumType==null){
			throw new NullPointerException("argument forumType needs to be set.");
		}
		if(!acceptableForumTypes.contains(forumType)){
			throw new IllegalStateException("forumType '" + forumType + "' is not in any of " + acceptableForumTypes.toString() );
		}
		if( !( ( (this.forumType!=null) && forumType.equals("Beans") && (forumBean instanceof Beans) ) ||
			( (this.forumType!=null) && forumType.equals("Editorials") && (forumBean instanceof Editorials) ) ||
			( (this.forumType!=null) && forumType.equals("EnterpriseJava") && (forumBean instanceof EnterpriseJava) ) ||
			( (this.forumType!=null) && forumType.equals("IndustryNews") && (forumBean instanceof IndustryNews) ) ||
			!( (this.forumType!=null) && forumType.equals("MicroEdition") && (forumBean instanceof MicroEdition) ) ||
			( (this.forumType!=null) && forumType.equals("StandardEditionJava") && (forumBean instanceof StandardEditionJava) ) ) ){
			throw new IllegalStateException("Cannot reassign forumType of this object to " + forumType + " current type is " + this.forumType);
		}
		this.forumType = forumType;
	}
	public String getAuthor(){
		if(mode==READMODE){
			return tb.getAuthor();
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow reading");
		}
	}
	public String getComparisonType(){
		if(mode==READMODE){
			return tb.getComparisonType();
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow reading");
		}
	}
	public String getContent(){
		if(mode==READMODE){
			return tb.getContent();
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow reading");
		}
	}
	public String getDateposted(){
		if(mode==READMODE){
			return tb.getDateposted();
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow reading");
		}
	}
	public String getOriginDate(){
		if(mode==READMODE){
			return tb.getOriginDate();
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow reading");
		}
	}
	public String getTitle(){
		if(mode==READMODE){
			return tb.getTitle();
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow reading");
		}
	}
	public int getRating(){
		if(mode==READMODE){
			return tb.getRating();
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow reading");
		}
	}
	public String getModerator() {
		if(mode==READMODE){
			return moderator;
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow reading");
		}
	}

	
	///////////////////////////////////////////////////WRITE MODE//////////////////////////////////////////////
	public void setAuthor(String author){
		if(mode==WRITEMODE){
			tb.setAuthor(author);
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow writing");
		}
	}
	public void setComparisonType(String comparisonType){
		if(mode==WRITEMODE){
			tb.setComparisonType(comparisonType);
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow writing");
		}
	}
	public void setContent(String content){
		if(mode==WRITEMODE){
			tb.setContent(content);
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow writing");
		}
	}
	public void setDateposted(String dateposted){
		if(mode==WRITEMODE){
			tb.setDateposted(dateposted);
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow writing");
		}
	}
	///NOTE: THERE IS NO setOriginDate in ThreadBean. Origin dates should always reflect when post was made
	///      use setDateposted or rating to affect sort of the thread index
	public void setTitle(String title){
		if(mode==WRITEMODE){
			tb.setTitle(title);
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow writing");
		}
	}
	public void setRating(int rating){
		if(mode==WRITEMODE){
			tb.setRating(rating);
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow writing");
		}
	}
	public void setModerator(String moderator) {
		if(mode==WRITEMODE){
			this.moderator = moderator;
		}else{
			throw new IllegalStateException("Current mode is " + mode + " which does not allow writing");
		}
	}
	
}
