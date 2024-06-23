import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        StringBuilder actual = new StringBuilder();
        for (int i = 0; i < "persiflage".length(); i++) {
            actual.append(d.removeFirst());
        }
        assertEquals("persiflage", actual.toString());
    }

    @Test
    public void testIsPalindromeCornerCases(){
        boolean flag = palindrome.isPalindrome("");
        assertTrue(flag);
        flag = palindrome.isPalindrome("a");
        assertTrue(flag);
    }

    @Test
    public void testIsPalindrome(){
        boolean flag = palindrome.isPalindrome("abc");
        assertFalse(flag);
    }

    @Test
    public void testIsOffByOnePalindrome(){
        CharacterComparator cc = new OffByOne();
        boolean flag = palindrome.isPalindrome("baa", cc);
        assertTrue(flag);
    }

    @Test
    public void testIsNotOffByOnePalindrome(){
        CharacterComparator cc = new OffByOne();
        boolean flag = palindrome.isPalindrome("abbb", cc);
        assertFalse(flag);
    }

}
