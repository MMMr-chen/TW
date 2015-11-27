import java.util.HashSet;
import java.util.Set;

/**
 * Created by czh on 15-11-27.
 */
public class UserInputNumCheck {
    public static boolean inputcheck(String input){
        Set inputch=new HashSet();
        for (int i=0;i<input.length();i++){
            inputch.add(input.charAt(i));
        }
        if (inputch.size()==4)
            return true;
            else{
            System.out.println("Cannot input duplicate numbers!");

            return false;}
    }
}
