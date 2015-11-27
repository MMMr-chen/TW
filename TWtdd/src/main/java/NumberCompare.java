/**
 * Created by czh on 15-11-27.
 */
public class NumberCompare {
    public static String numberCompare(String inputnumber,String resnumber){
        char[] input=inputnumber.toCharArray();
        char[] res=resnumber.toCharArray();
        int countA=0;int countB=0;
        for(int i=0;i<res.length;i++){
            for(int j=0;j<input.length;j++){
                if (i==j&&res[i]==input[j])
                    countA++;
                else if (res[i]==input[j])
                countB++;
            }
        }
        System.out.println(countA+"A"+countB+"B");
        System.out.println();
        return countA+"A"+countB+"B";
    }
}
