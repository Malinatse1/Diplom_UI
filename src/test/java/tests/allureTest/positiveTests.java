package tests.allureTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class positiveTests {
    @Test
    void test1() {
        assertTrue(true);
    }

    @Test
    @Tag("smoke")
    void test2() {
        assertTrue(true);
    }

    @Test
    void test3() {
        assertTrue(true);
    }

    @Test
    void test4() {
        assertTrue(true);
    }

    @Test
    void test5() {
        assertTrue(true);
    }

    @Test
    void test6() {
        assertTrue(true);
    }

    @Test
    void test7() {
        assertTrue(true);
    }

    @Test
    void test8() {
        assertTrue(true);
    }

    @Test
    void test9() {
        assertTrue(true);
    }

    @Test
    void test10() {
        assertTrue(true);
    }

}