import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testIsOffByOne() {
        boolean trueFlag = offByOne.equalChars('a', 'b');
        assertTrue(trueFlag);
        trueFlag = offByOne.equalChars('b', 'a');
        assertTrue(trueFlag);
    }

    @Test
    public void testIsNotOffByOne() {
        boolean falseFlag = offByOne.equalChars('a', 'e');
        assertFalse(falseFlag);
    }

}
