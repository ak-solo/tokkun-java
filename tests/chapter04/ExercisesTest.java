package chapter04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {

    // --- 問題 4-1 ---
    @Test
    void test_4_1_Spam() {
        assertEquals("SPAM,SPAM,SPAM,SPAM,SPAM,SPAM,SPAM,SPAM,SPAM,SPAM", Exercises.problem4_1());
    }

    // --- 問題 4-2 ---
    @Test
    void test_4_2_MultiplesOf3() {
        assertEquals("3,6,9,12,15,18,21,24,27", Exercises.problem4_2());
    }

    // --- 問題 4-3 ---
    @Test
    void test_4_3_PowersOf2() {
        assertEquals("2,4,8,16,32,64,128,256", Exercises.problem4_3());
    }

    // --- 問題 4-4 ---
    @Test
    void test_4_4_Factorial7() {
        assertEquals(5040, Exercises.problem4_4());
    }

    // --- 問題 4-5 ---
    @ParameterizedTest
    @CsvSource({"0, ''", "3, '***'", "5, '*****'"})
    void test_4_5_Asterisks(int n, String expected) {
        assertEquals(expected, Exercises.problem4_5(n));
    }

    // --- 問題 4-6 ---
    @ParameterizedTest
    @CsvSource({"0, ''", "5, '01234'", "14, '01234567890123'"})
    void test_4_6_CyclingDigits(int n, String expected) {
        assertEquals(expected, Exercises.problem4_6(n));
    }

    // --- 問題 4-7 ---
    @Test
    void test_4_7_PrimeFactors() {
        assertEquals("2,2,3", Exercises.problem4_7(12));
        assertEquals("2,2,3,5,5,67", Exercises.problem4_7(20100));
        assertEquals("7", Exercises.problem4_7(7));
        assertEquals("2", Exercises.problem4_7(2));
    }

    // --- 問題 4-8 ---
    @ParameterizedTest
    @CsvSource({"1, false", "2, true", "7, true", "13, true", "4, false", "9, false", "100, false", "97, true"})
    void test_4_8_IsPrime(int n, boolean expected) {
        assertEquals(expected, Exercises.problem4_8(n));
    }

    // --- 問題 4-9 ---
    @Test
    void test_4_9_Triangle() {
        assertEquals("$", Exercises.problem4_9(1));
        assertEquals("$" + System.lineSeparator() + "$$" + System.lineSeparator() + "$$$",
            Exercises.problem4_9(3));
        assertEquals("$" + System.lineSeparator() + "$$" + System.lineSeparator() + "$$$"
            + System.lineSeparator() + "$$$$", Exercises.problem4_9(4));
    }

    // --- 問題 4-10 ---
    @Test
    void test_4_10_XPattern() {
        assertEquals(String.join(System.lineSeparator(), "X X", " X ", "X X"),
            Exercises.problem4_10(3));
        assertEquals(String.join(System.lineSeparator(), "X  X", " XX ", " XX ", "X  X"),
            Exercises.problem4_10(4));
        assertEquals(String.join(System.lineSeparator(), "X   X", " X X ", "  X  ", " X X ", "X   X"),
            Exercises.problem4_10(5));
    }

    // --- 問題 4-11 ---
    @Test
    void test_4_11_Fibonacci() {
        assertEquals("0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987",
            Exercises.problem4_11());
    }
}
