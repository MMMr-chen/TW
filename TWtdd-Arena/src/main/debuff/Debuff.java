public abstract class Debuff {
    public abstract String isLaunched(Player player);
    public abstract String isEffected(Player player);
    public abstract int getType();
    public abstract int getTurn();
    public abstract void addRemainturn(int remainturn);
    public abstract int getRemainturn();

}
