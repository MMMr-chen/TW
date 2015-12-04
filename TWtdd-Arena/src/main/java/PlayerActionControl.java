
public class PlayerActionControl {
    private Player one;
    private Player two;
    private int turn =0;
    private DebuffControl debuffControl;
    public PlayerActionControl(Player one, Player two,GamePrinter gamePrinter){
        this.one=one;
        this.two=two;
        debuffControl=new DebuffControl(gamePrinter);
    }

    public String attackAction(){
        if (turn++%2==0){

            if (debuffControl.debuffCaculate(two)&&two.isAlive())
            return two.attackAction(one)+one.attackedAction(two);
            else
                return "";
        }
        else {
            if (debuffControl.debuffCaculate(one)&&one.isAlive())
            return one.attackAction(two)+two.attackedAction(one);
            else
                return "";
        }
    }
}
