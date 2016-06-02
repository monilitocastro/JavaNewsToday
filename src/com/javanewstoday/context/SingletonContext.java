package com.javanewstoday.context;

public abstract class SingletonContext {
	private static SingletonContext t;
	public abstract SingletonContext getInstance();
}
