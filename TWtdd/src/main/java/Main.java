import java.util.Scanner;

/**
 * Created by czh on 15-11-27.
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome!");
        String state=new String();
        int count=7;
        String result=RandomNumProducer.randomproducer();
        GameState gameState=GameState.getGameState();
        gameState.judgeState(count,state);
        while (!state.equals("Win")&&!state.equals("Lose")){
            String input=scanner.next();
            if (!UserInputNumCheck.inputcheck(input)){
                continue;
            }
            state=gameState.judgeState(count,NumberCompare.numberCompare(input,result));
            count--;

        }
        scanner.close();
        System.exit(0);
    }
}
