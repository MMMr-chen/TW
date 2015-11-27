import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by czh on 15-11-27.
 */
public class UserInputCheckTest {
    @Test
    public void UserInputcheckTest_1() throws Exception{
        String inputstr="1224";
        assertThat(UserInputNumCheck.inputcheck(inputstr),is(false));
    }
    @Test
    public void UserInputIsDigtTest_2() throws Exception{
        String inputstr="1234";
        assertThat(UserInputNumCheck.inputcheck(inputstr),is(true));
    }
}
