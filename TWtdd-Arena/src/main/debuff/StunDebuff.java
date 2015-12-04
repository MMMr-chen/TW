import java.util.Random;

import static java.lang.String.format;

public class StunDebuff extends Debuff{
    private static int TYPE=4;
    private Random random;
    private int remainturn=0;
    private int rate=4;
    private static final int TURN=4;
    public StunDebuff(Random random){
        this.random=random;
    }
    public String isLaunched(Player victim){
        if (random.nextInt(10)<rate) {
            if (victim.getDebuff().getType()!=4) {
                victim.setDebuff(new StunDebuff(new Random()));
                victim.getDebuff().addRemainturn(TURN);
            }
            else
            victim.getDebuff().addRemainturn(TURN);
            return format("%s被打晕了,", victim.getName());
        }
        return "";
    }

    public String isEffected(Player victim){
        remainturn--;
        return format("%s因为眩晕无法攻击,剩余%d回合",victim.getName(),remainturn);
    }
    public int getType(){return TYPE;}
    public int getTurn(){return TURN;}
    public void addRemainturn(int remainturn){this.remainturn+=remainturn;}
    public int getRemainturn(){return remainturn;}
}
