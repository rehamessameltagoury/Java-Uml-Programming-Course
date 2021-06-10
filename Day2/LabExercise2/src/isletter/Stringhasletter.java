package isletter;

public class Stringhasletter {
public static boolean StringhasNumber_method(String s) 
{ 
	return s != null && s.chars().allMatch(Character::isLetter);

}
}
