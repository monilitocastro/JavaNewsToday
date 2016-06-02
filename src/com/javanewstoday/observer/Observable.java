package com.javanewstoday.observer;

public interface Observable {
	public void getObserver();
	public void registerSelf();
	public void write();
}