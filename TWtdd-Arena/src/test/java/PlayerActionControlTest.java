import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.*;

public class PlayerActionControlTest {
    private PlayerActionControl playerActionControl;
    private Player one;
    private Player two;
    private Warrior warrior;
    private Weapon weapon;
    private Armor armor;
    private GamePrinter gamePrinter;
    @Before
    public void setUp() throws Exception{

        one=new Player(10,30,"张三");
        two=new Player(20,40,"李四");
        warrior=new Warrior(10,40,"王五");
        armor=new Armor("护甲",10);
        weapon=new Weapon("大剑",10,1);
        warrior.equipArmor(armor);
        warrior.equipWeapon(weapon);
        gamePrinter=new GamePrinter();

    }
    @Test
    public void setPlayerAttackControlTest(){
        playerActionControl=new PlayerActionControl(one,two,gamePrinter);
        assertThat(playerActionControl.attackAction(),is("李四攻击了张三,张三受到了20点伤害,张三剩余生命值10"));
        assertThat(playerActionControl.attackAction(),is("张三攻击了李四,李四受到了10点伤害,李四剩余生命值30"));
        assertThat(playerActionControl.attackAction(),is("李四攻击了张三,张三受到了20点伤害,张三剩余生命值-10"));
    }
    @Test
    public void rolePlayerAttackControlTest(){
        playerActionControl=new PlayerActionControl(warrior,two,gamePrinter);
        assertThat(playerActionControl.attackAction(),is("李四攻击了战士王五,王五受到了10点伤害,王五剩余生命值30"));
        assertThat(playerActionControl.attackAction(),is("战士王五使用大剑攻击了李四,李四受到了20点伤害,李四剩余生命值20"));
        assertThat(playerActionControl.attackAction(),is("李四攻击了战士王五,王五受到了10点伤害,王五剩余生命值20"));
        assertThat(playerActionControl.attackAction(),is("战士王五使用大剑攻击了李四,李四受到了20点伤害,李四剩余生命值0"));
    }
    @Test
    public void debuffLaunchTest() throws Exception{
        playerActionControl=new PlayerActionControl(warrior,two,gamePrinter);
        Random random=mock(Random.class);
        Debuff debuff=new FireDebuff(random);
        weapon.setDebuff(debuff);
        when(random.nextInt(10)).thenReturn(3);
        assertThat(playerActionControl.attackAction(),is("李四攻击了战士王五,王五受到了10点伤害,王五剩余生命值30"));
        assertThat(playerActionControl.attackAction(),is("战士王五使用大剑攻击了李四,李四受到了20点伤害,李四着火了,李四剩余生命值20"));
    }
    @Test
    public void debuffEffectedTest() throws Exception{
        Random random=mock(Random.class);
        GamePrinter gamePrinter=mock(GamePrinter.class);
        Debuff debuff=new PoisonDebuff(random);
        weapon.setDebuff(debuff);
        warrior.equipWeapon(weapon);
        InOrder inOrder=inOrder(gamePrinter);
        when(random.nextInt(10)).thenReturn(3);
        playerActionControl=new PlayerActionControl(warrior,two,gamePrinter);
        playerActionControl.attackAction();
        playerActionControl.attackAction();
        playerActionControl.attackAction();
        playerActionControl.attackAction();
        inOrder.verify(gamePrinter,times(1)).print("李四受到2点毒性伤害,李四剩余生命值18");
    }
    @Test
    public void troubleDamageTest() throws Exception{
        Random random=mock(Random.class);
        weapon.setDebuff(new TroubleBuff(random));
        warrior.equipWeapon(weapon);
        when(random.nextInt(10)).thenReturn(3);
        playerActionControl=new PlayerActionControl(two,warrior,gamePrinter);
        assertThat(playerActionControl.attackAction(),
                is("战士王五使用大剑攻击了李四,战士王五发动了全力一击,李四受到了60点伤害,李四剩余生命值-20"));

    }

}