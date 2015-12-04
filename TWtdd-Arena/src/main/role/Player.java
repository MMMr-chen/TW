import static java.lang.String.format;

public class Player {
    private int attack;
    private int health;
    private String name;
    private Debuff debuff;
    private Weapon weapon=new NoWeapon();
    public Player(int inattack,int inhealth,String inname){
        this.name=inname;
        this.attack=inattack;
        this.health=inhealth;
        this.debuff=new NoBuff();
    }
    public int getDamage(){

        return attack;
    }
    public String attackedAction(Player two){
        if (two.getWeapon().getDebuff().getType()==5&&two.getWeapon().getDebuff().isEffected(two).equals("true")) {
            health -= two.getDamage()*3;
            return format("%s受到了%d点伤害,%s剩余生命值%d", this.getName(), two.getDamage()*3,
                    this.getName(), this.getHealth());
        }else {
            health -= two.getDamage();
            return format("%s受到了%d点伤害,%s%s剩余生命值%d", this.getName(), two.getDamage(),
                    two.getWeapon().getDebuff().isLaunched(this), this.getName(),
                    this.getHealth());
        }
    }
    public String attackAction(Player two){
        return format("%s攻击了%s,",name,two.getName());
    }
    public int getHealth(){
        return health;
    }
    public String getName(){
        return name;
    }
    public int getAttack(){
        return attack;
    }
    public boolean isAlive(){return health>=0;}
    public void setHealth(int health){this.health=health;}
    public void setDebuff(Debuff debuff){
        if (this.debuff.getType()==0)
        this.debuff=debuff;
    else if(this.debuff.getType()==debuff.getType()){
            this.debuff.addRemainturn(debuff.getTurn());
        }
    }
    public Debuff getDebuff(){return debuff;}
    public Weapon getWeapon(){return weapon;}
    public int getLaunchType(){return -1;}

}
