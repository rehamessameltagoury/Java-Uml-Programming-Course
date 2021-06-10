package Main;

import better.better;
import isletter.Stringhasletter;

public class mainClass {
	public static void main(String[] args)  {
	 better comp = new better();
	 
	 String s1="Hello";
	 String s2="world";
	String betterString = comp.betterString(s1, s2, (s_1, s_2) -> s1.length() > s2.length());
	String betterString2=comp.betterString(s1, s2, (s_1, s_2) -> true);
	System.out.println(betterString);
	System.out.println(betterString2);
	
	
	/////////////////////////////////////////////////////////
	String s_letter="Hello123";
	System.out.println(Stringhasletter.StringhasNumber_method(s_letter));
	/////////////////////////////////////////////////////////

}

 }
