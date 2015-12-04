import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Assassin extends Player {
    private Armor armor=new Armor("",0);
    private Weapon weapon=new Weapon("",0);
    private static String role="刺客";
    private static int launchType=0;
    private static List<Integer> usertypelist=new ArrayList<Integer>(){{add(1);add(0);}};
    public Assassin(int attack,int health,String name){
        super(attack,health,name);
    }
    @Override
    public int getDamage(){
        return this.getAttack()+weapon.getAttack();
    }
    @Override
    public String attackedAction(Player two){
        int hurt;
        if (two.getWeapon().getDebuff().getType()==5&&two.getWeapon().getDebuff().isEffected(two).equals("true")) {
            hurt=Math.max(0,two.getDamage()*3-armor.getDefend());
            this.setHealth(this.getHealth()-hurt);
            return format("%s受到了%d点伤害,%%s剩余生命值%d", super.getName(), hurt,
                    super.getName(), this.getHealth());
        }else {
            hurt=Math.max(0,two.getDamage()-armor.getDefend());
            this.setHealth(this.getHealth()-hurt);
            if (two.getLaunchType()==two.getWeapon().getType())
            return format("%s受到了%d点伤害,%s%s剩余生命值%d", super.getName(), hurt,
                    two.getWeapon().getDebuff().isLaunched(this),super.getName(),
                    this.getHealth());
            else
                return format("%s受到了%d点伤害,%s剩余生命值%d", super.getName(), hurt,super.getName(),
                        this.getHealth());
        }

    }
    @Override
    public String attackAction(Player two){
        if (weapon.getDebuff().getType()==5&&weapon.getType()==launchType)
            return format("%s%s攻击了%s,%s",this.getName(),weapon.beUsed(),two.getName(),weapon.getDebuff().isLaunched(this));
        return format("%s%s攻击了%s,",this.getName(),weapon.beUsed(),two.getName());
    }
    @Override
    public String getName(){return role+super.getName();}
    public void  equipArmor(Armor armor){
        this.armor=armor;
    }
    public void equipWeapon(Weapon weapon)throws Exception{
        if (usertypelist.contains(weapon.getType()))
        this.weapon=weapon;
        else
            throw new Exception("cant equip weapon");
    }
    @Override
    public Weapon getWeapon(){return weapon;}
    public int getLaunchType(){return launchType;}

}
