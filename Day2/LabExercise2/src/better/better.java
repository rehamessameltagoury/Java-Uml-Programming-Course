package better;

public class better {
  public String betterString(String first,String second,compare c) { 
	  boolean result = c.compareString(first, second);
	  //System.out.println(result);
	  if (result == true) return first;
	  else return second;
  }
}
