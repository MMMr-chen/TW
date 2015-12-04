import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by czh on 15-11-30.
 */
@RunWith(MockitoJUnitRunner.class)

public class GameStateTest {
    @Mock
    private GamePrinter gamePrinter;
    private Random random;
    InOrder inOrder;
    @Before
    public void setUp(){

        random=mock(Random.class);
        inOrder=inOrder(gamePrinter);
    }
    @Test
    public void gameStateTest() throws Exception{
        Player one=new Player(10,30,"里斯");
        Player two=new Player(20,40,"张三");
        GameState gameState=new GameState(one,two,gamePrinter);
        gameState.game();
        inOrder.verify(gamePrinter,times(1)).print("张三攻击了里斯,里斯受到了20点伤害,里斯剩余生命值10");
        inOrder.verify(gamePrinter,times(1)).print("里斯攻击了张三,张三受到了10点伤害,张三剩余生命值30");
        inOrder.verify(gamePrinter,times(1)).print("张三攻击了里斯,里斯受到了20点伤害,里斯剩余生命值-10");
        inOrder.verify(gamePrinter,times(1)).print("张三 win");

    }
    @Test
    public void gameStateIntegrationTest1() throws Exception{
        Warrior warrior =new Warrior(10,50,"张三");
        Player normal =new Player(10,50,"普通人");
        Weapon weapon=new Weapon("大剑",10,new FireDebuff(random),1 );
        Armor armor=new Armor("布甲",5);
        warrior.equipWeapon(weapon);
        warrior.equipArmor(armor);
        GameState gameState=new GameState(warrior,normal,gamePrinter);
        gameState.game();
        when(random.nextInt(10)).thenReturn(3);
        inOrder.verify(gamePrinter, times(1)).print("普通人攻击了战士张三,张三受到了5点伤害,张三剩余生命值45");
        inOrder.verify(gamePrinter, times(1)).print("战士张三使用大剑攻击了普通人,普通人受到了20点伤害,普通人着火了,普通人剩余生命值30");
        inOrder.verify(gamePrinter, times(1)).print("普通人受到2点火性伤害,普通人剩余生命值28");
        inOrder.verify(gamePrinter, times(1)).print("普通人攻击了战士张三,张三受到了5点伤害,张三剩余生命值40");
        inOrder.verify(gamePrinter, times(1)).print("战士张三使用大剑攻击了普通人,普通人受到了20点伤害,普通人着火了,普通人剩余生命值8");
        inOrder.verify(gamePrinter, times(1)).print("普通人受到2点火性伤害,普通人剩余生命值6");
        inOrder.verify(gamePrinter, times(1)).print("普通人攻击了战士张三,张三受到了5点伤害,张三剩余生命值35");
        inOrder.verify(gamePrinter, times(1)).print("战士张三使用大剑攻击了普通人,普通人受到了20点伤害,普通人着火了,普通人剩余生命值-14");
        inOrder.verify(gamePrinter, times(1)).print("战士张三 win");
    }
    @Test
    public void gameStateIntegrationTest2() throws Exception{
        Warrior warrior=new Warrior(20,80,"加尔鲁斯");
        Assassin assassin=new Assassin(20,60,"瓦莉拉");
        Weapon shortWeapon=new Weapon("毒短刃",10,new PoisonDebuff(random),0);
        Weapon mediumWeapon=new Weapon("冰刀",5,new IceDebuff(random),1);
        warrior.equipWeapon(mediumWeapon);
        assassin.equipWeapon(shortWeapon);
        GameState gameState=new GameState(warrior,assassin,gamePrinter);
        gameState.game();
        when(random.nextInt(10)).thenReturn(2);
        inOrder.verify(gamePrinter,times(1)).print("刺客瓦莉拉使用毒短刃攻击了战士加尔鲁斯,加尔鲁斯受到了30点伤害,战士加尔鲁斯中毒了,加尔鲁斯剩余生命值50");
        inOrder.verify(gamePrinter,times(1)).print("战士加尔鲁斯受到2点毒性伤害,加尔鲁斯剩余生命值48");
        inOrder.verify(gamePrinter,times(1)).print("战士加尔鲁斯使用冰刀攻击了刺客瓦莉拉,瓦莉拉受到了25点伤害,刺客瓦莉拉冰冻了,瓦利拉剩余生命值35");
        inOrder.verify(gamePrinter,times(1)).print("刺客瓦莉拉受到2点冰冻伤害,刺客瓦莉拉剩余生命值33");
        inOrder.verify(gamePrinter,times(1)).print("刺客瓦莉拉使用毒短刃攻击了战士加尔鲁斯,加尔鲁斯受到了30点伤害,战士加尔鲁斯中毒了,加尔鲁斯剩余生命值18");
        inOrder.verify(gamePrinter,times(1)).print("战士加尔鲁斯受到2点毒性伤害,战士加尔鲁斯剩余生命值16");
        inOrder.verify(gamePrinter,times(1)).print("战士加尔鲁斯使用冰刀攻击了刺客瓦莉拉,瓦莉拉受到了25点伤害,刺客瓦莉拉冰冻了,瓦利拉剩余生命值8");
        inOrder.verify(gamePrinter,times(1)).print("刺客瓦莉拉受到2点冰冻伤害,无法攻击,瓦莉拉剩余生命值6");
        inOrder.verify(gamePrinter,times(1)).print("战士加尔鲁斯使用冰刀攻击了刺客瓦莉拉,瓦莉拉受到了25点伤害,刺客瓦莉拉冰冻了,瓦莉拉剩余生命值-19");
        inOrder.verify(gamePrinter,times(1)).print("加尔鲁斯 win");

    }
    @Test
    public void gameStateIntegrationTest3() throws Exception{
        Warrior warrior =new Warrior(10,50,"加尔");
        Lancer lancer =new Lancer(10,50,"乌瑟尔");
        Weapon weapon=new Weapon("大剑",10,new FireDebuff(random),1 );
        Weapon poison=new Weapon("毒枪",10,new PoisonDebuff(random),2);
        Armor armor=new Armor("布甲",5);
        warrior.equipWeapon(weapon);
        warrior.equipArmor(armor);
        lancer.equipWeapon(poison);
        GameState gameState=new GameState(warrior,lancer,gamePrinter);
        gameState.game();
        when(random.nextInt(10)).thenReturn(3);
        inOrder.verify(gamePrinter, times(1)).print("骑士乌瑟尔使用毒枪攻击了战士加尔,加尔受到了15点伤害,战士加尔中毒了,加尔剩余生命值35");
        inOrder.verify(gamePrinter, times(1)).print("战士加尔受到2点毒性伤害,战士加尔剩余生命值33");
        inOrder.verify(gamePrinter, times(1)).print("战士加尔使用大剑攻击了骑士乌瑟尔,乌瑟尔受到了20点伤害,乌瑟尔着火了,乌瑟尔剩余生命值30");

    }

}