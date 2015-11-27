import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by czh on 15-11-27.
 */
public class GameStateTest {
    @Test
    public void  gamestateTest_1(){
        int preCount=6;
        String resStr="4A0B";
        String result=GameState.getGameState().judgeState(preCount,resStr);
        assertThat(result,is("Win"));

    }
    @Test
    public void  gamestateTest_2(){
        int preCount=5;
        String resStr="2A2B";
        String result=GameState.getGameState().judgeState(preCount,resStr);
        assertThat(result,is("4"));

    }
    @Test
    public void  gamestateTest_3(){
        int preCount=1;
        String resStr="4A0B";
        String result=GameState.getGameState().judgeState(preCount,resStr);
        assertThat(result,is("Win"));

    }
    @Test
    public void  gamestateTest_4(){
        int preCount=1;
        String resStr="2A2B";
        String result=GameState.getGameState().judgeState(preCount,resStr);
        assertThat(result,is("Lose"));

    }
}
