package chapter05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {

    // --- 問題 5-1 ---
    static Stream<Arguments> problem5_1Data() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3}, new int[]{2, 4, 6}),
            Arguments.of(new int[]{5, 10, 15}, new int[]{10, 20, 30}),
            Arguments.of(new int[]{0}, new int[]{0})
        );
    }

    @ParameterizedTest
    @MethodSource("problem5_1Data")
    void test_5_1_Double(int[] numbers, int[] expected) {
        assertArrayEquals(expected, Exercises.problem5_1(numbers));
    }

    // --- 問題 5-2 ---
    static Stream<Arguments> problem5_2Data() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}),
            Arguments.of(new int[]{10, 20}, new int[]{20, 10}),
            Arguments.of(new int[]{7}, new int[]{7})
        );
    }

    @ParameterizedTest
    @MethodSource("problem5_2Data")
    void test_5_2_Reverse(int[] numbers, int[] expected) {
        assertArrayEquals(expected, Exercises.problem5_2(numbers));
    }

    // --- 問題 5-3 ---
    @Test
    void test_5_3_ClassifyEvenOdd() {
        int[] numbers = {42, 7, 54, 35, 71, 13, 21, 45, 32, 8};
        int[][] result = Exercises.problem5_3(numbers);
        assertArrayEquals(new int[]{42, 54, 32, 8}, result[0]);
        assertArrayEquals(new int[]{7, 35, 71, 13, 21, 45}, result[1]);
    }

    @Test
    void test_5_3_AllEvens() {
        int[][] result = Exercises.problem5_3(new int[]{2, 4, 6});
        assertArrayEquals(new int[]{2, 4, 6}, result[0]);
        assertEquals(0, result[1].length);
    }

    @Test
    void test_5_3_AllOdds() {
        int[][] result = Exercises.problem5_3(new int[]{1, 3, 5});
        assertEquals(0, result[0].length);
        assertArrayEquals(new int[]{1, 3, 5}, result[1]);
    }

    // --- 問題 5-4 ---
    @Test
    void test_5_4_StopWhenSumOver100() {
        int[] result = Exercises.problem5_4(new int[]{20, 30, 10, 50, 99});
        assertArrayEquals(new int[]{20, 30, 10, 50}, result);
    }

    @Test
    void test_5_4_StopAt10Items() {
        int[] input = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 99};
        int[] result = Exercises.problem5_4(input);
        assertEquals(10, result.length);
        for (int n : result) assertEquals(5, n);
    }

    @Test
    void test_5_4_StopImmediately() {
        assertArrayEquals(new int[]{200}, Exercises.problem5_4(new int[]{200, 1, 2}));
    }

    // --- 問題 5-5 ---
    @Test
    void test_5_5_BinaryRepresentation() {
        int[] result0 = Exercises.problem5_5(0);
        assertEquals(16, result0.length);
        for (int b : result0) assertEquals(0, b);

        int[] result1 = Exercises.problem5_5(1);
        assertEquals(0, result1[0]);
        assertEquals(1, result1[15]);

        int[] result5 = Exercises.problem5_5(5);
        assertEquals(1, result5[13]);
        assertEquals(0, result5[14]);
        assertEquals(1, result5[15]);
        assertEquals(0, result5[0]);
    }

    @Test
    void test_5_5_AllOnes() {
        int[] result = Exercises.problem5_5(65535);
        for (int b : result) assertEquals(1, b);
    }

    // --- 問題 5-6 ---
    @Test
    void test_5_6_MultiplicationTable() {
        int[][] kuku = Exercises.problem5_6();
        assertEquals(1, kuku[0][0]);
        assertEquals(6, kuku[1][2]);
        assertEquals(9, kuku[2][2]);
        assertEquals(9, kuku[0][8]);
        assertEquals(81, kuku[8][8]);
    }

    // --- 問題 5-7 ---
    @ParameterizedTest
    @MethodSource("problem5_7Data")
    void test_5_7_KukuLookup(int x, int y, int expected) {
        assertEquals(expected, Exercises.problem5_7(x, y));
    }

    static Stream<Arguments> problem5_7Data() {
        return Stream.of(
            Arguments.of(1, 1, 1),
            Arguments.of(3, 4, 12),
            Arguments.of(7, 8, 56),
            Arguments.of(9, 9, 81)
        );
    }

    // --- 問題 5-8 ---
    static Stream<Arguments> problem5_8Data() {
        return Stream.of(
            Arguments.of(new int[]{5, 3, 8, 1}, new int[]{1, 3, 5, 8}),
            Arguments.of(new int[]{-3, 7, -1, 2}, new int[]{-3, -1, 2, 7}),
            Arguments.of(new int[]{1}, new int[]{1}),
            Arguments.of(new int[]{3, 3, 1, 2}, new int[]{1, 2, 3, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("problem5_8Data")
    void test_5_8_Sort(int[] numbers, int[] expected) {
        assertArrayEquals(expected, Exercises.problem5_8(numbers));
    }

    @Test
    void test_5_8_DoesNotMutateInput() {
        int[] original = {5, 3, 8, 1};
        Exercises.problem5_8(original);
        assertArrayEquals(new int[]{5, 3, 8, 1}, original);
    }

    // --- 問題 5-9 ---
    @ParameterizedTest
    @MethodSource("problem5_9Data")
    void test_5_9_Average(int[] numbers, int expected) {
        assertEquals(expected, Exercises.problem5_9(numbers));
    }

    static Stream<Arguments> problem5_9Data() {
        return Stream.of(
            Arguments.of(new int[]{10, 20, 30}, 20),
            Arguments.of(new int[]{1, 2, 3, 4}, 2),
            Arguments.of(new int[]{100}, 100)
        );
    }

    // --- 問題 5-10 ---
    @Test
    void test_5_10_WinsLosses() {
        int[] r1 = Exercises.problem5_10(new int[]{1, 0, 1, 1, 0});
        assertEquals(3, r1[0]);
        assertEquals(2, r1[1]);

        int[] r2 = Exercises.problem5_10(new int[]{0, 0, 0});
        assertEquals(0, r2[0]);
        assertEquals(3, r2[1]);
    }

    // --- 問題 5-11 ---
    @Test
    void test_5_11_TotalScore() {
        assertEquals(9, Exercises.problem5_11_TotalScore(new int[]{1, 2, 0, 3, 0, 1, 0, 2, 0}));
        assertEquals(0, Exercises.problem5_11_TotalScore(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    // --- 問題 5-12 ---
    static Stream<Arguments> problem5_12Data() {
        return Stream.of(
            Arguments.of(new int[]{5, 3, 8, 1}, 8),
            Arguments.of(new int[]{-1, -5, -3}, -1),
            Arguments.of(new int[]{7}, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("problem5_12Data")
    void test_5_12_Max(int[] numbers, int expected) {
        assertEquals(expected, Exercises.problem5_12(numbers));
    }

    // --- 問題 5-13 ---
    @Test
    void test_5_13_MaxMin() {
        int[] r1 = Exercises.problem5_13(new int[]{5, 3, 8, 1, 9});
        assertEquals(9, r1[0]);
        assertEquals(1, r1[1]);

        int[] r2 = Exercises.problem5_13(new int[]{-3, -1, -5});
        assertEquals(-1, r2[0]);
        assertEquals(-5, r2[1]);
    }

    // --- 問題 5-14 ---
    static Stream<Arguments> problem5_14Data() {
        return Stream.of(
            Arguments.of(new int[]{30, 40, 50, 60}, 120),
            Arguments.of(new int[]{101}, 101),
            Arguments.of(new int[]{50, 51}, 101)
        );
    }

    @ParameterizedTest
    @MethodSource("problem5_14Data")
    void test_5_14_SumUntilOver100(int[] numbers, int expected) {
        assertEquals(expected, Exercises.problem5_14(numbers));
    }

    // --- 問題 5-15 ---
    static Stream<Arguments> problem5_15Data() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 1, 1}, "3ストライク,1ボール"),
            Arguments.of(new int[]{2, 2, 2, 2}, "0ストライク,4ボール"),
            Arguments.of(new int[]{1, 2, 1, 2, 2, 2}, "2ストライク,4ボール")
        );
    }

    @ParameterizedTest
    @MethodSource("problem5_15Data")
    void test_5_15_StrikeBall(int[] pitches, String expected) {
        assertEquals(expected, Exercises.problem5_15(pitches));
    }

    // --- 問題 5-16 ---
    static Stream<Arguments> problem5_16Data() {
        return Stream.of(
            Arguments.of(new int[]{3, 3, 1}, "3ストライク,0ボール"),
            Arguments.of(new int[]{1, 1, 3, 1}, "3ストライク,0ボール"),
            Arguments.of(new int[]{3, 3, 3, 2, 2, 2, 2}, "2ストライク,4ボール")
        );
    }

    @ParameterizedTest
    @MethodSource("problem5_16Data")
    void test_5_16_StrikeBallFoul(int[] pitches, String expected) {
        assertEquals(expected, Exercises.problem5_16(pitches));
    }

    // --- 問題 5-17 ---
    static Stream<Arguments> problem5_17Data() {
        return Stream.of(
            Arguments.of(new int[]{5, 10, 3, 0}, 18),
            Arguments.of(new int[]{100, 0}, 100),
            Arguments.of(new int[]{0}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("problem5_17Data")
    void test_5_17_SumUntilZero(int[] numbers, int expected) {
        assertEquals(expected, Exercises.problem5_17(numbers));
    }

    // --- 問題 5-18 ---
    static Stream<Arguments> problem5_18Data() {
        return Stream.of(
            Arguments.of(new int[]{5, 10, 3, 0}, 6),
            Arguments.of(new int[]{3, 4, 0}, 3),
            Arguments.of(new int[]{10, 0}, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("problem5_18Data")
    void test_5_18_AverageUntilZero(int[] numbers, int expected) {
        assertEquals(expected, Exercises.problem5_18(numbers));
    }
}
