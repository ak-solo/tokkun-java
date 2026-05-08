package chapter02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {

    // --- 問題 2-1 ---
    @ParameterizedTest
    @CsvSource({
        "hello, hello",
        "'C#', 'C#'",
        "12345, 12345",
        "'', ''"
    })
    void test_2_1_ReturnInputString(String s, String expected) {
        assertEquals(expected, Exercises.problem2_1(s));
    }

    // --- 問題 2-2 ---
    @ParameterizedTest
    @CsvSource({"0, 0", "42, 42", "-7, -7", "100, 100"})
    void test_2_2_ReturnInputInteger(int x, int expected) {
        assertEquals(expected, Exercises.problem2_2(x));
    }

    // --- 問題 2-3 ---
    @ParameterizedTest
    @CsvSource({
        "2, '2,4,8'",
        "3, '3,9,27'",
        "5, '5,25,125'",
        "1, '1,1,1'"
    })
    void test_2_3_Powers(int x, String expected) {
        assertEquals(expected, Exercises.problem2_3(x));
    }

    // --- 問題 2-4: 和 ---
    @ParameterizedTest
    @CsvSource({"10, 3, 13", "0, 0, 0", "-5, 5, 0", "100, 200, 300"})
    void test_2_4_Sum(int x, int y, int expected) {
        assertEquals(expected, Exercises.problem2_4_Sum(x, y));
    }

    // --- 問題 2-4: 差 ---
    @ParameterizedTest
    @CsvSource({"10, 3, 7", "5, 5, 0", "3, 10, -7", "0, 100, -100"})
    void test_2_4_Difference(int x, int y, int expected) {
        assertEquals(expected, Exercises.problem2_4_Difference(x, y));
    }

    // --- 問題 2-4: 積 ---
    @ParameterizedTest
    @CsvSource({"10, 3, 30", "0, 5, 0", "-4, 3, -12", "7, 7, 49"})
    void test_2_4_Product(int x, int y, int expected) {
        assertEquals(expected, Exercises.problem2_4_Product(x, y));
    }

    // --- 問題 2-4: 除算（double）---
    @ParameterizedTest
    @CsvSource({"10, 3", "7, 2", "1, 4"})
    void test_2_4_Division(int x, int y) {
        double expected = (double) x / y;
        assertEquals(expected, Exercises.problem2_4_Division(x, y), 1e-10);
    }

    // --- 問題 2-4: 商 ---
    @ParameterizedTest
    @CsvSource({"10, 3, 3", "7, 2, 3", "20, 4, 5", "1, 5, 0"})
    void test_2_4_Quotient(int x, int y, int expected) {
        assertEquals(expected, Exercises.problem2_4_Quotient(x, y));
    }

    // --- 問題 2-4: 余り ---
    @ParameterizedTest
    @CsvSource({"10, 3, 1", "7, 2, 1", "20, 4, 0", "1, 5, 1"})
    void test_2_4_Remainder(int x, int y, int expected) {
        assertEquals(expected, Exercises.problem2_4_Remainder(x, y));
    }

    // --- 問題 2-5 ---
    @ParameterizedTest
    @CsvSource({"10, 6, 8", "3, 4, 3", "0, 0, 0", "1, 100, 50"})
    void test_2_5_Average(int a, int b, int expected) {
        assertEquals(expected, Exercises.problem2_5(a, b));
    }

    // --- 問題 2-6 ---
    @ParameterizedTest
    @CsvSource({"1, 365", "20, 7300", "50, 18250", "0, 0"})
    void test_2_6_AgeToDays(int age, int expected) {
        assertEquals(expected, Exercises.problem2_6(age));
    }
}
