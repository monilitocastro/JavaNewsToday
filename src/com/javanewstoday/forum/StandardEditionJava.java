package com.javanewstoday.forum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.javanewstoday.observer.SerializingObserver;

public class StandardEditionJava extends AbstractForumBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static StandardEditionJava instance;
	private static SerializingObserver observer;
	private StandardEditionJava() {
		super();
	}
	
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
	
	
	public static StandardEditionJava getInstance(String moderator){
		String p = "StandardEditionJava";
		if(instance==null){
	      try
	      {
	         FileInputStream fileIn = new FileInputStream( getSerializableFilename() );
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         instance = (StandardEditionJava) in.readObject();
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
			instance = new StandardEditionJava();
			instance.setPurpose(p);
			instance.setModerator(moderator);
		}
		observer = SerializingObserver.getInstance();
		observer.addToList(instance);
		return (StandardEditionJava) instance;
	}
	public static StandardEditionJava getInstance(){
		return getInstance("");
	}
	
	public static String getSerializableFilename() {
		// TODO Auto-generated method stub
		return "StandardEdition.ser";
	}
}
