public class DebuffControl {
    private Player victim;
    private GamePrinter gamePrinter;
    private final int FIRE=0;
    public DebuffControl(GamePrinter gamePrinter){
        this.gamePrinter=gamePrinter;
    }
    public boolean debuffCaculate(Player victim){
        Debuff debuff=victim.getDebuff();
        switch (debuff.getType()){
            case 1:
                gamePrinter.print(debuff.isEffected(victim));
                break;
            case 2:
                gamePrinter.print(debuff.isEffected(victim));
                break;
            case 3:
                if (debuff.getRemainturn()%2==1) {
                    gamePrinter.print(debuff.isEffected(victim)+",无法攻击,");
                    return false;
                }
                else
                gamePrinter.print(debuff.isEffected(victim));
                break;
            case 4:
                if (debuff.getRemainturn()>0){
                    gamePrinter.print(debuff.isEffected(victim));
                    return false;
                }
                break;
            default:break;
        }
        if (debuff.getRemainturn()==0)
            victim.setDebuff(new NoBuff());
        return true;
    }
}
