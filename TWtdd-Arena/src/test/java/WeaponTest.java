import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WeaponTest {
    private Weapon weapon;
    private Debuff debuff;
    @Before
    public void setUp(){
        weapon=new Weapon("大剑",20);
        debuff=new FireDebuff(new Random());
    }
    @Test
    public void weaponCreateSuccesfulTest() throws Exception{
        assertThat(weapon.getName(),is("大剑"));
        assertThat(weapon.getAttack(),is(20));
    }
    @Test
    public void setDebuffSuccessfulTest() throws  Exception{
        weapon.setDebuff(debuff);
        assertThat(weapon.getDebuff().getType(),is(2));
    }
}
