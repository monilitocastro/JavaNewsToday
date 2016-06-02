package com.javanewstoday.forum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.javanewstoday.observer.Observable;
import com.javanewstoday.observer.SerializingObserver;

public class Beans extends AbstractForumBean{
	/**
	 * UPDATE serialVersionUID if structure is changed
	 */
	private static final long serialVersionUID = 1L;
	private static Beans instance;
	private static SerializingObserver observer;
	private Beans() {
		super();
	}
	
	
	//Need to implement this static method in sub classes
	public void write(){
		try {
			FileOutputStream fileOut = new FileOutputStream(getSerializableFilename() );
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(instance);
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
	
	
	public static Beans getInstance(String moderator){
		String p = "Beans";
		if(instance==null){
	      try
	      {
	         FileInputStream fileIn = new FileInputStream( getSerializableFilename() );
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         instance = (Beans) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Observable class not found");
	         c.printStackTrace();
	      }
		
		}
		if(instance==null){
			instance = new Beans();
			instance.setPurpose(p);
			instance.setModerator(moderator);
		}
		observer = SerializingObserver.getInstance();
		observer.addToList(instance);
		return (Beans) instance;
	}
	//Need to implement this static method in sub classes
	public static Beans getInstance(){
		return getInstance("");
	}
	
	public static String getSerializableFilename() {
		// TODO Auto-generated method stub
		return "Beans.ser";
	}
}