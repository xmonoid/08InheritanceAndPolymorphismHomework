package com.tsystems.autotestuni.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InhAndPolyBasicTest {

    @Test
    void reverseNumber() {
        assertEquals(0, InhAndPolyBasic.reverse(0));
        assertEquals(1, InhAndPolyBasic.reverse(1_000_000));
        assertEquals(765_432_1, InhAndPolyBasic.reverse(1_234_567));
    }

    @Test
    void reverseChars() {
        char[] chars = {};
        assertArrayEquals(chars, InhAndPolyBasic.reverse(chars));
        chars = new char[] {'a'};
        assertArrayEquals(chars, InhAndPolyBasic.reverse(chars));
        chars = new char[] {'a', 'b', 'z'};
        assertArrayEquals(new char[] {'z', 'b', 'a'}, InhAndPolyBasic.reverse(chars));
    }
}