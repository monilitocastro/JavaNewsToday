package com.javanewstoday.forum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.javanewstoday.observer.SerializingObserver;

public class EnterpriseJava extends AbstractForumBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static EnterpriseJava instance;
	private static SerializingObserver observer;
	private EnterpriseJava() {
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
	
	
	public static EnterpriseJava getInstance(String moderator){
		String p = "EnterpriseJava";
		if(instance==null){
	      try
	      {
	         FileInputStream fileIn = new FileInputStream( getSerializableFilename() );
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         instance = (EnterpriseJava) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i){
		       	 i.printStackTrace();
	      }catch(ClassNotFoundException c){
	         System.out.println("EnterpriseJava class not found");
	         c.printStackTrace();
	      }
	      if(instance==null)System.out.println("INSTANCE IS STILL NULL EVEN AFTER TRYING TO FIND FILE!");
		}
		if(instance==null){
			instance = new EnterpriseJava();
			instance.setPurpose(p);
			instance.setModerator(moderator);
			if(instance!=null)System.out.println("INSTANCE IS NOT NULL");
		}
		if(instance==null)System.out.println("INSTANCE IS NULL");
		observer = SerializingObserver.getInstance();
		observer.addToList(instance);
		return (EnterpriseJava) instance;
	}
	//Need to implement this static method in sub classes
	public static EnterpriseJava getInstance(){
		return getInstance("");
	}
	
	public static String getSerializableFilename() {
		// TODO Auto-generated method stub
		return "EnterpriseJava.ser";
	}
}
