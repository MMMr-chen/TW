public class Armor {
    private String name;
    private int defend;
    public Armor(String name,int defend){
        this.name=name;
        this.defend=defend;
    }
    public String getName(){
        return name;
    }
    public int getDefend(){
        return defend;
    }
}
