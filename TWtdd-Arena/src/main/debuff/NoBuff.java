import java.util.Random;

import static java.lang.String.format;

public class NoBuff extends Debuff{
    private static int TYPE=0;
    private Random random;
    private int remainturn=0;
    public String isLaunched(Player victim){
        return "";
    }

    public String isEffected(Player victim){
        return "";
    }
    public int getType(){return TYPE;}
    public int getTurn(){return 0;}
    public void addRemainturn(int remainturn){}
    public int getRemainturn(){return remainturn;}
}
