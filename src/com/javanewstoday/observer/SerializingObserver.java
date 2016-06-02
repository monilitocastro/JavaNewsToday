package com.javanewstoday.observer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.javanewstoday.account.Users;

public class SerializingObserver implements Runnable{
	List<Observable> observables;
	private static SerializingObserver o;
	private SerializingObserver(){
		super();
		observables = new ArrayList<Observable>();
		
	}
	public static SerializingObserver getInstance(){
		Thread thread = null;
		if(o==null){
			o = new SerializingObserver();
			thread = new Thread(o);
			thread.start();
		}
		return o;
	}
	public void update() {
		System.out.println("WRITING SERIALIZABLE OBJECTS TO LOCAL DISK");
		for(Observable o : observables){
			if(o!=null){
				o.write();
				System.out.println("       " +  o.toString() );
			}
		}
		System.out.println("DONE WRITING------------------------------");
	}
	public void addToList(Observable o){
		observables.add(o);
	}
	public void removeFromList(Observable o){
		observables.remove(o);
	}
	public void register(Observable e) {
		// TODO Auto-generated method stub
		if(o==null){
			o=getInstance();
		}
		observables.add(e);
	}
	@Override
	public void run() {
		int interval = 1000 * 60 * 10; //10 minutes
		while(true){
			try {
				Thread.sleep(interval);
				update();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				update();
				e.printStackTrace();
			}
		}
	}
}
