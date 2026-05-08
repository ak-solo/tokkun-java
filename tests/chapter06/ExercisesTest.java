package chapter06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {

    // --- 問題 6-1: 2 乗 ---
    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "5, 25", "-3, 9", "10, 100"})
    void test_6_1_Square(int n, int expected) {
        assertEquals(expected, Exercises.problem6_1(n));
    }

    // --- 問題 6-2: 平均（整数除算）---
    @ParameterizedTest
    @CsvSource({"3, 5, 4", "0, 10, 5", "7, 7, 7", "1, 2, 1", "-4, 4, 0"})
    void test_6_2_Average(int a, int b, int expected) {
        assertEquals(expected, Exercises.problem6_2(a, b));
    }

    // --- 問題 6-3: 大きい方 ---
    @ParameterizedTest
    @CsvSource({"3, 5, 5", "5, 3, 5", "4, 4, 4", "-1, -5, -1", "0, 100, 100"})
    void test_6_3_Max(int a, int b, int expected) {
        assertEquals(expected, Exercises.problem6_3(a, b));
    }

    // --- 問題 6-4: $ 三角形 ---
    @Test
    void test_6_4_TriangleSize1() {
        assertEquals("$", Exercises.problem6_4(1));
    }

    @Test
    void test_6_4_TriangleSize3() {
        String expected = "$" + System.lineSeparator() + "$$" + System.lineSeparator() + "$$$";
        assertEquals(expected, Exercises.problem6_4(3));
    }

    @Test
    void test_6_4_TriangleSize5_RowCount() {
        String result = Exercises.problem6_4(5);
        String[] lines = result.split(System.lineSeparator(), -1);
        assertEquals(5, lines.length);
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, lines[i].length());
        }
    }

    // --- 問題 6-5: 任意文字の三角形 ---
    @Test
    void test_6_5_TriangleWithHash() {
        String expected = "#" + System.lineSeparator() + "##" + System.lineSeparator() + "###";
        assertEquals(expected, Exercises.problem6_5(3, '#'));
    }

    @Test
    void test_6_5_TriangleWithStar_Size4() {
        String result = Exercises.problem6_5(4, '*');
        String[] lines = result.split(System.lineSeparator(), -1);
        assertEquals(4, lines.length);
        for (int i = 0; i < 4; i++) {
            assertEquals("*".repeat(i + 1), lines[i]);
        }
    }

    @Test
    void test_6_5_TriangleSingleRow() {
        assertEquals("A", Exercises.problem6_5(1, 'A'));
    }

    // --- 問題 6-6: 九九の一段 ---
    @Test
    void test_6_6_KukuRow1() {
        String result = Exercises.problem6_6(1);
        String[] lines = result.split(System.lineSeparator(), -1);
        assertEquals(9, lines.length);
        assertEquals("1×1=1", lines[0]);
        assertEquals("1×9=9", lines[8]);
    }

    @Test
    void test_6_6_KukuRow3() {
        String result = Exercises.problem6_6(3);
        String[] lines = result.split(System.lineSeparator(), -1);
        assertEquals(9, lines.length);
        assertEquals("3×1=3", lines[0]);
        assertEquals("3×5=15", lines[4]);
        assertEquals("3×9=27", lines[8]);
    }

    @Test
    void test_6_6_KukuRow9() {
        String result = Exercises.problem6_6(9);
        String[] lines = result.split(System.lineSeparator(), -1);
        assertEquals("9×1=9", lines[0]);
        assertEquals("9×9=81", lines[8]);
    }

    // --- 問題 6-7: 素数判定 ---
    @ParameterizedTest
    @CsvSource({
        "1, false", "2, true", "3, true", "4, false",
        "17, true", "25, false", "97, true", "100, false"
    })
    void test_6_7_IsPrime(int n, boolean expected) {
        assertEquals(expected, Exercises.problem6_7(n));
    }

    // --- 問題 6-8: スワップ（配列で返す）---
    @Test
    void test_6_8_SwapPositiveNumbers() {
        assertArrayEquals(new int[]{20, 10}, Exercises.problem6_8(10, 20));
    }

    @Test
    void test_6_8_SwapNegativeAndPositive() {
        assertArrayEquals(new int[]{100, -5}, Exercises.problem6_8(-5, 100));
    }

    @Test
    void test_6_8_SwapSameValue() {
        assertArrayEquals(new int[]{7, 7}, Exercises.problem6_8(7, 7));
    }

    // --- 問題 6-9: 配列のインプレースソート ---
    @Test
    void test_6_9_SortBasic() {
        int[] arr = {5, 3, 8, 1, 9, 2};
        Exercises.problem6_9(arr);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8, 9}, arr);
    }

    @Test
    void test_6_9_AlreadySorted() {
        int[] arr = {1, 2, 3};
        Exercises.problem6_9(arr);
        assertArrayEquals(new int[]{1, 2, 3}, arr);
    }

    @Test
    void test_6_9_ReverseOrder() {
        int[] arr = {9, 7, 5, 3, 1};
        Exercises.problem6_9(arr);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr);
    }

    @Test
    void test_6_9_SingleElement() {
        int[] arr = {42};
        Exercises.problem6_9(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void test_6_9_WithDuplicates() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        Exercises.problem6_9(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 5, 6, 9}, arr);
    }
}
