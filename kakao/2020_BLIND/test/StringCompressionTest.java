import org.junit.Test;

import static org.junit.Assert.assertEquals;


class StringCompressionTest {

    @Test
    public void compressionTest() {

        assertEquals(1, StringCompression2.solution("a"));
        assertEquals(2, StringCompression2.solution("aaaaa"));
        assertEquals(3, StringCompression2.solution("aaaaaaaaaa"));
        assertEquals(7, StringCompression2.solution("aabbaccc"));
        assertEquals(9, StringCompression2.solution("ababcdcdababcdcd"));
        assertEquals(8, StringCompression2.solution("abcabcdede"));
        assertEquals(14, StringCompression2.solution("abcabcabcabcdededededede"));
        assertEquals(17, StringCompression2.solution("xababcdcdababcdcd"));
    }

}