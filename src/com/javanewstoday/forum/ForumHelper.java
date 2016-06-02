package com.javanewstoday.forum;

public class ForumHelper {
	public static String generateAlphanumericCode(int length){
		StringBuilder build = new StringBuilder();
		int randomNum;
		for(int i=0;i<length;i++){
			randomNum = (int)(Math.random() * 36); 
			if(randomNum>25){
				randomNum -= 26;
				build.append(randomNum);
			}else{
				randomNum += (int)'A';
				build.append( (char)randomNum  );
			}
			
		}
		return build.toString();
	}
}
