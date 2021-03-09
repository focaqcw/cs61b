import static org.junit.Assert.*;

import org.junit.Test;

public class TestFlik {

    @Test
    public void TEST1() {
        int i = 500;
        int j = 500;
        boolean res = Flik.isSameNumber(i, j);
//        boolean res = i == j;
        assertEquals(Boolean.TRUE, res);

    }

    @Test
    public void TEST2() {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);

    }


}
