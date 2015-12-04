import java.util.Random;

import static java.lang.String.format;

public class PoisonDebuff extends Debuff {
    private static int TYPE=1;
    private Random random;
    private int remainturn=0;
    private static final int DAMAGE =2;
    private static final int RATE =4;
    private static final int TURN=4;
    public PoisonDebuff(Random random){
        this.random=random;
    }
    public String isLaunched(Player victim){
        if (random.nextInt(10)< RATE) {
            if (victim.getDebuff().getType()!=1) {
                victim.setDebuff(new PoisonDebuff(new Random()));
                victim.getDebuff().addRemainturn(TURN);
            }
            else
            victim.getDebuff().addRemainturn(TURN);
            return format("%s中毒了,", victim.getName());
        }
        return "";
    }
    public String isEffected(Player victim){
        remainturn--;
        victim.setHealth(victim.getHealth()- DAMAGE);
        return format("%s受到%d点毒性伤害,%S剩余生命值%d",victim.getName(), DAMAGE,victim.getName(),victim.getHealth());
    }

    public int getType(){return TYPE;}
    public int getTurn(){return TURN;}
    public void addRemainturn(int remainturn){this.remainturn+=remainturn;}
    public int getRemainturn(){return remainturn;}
}
