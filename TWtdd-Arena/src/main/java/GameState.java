
public class GameState {
    private Player one;
    private Player two;
    private GamePrinter gamePrinter;
    private PlayerActionControl playerActionControl;
    public GameState(Player one,Player two,GamePrinter gamePrinter){
        this.one=one;
        this.two=two;
        this.gamePrinter=gamePrinter;
        this.playerActionControl =new PlayerActionControl(one,two,gamePrinter);
    }
    public String game(){
        while (one.isAlive()&&two.isAlive()) {
            gamePrinter.print(playerActionControl.attackAction());
        }
        if (!one.isAlive()){
            gamePrinter.print(two.getName()+" win");
            return "over";
        }
        else if(!two.isAlive()){
            gamePrinter.print(one.getName()+" win");
            return "over";
        }
        return "Wrong";
    }
}
