import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by czh on 15-11-27.
 */
public class RandomProducerTest {
    @Test
    public void randowproducerTest() throws Exception{
        assertThat(RandomNumProducer.randomproducer(),is("1234"));
    }
    @Test
    public void randomnumLengthTest() throws Exception{
        assertThat(RandomNumProducer.randomproducer().length(),is(4));
    }
    @Test
    public void random_num_unique_Test() throws Exception{
       Set randnumberSet=new HashSet();
        char[] randnum= RandomNumProducer.randomproducer().toCharArray();
        for (int i=0;i<randnum.length;i++){
            randnumberSet.add(randnum[i]);
        }
        assertThat(randnumberSet.size(),is(4));
    }
    @Test
    public void random_num_isdigit() throws Exception{
        boolean isDigit=true;
        String result=RandomNumProducer.randomproducer();
        for (int i=0;i<4;i++){
            if (result.charAt(i)>'9'||result.charAt(i)<'0'){
                isDigit=false;
            }
            assertThat(isDigit,is(true));

        }
    }
}
