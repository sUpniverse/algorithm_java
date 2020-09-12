import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCompressionTest {

    @Test
    public void compressionTest() {

        assertEquals(1, StringCompression.solution("a"));
        assertEquals(2, StringCompression.solution("aaaaa"));
        assertEquals(3, StringCompression.solution("aaaaaaaaaa"));
        assertEquals(7, StringCompression.solution("aabbaccc"));
        assertEquals(9, StringCompression.solution("ababcdcdababcdcd"));
        assertEquals(8, StringCompression.solution("abcabcdede"));
        assertEquals(14, StringCompression.solution("abcabcabcabcdededededede"));
        assertEquals(17, StringCompression.solution("xababcdcdababcdcd"));
    }

}