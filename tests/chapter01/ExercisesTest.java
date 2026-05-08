package chapter01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {

    // --- 問題 1-1 ---
    @Test
    void test_1_1_HelloWorld() {
        assertEquals("Hello World", Exercises.problem1_1());
    }

    // --- 問題 1-2 ---
    @Test
    void test_1_2_VariableDisplay() {
        assertEquals("x=11", Exercises.problem1_2());
    }

    // --- 問題 1-3 ---
    @Test
    void test_1_3_TwoVariables() {
        assertEquals("x=13,y=17", Exercises.problem1_3());
    }

    // --- 問題 1-4 ---
    @Test
    void test_1_4_SumOf13And17() {
        assertEquals(30, Exercises.problem1_4());
    }

    // --- 問題 1-5 ---
    @Test
    void test_1_5_ProductOf13And17() {
        assertEquals(221, Exercises.problem1_5());
    }

    // --- 問題 1-6 ---
    @Test
    void test_1_6_TripleThenHalf() {
        assertEquals("21,10", Exercises.problem1_6());
    }

    // --- 問題 1-7 ---
    @Test
    void test_1_7_SwapVariables() {
        assertEquals("x=7,y=3", Exercises.problem1_7());
    }

    // --- 問題 1-8 ---
    @Test
    void test_1_8_ProductOf19And23() {
        assertEquals(437, Exercises.problem1_8());
    }

    // --- 問題 1-9 ---
    @ParameterizedTest
    @CsvSource({
        "3, '6,9,12'",
        "5, '10,15,20'",
        "1, '2,3,4'",
        "10, '20,30,40'"
    })
    void test_1_9_MultipleOfX(int x, String expected) {
        assertEquals(expected, Exercises.problem1_9(x));
    }

    // --- 問題 1-10 ---
    @ParameterizedTest
    @CsvSource({
        "2, '2,4,8'",
        "3, '3,9,27'",
        "5, '5,25,125'",
        "1, '1,1,1'"
    })
    void test_1_10_PowersOfX(int x, String expected) {
        assertEquals(expected, Exercises.problem1_10(x));
    }

    // --- 問題 1-11 ---
    @Test
    void test_1_11_DivisionReturnsDouble() {
        double result = Exercises.problem1_11();
        assertEquals(10.0 / 3.0, result, 1e-10);
    }

    // --- 問題 1-12 ---
    @Test
    void test_1_12_IntegerDivision() {
        assertEquals(3, Exercises.problem1_12());
    }

    // --- 問題 1-13 ---
    @ParameterizedTest
    @CsvSource({
        "10, 3, '3,1'",
        "17, 5, '3,2'",
        "20, 4, '5,0'",
        "7, 2, '3,1'"
    })
    void test_1_13_QuotientAndRemainder(int x, int y, String expected) {
        assertEquals(expected, Exercises.problem1_13(x, y));
    }
}
