
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by czh on 15-11-27.
 */
public class NumberisIllegaltest {
    @Test
    public void numberisIllegaltest() throws Exception{
        boolean isIllegal=NumberisIllegal.isIllegal("1234");
     assertThat(isIllegal,is(true));
    }
}
