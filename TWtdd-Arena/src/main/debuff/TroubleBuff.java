import java.util.Random;

import static java.lang.String.format;

public class TroubleBuff extends Debuff{
    private static int TYPE=5;
    private Random random;
    private int rate=4;
    public boolean launch=false;
    public TroubleBuff(Random random){
        this.random=random;
    }

    public String isLaunched(Player attacker){
        if (random.nextInt(10)<rate) {
            launch=true;
            return format("%s发动了全力一击,", attacker.getName());
        }
        return "";
    }

    public String isEffected(Player attacker){
        if (launch){
            launch=false;
            return "true";
        }
        return "";
    }

    public int getType(){return TYPE;}
    public int getTurn(){return 0;}
    public void addRemainturn(int remainturn){}
    public int getRemainturn(){return 0;}
}
