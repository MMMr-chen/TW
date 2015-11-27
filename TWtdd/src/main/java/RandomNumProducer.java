import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by czh on 15-11-27.
 */
public class RandomNumProducer {
    public static String randomproducer(){
        int length=4;
        Set randomSet=new HashSet();
        Random random=new Random();
        int size=randomSet.size();
        char[] rannumch=new char[length];
        for (int i=0;i<length;){
            char ran=(char)(random.nextInt(10)+48);
            randomSet.add(ran);
            if (randomSet.size()>size){
                size=randomSet.size();
                rannumch[i]=ran;
                i++;
            }
        }
        return new String(rannumch);
    }
}
