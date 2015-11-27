/**
 * Created by czh on 15-11-27.
 */
public class GameState {
    private void GameState(){};
    private static int MaxCount=6;
    private static GameState gameState=new GameState();
    public  static GameState getGameState(){
        return  gameState;
    }
    public static String judgeState(int precount,String result){
        if (result.equals("4A0B")){
            System.out.println("Congratulations!");
            return "Win";}
        else if (--precount==0){
            System.out.println("Game Over");
            return  "Lose";
        }
             else{
            System.out.println("Please input your number("+precount+")");
            return String.valueOf(precount);
        }


    }
}
