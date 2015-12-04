import java.util.Random;

import static java.lang.String.format;
public class IceDebuff extends Debuff {
        private static int TYPE=3;
        private Random random;
        private int remainturn=0;
        private static final int RATE=4;
        private static final int TURN=4;
    private static final int DAMAGE=1;
        public IceDebuff(Random random){
            this.random=random;
        }
    public String isLaunched(Player victim){
        if (random.nextInt(10)< RATE) {
            if (victim.getDebuff().getType()!=3) {
                victim.setDebuff(new IceDebuff(new Random()));
                victim.getDebuff().addRemainturn(TURN);
            }
            else
            victim.getDebuff().addRemainturn(TURN);
            return format("%s结冰了,", victim.getName());
        }
        return "";
    }

        public String isEffected(Player victim){

            remainturn--;
            victim.setHealth(victim.getHealth()- DAMAGE);
            return format("%s受到%d点冰冻伤害",victim.getName(),DAMAGE);
        }
        public int getType(){return TYPE;}
    public int getTurn(){return TURN;}
    public void addRemainturn(int remainturn){this.remainturn+=remainturn;}
    public int getRemainturn(){return remainturn;}
}
