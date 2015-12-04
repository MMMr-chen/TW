import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by czh on 15-11-28.
 */
public class PlayerTest {
    private Player attacker;
    private Player victim;
    @Before
    public void setUp(){
        attacker =new Player(20,200,"attacker");
        victim =new Player(10,200,"test");
    }
    @Test
    public void playerCreateSuccessful(){
        assertThat(attacker.getDamage(),is(20));
        assertThat(attacker.getHealth(),is(200));
        assertThat(attacker.getName(),is("attacker"));
        assertThat(victim.getDamage(),is(10));
    }
    @Test
    public void playerBeAttackedActionTest(){
        victim.attackedAction(attacker);
        assertThat(victim.getHealth(),is(180));
    }
    @Test
    public void playerIsOrNotAlive(){
        Player deadtest=new Player(10,-2,"test");
        assertThat(attacker.isAlive(),is(true));
        assertThat(deadtest.isAlive(),is(false));
    }

}