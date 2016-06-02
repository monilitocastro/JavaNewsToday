package com.javanewstoday.account;

public class UserBean implements java.io.Serializable{
	private String username;
	private String password;
	private String email;
	private String mode;
	private int rating;
	public void copy(UserBean ub){
		setUsername( ub.getUsername());
		setPassword( ub.getPassword());
		setEmail( ub.getEmail() );
		setRating( ub.getRating() );
		setMode( ub.getMode() );
	}
	public boolean logUserIn(String u, String p){
		Users users = Users.getInstance();
		if(userExists() ){
			UserBean ub = users.getUserBean(u);
			if(ub.getPassword().equals(p)){
				this.copy(ub);
				return true;
			}
			return false;
		}
		return false;
	}
	public boolean userExists(){
		Users users = Users.getInstance();
		if(users.containsUser(this.username)){
			return true;
		}
		return false;
	}
	public boolean registerNewUser(){
		Users users = Users.getInstance();
		return users.registerNewUser(username, password, email);
	}
	public void incrementRating(){
		Users users = Users.getInstance();
		users.incrementRating(username);
		this.rating = users.getRatingOf(username);
	}
	public void decrementRating(){
		Users users = Users.getInstance();
		users.decrementRating(username);
		this.rating = users.getRatingOf(username);
	}
	public void registerBean(){
		Users users = Users.getInstance();
		users.decorateUserBean(this);
	}
	public String getUsername() {

		return username;
	}
	public void setUsername(String username) {
		//System.out.println("Username is set: "+username);
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		//System.out.println("Email is set: "+email);
		this.email = email;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
}
