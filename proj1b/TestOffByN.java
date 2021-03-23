import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offBy5 = new OffByN(5);
    static CharacterComparator offByOne = new OffByN(1);


    @Test
    public void testOffByN5() {
        assertFalse(offBy5.equalChars('a', 'b'));
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('F', 'A'));
        assertTrue(offBy5.equalChars('e', 'j'));

    }

    @Test
    public void testOffByOne1() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertFalse(offByOne.equalChars('a', 'c'));
        assertTrue(offByOne.equalChars('b', 'a'));
        assertTrue(offByOne.equalChars('w', 'x'));

    }

    // Your tests go here.
}
