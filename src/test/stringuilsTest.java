package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class stringuilsTest {

    @Test
    public void testReverse() {
        StringUtils utils = new StringUtils();
        assertEquals("cba", utils.reverse("abc"));
        assertEquals("", utils.reverse(""));
        assertNull(utils.reverse(null));
    }

    @Test
    public void testIsPalindrome() {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindrome("madam"));
        assertFalse(utils.isPalindrome("hello"));
        assertFalse(utils.isPalindrome(null));
    }

    @Test
    public void testConcatenate() {
        StringUtils utils = new StringUtils();
        assertEquals("hello world", utils.concatenate("hello", " world"));
        assertEquals("foo", utils.concatenate("foo", ""));
        assertEquals("bar", utils.concatenate("", "bar"));
    }
}
