public class NoWeapon extends Weapon {

    public NoWeapon(){
       super("",0);
    }
   @Override
    public String beUsed(){
        return "";
    }
   @Override
    public void setDebuff(Debuff debuff){}
}
