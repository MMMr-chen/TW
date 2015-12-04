public class Weapon  {
    private String name;
    private int attack;
    private int type;
    private Debuff debuff=new NoBuff();
    public Weapon(String name,int attack){
        this.name=name;
        this.attack=attack;
    }
    public Weapon(String name,int attack,int type){
        this.name=name;
        this.attack=attack;
        this.type=type;
    }
    public Weapon(String name, int attack, Debuff debuff, int type){
        this.name=name;
        this.attack=attack;
        this.debuff=debuff;
        this.type=type;
    }
    public String getName(){
        return name;
    }
    public String beUsed(){
        return "使用"+name;
    }
    public int getAttack(){
        return attack;
    }
    public void setDebuff(Debuff debuff){this.debuff=debuff;}
    public Debuff getDebuff(){return debuff;}
    public int getType(){return type;}
}
