import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HorribleSteve {
    @Test
    public void something() {
        int i = 500;
        int j = 500;
        boolean res = Flik.isSameNumber(i, j);
        assertEquals(Boolean.TRUE, res);

    }



    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }
}
