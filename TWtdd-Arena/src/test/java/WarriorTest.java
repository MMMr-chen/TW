import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WarriorTest {
    private Random random;
    @Before
    public void setUp(){
        random=mock(Random.class);
    }
    @Test
    public void deBuffLaunchTest() throws Exception{
        Warrior attacker=new Warrior(20,200,"攻击者");
        Warrior victim=new Warrior(10,100,"受伤者");
        Weapon weapon=new Weapon("大剑",20,new FireDebuff(random),1 );
        attacker.equipWeapon(weapon);
        when(random.nextInt(10)).thenReturn(2);
        assertThat(victim.attackedAction(attacker),is("受伤者受到了40点伤害,战士受伤者着火了,受伤者剩余生命值60"));

    }
    @Test(expected = Exception.class)
    public void canEquipWeaponTest() throws Exception{
        Weapon weapon=new Weapon("大剑",20,2);
        Warrior warrior=new Warrior(10,20,"战士");
        warrior.equipWeapon(weapon);


    }

}