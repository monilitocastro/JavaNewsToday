package com.javanewstoday.account;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.javanewstoday.observer.Observable;
import com.javanewstoday.observer.SerializingObserver;

public class Users implements java.io.Serializable, Observable{
	Hashtable<String, UserBean> users;
	List<UserBean> inactiveUsers;
	private static Users usersObject;
	private static SerializingObserver observer;
	private Users(){}
	
	public static Users getInstance(){
		if(usersObject==null){
	      try
	      {
	         FileInputStream fileIn = new FileInputStream( getSerializableFilename() );
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         usersObject = (Users) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Users class not found");
	         c.printStackTrace();
	      }
		
		}
		if(usersObject==null){
			usersObject = new Users();
		}
		observer = SerializingObserver.getInstance();
		observer.addToList(usersObject);
		return (Users) usersObject;
	}
	

	
	private void addNewUser(String username, String password, String email, int rating){
		init();
		UserBean ub = new UserBean();
		ub.setUsername(username);
		ub.setPassword(password);
		ub.setEmail(email);
		ub.setRating(rating);
		users.put(username, ub);
	}
	public boolean containsUser(String u){
		init();
		System.out.println(users.toString() );
		return users.containsKey(u);
	}
	private void addNewUser(String username, String password, String email){
		addNewUser(username, password, email, 0);
	}
	public UserBean getUserBean(String u, String p){
		UserBean ub = users.get(u);
		if(ub.getPassword().equals(p)){
			return ub;
		}
		return null;
	}
	public UserBean getUserBean(String u){
		UserBean ub = users.get(u);
		return ub;
	}
	public boolean registerNewUser(String username, String password, String email){
		
		if(containsUser(username)){
			return false;
		}else{
			addNewUser( username,  password,  email);
			return true;
		}
	}
	public void inactivateUser(String username){
		init();
		if(containsUser(username)){
			inactiveUsers.add(users.get(username));
			users.remove(username);
		}
	}
	private void init(){
		if(users==null){
			users = new Hashtable<String, UserBean>();
		}
		if(inactiveUsers==null){
			inactiveUsers = new ArrayList<UserBean>();
		}
	}
	public void decorateUserBean(UserBean userBean) {
		String username = userBean.getUsername();
		String password = userBean.getPassword();
		if(validateUserPassword(username, password) ){
			userBean.copy(users.get(username) );
		}
		
	}
	public int getRatingOf(String u){
		if(containsUser(u) ){
			return users.get(u).getRating();
		}
		return Integer.MIN_VALUE;
	}
	private void addToRating(String u, int i){
		if(containsUser(u) ){
			UserBean ub = users.get(u);
			int r = ub.getRating();
			r += i;
			ub.setRating(r);
		}
	}
	public void incrementRating(String u){
		addToRating(u, 1);
	}
	public void decrementRating(String u){
		addToRating(u, -1);
	}
	public boolean validateUserPassword(String u, String p){
		if(containsUser(u)){
			UserBean ub = users.get(u);
			if(p.equals(ub.getPassword() ) ){
				
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	/*
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
	@Override
	public String getSerializableFilename() {
		// TODO Auto-generated method stub
		return "Users.ser";
	}*/
	@Override
	public void getObserver() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void registerSelf() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void write(){
		try {
			FileOutputStream fileOut = new FileOutputStream(getSerializableFilename() );
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(usersObject);
	         out.close();
	         fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static String getSerializableFilename() {
		// TODO Auto-generated method stub
		return "Users.ser";
	}
	
}
