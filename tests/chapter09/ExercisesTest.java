package chapter09;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.Map;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {

    // ===== 問題 9-1: filter + sorted =====

    static Stream<Arguments> problem9_1Data() {
        return Stream.of(
            Arguments.of(new int[]{5, 1, 8, 3, 9, 2}, 4, new int[]{5, 8, 9}),
            Arguments.of(new int[]{10, 2, 5, 7, 1}, 5, new int[]{5, 7, 10}),
            Arguments.of(new int[]{1, 2, 3}, 10, new int[]{}),
            Arguments.of(new int[]{5, 5, 5}, 3, new int[]{5, 5, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("problem9_1Data")
    void test_9_1_FilterAndSort(int[] numbers, int threshold, int[] expected) {
        assertArrayEquals(expected, Exercises.problem9_1(numbers, threshold));
    }

    @Test
    void test_9_1_ThresholdIsInclusive() {
        assertArrayEquals(new int[]{4, 4}, Exercises.problem9_1(new int[]{4, 4}, 4));
    }

    // ===== 問題 9-2: map =====

    static Stream<Arguments> problem9_2Data() {
        return Stream.of(
            Arguments.of(new int[]{3, 1, 4}, new String[]{"3番", "1番", "4番"}),
            Arguments.of(new int[]{10}, new String[]{"10番"}),
            Arguments.of(new int[]{1, 2, 3}, new String[]{"1番", "2番", "3番"})
        );
    }

    @ParameterizedTest
    @MethodSource("problem9_2Data")
    void test_9_2_ToLabel(int[] numbers, String[] expected) {
        assertArrayEquals(expected, Exercises.problem9_2(numbers));
    }

    @Test
    void test_9_2_PreservesOrder() {
        String[] result = Exercises.problem9_2(new int[]{9, 1, 5});
        assertEquals("9番", result[0]);
        assertEquals("1番", result[1]);
        assertEquals("5番", result[2]);
    }

    // ===== 問題 9-3: sorted with Comparator =====

    @Test
    void test_9_3_SortByLengthThenAlphabetical() {
        assertArrayEquals(
            new String[]{"fig", "kiwi", "apple", "banana"},
            Exercises.problem9_3(new String[]{"banana", "fig", "apple", "kiwi"})
        );
    }

    @Test
    void test_9_3_SameLengthSortedAlphabetically() {
        assertArrayEquals(
            new String[]{"ant", "bat", "cat"},
            Exercises.problem9_3(new String[]{"cat", "ant", "bat"})
        );
    }

    @Test
    void test_9_3_SingleElement() {
        assertArrayEquals(new String[]{"hello"}, Exercises.problem9_3(new String[]{"hello"}));
    }

    // ===== 問題 9-4: average =====

    static Stream<Arguments> problem9_4Data() {
        return Stream.of(
            Arguments.of(new int[]{80, 60, 95, 70, 55}, 72.0),
            Arguments.of(new int[]{100, 0}, 50.0),
            Arguments.of(new int[]{75}, 75.0),
            Arguments.of(new int[]{1, 2, 3, 4}, 2.5)
        );
    }

    @ParameterizedTest
    @MethodSource("problem9_4Data")
    void test_9_4_Average(int[] scores, double expected) {
        assertEquals(expected, Exercises.problem9_4(scores));
    }

    // ===== 問題 9-5: filter + map + sorted =====

    @Test
    void test_9_5_EvenSquaredSorted() {
        assertArrayEquals(new int[]{4, 16, 36, 64}, Exercises.problem9_5(new int[]{5, 2, 8, 3, 4, 6}));
    }

    @Test
    void test_9_5_NoEvens() {
        assertEquals(0, Exercises.problem9_5(new int[]{1, 3, 5}).length);
    }

    @Test
    void test_9_5_SingleEven() {
        assertArrayEquals(new int[]{16}, Exercises.problem9_5(new int[]{4}));
    }

    @Test
    void test_9_5_ResultIsAscending() {
        assertArrayEquals(new int[]{4, 16, 36}, Exercises.problem9_5(new int[]{6, 2, 4}));
    }

    // ===== 問題 9-6: sorted descending + limit =====

    static Stream<Arguments> problem9_6Data() {
        return Stream.of(
            Arguments.of(new int[]{70, 85, 60, 95, 75}, 3, new int[]{95, 85, 75}),
            Arguments.of(new int[]{10, 20, 30}, 2, new int[]{30, 20}),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 1, new int[]{5})
        );
    }

    @ParameterizedTest
    @MethodSource("problem9_6Data")
    void test_9_6_TopN(int[] scores, int n, int[] expected) {
        assertArrayEquals(expected, Exercises.problem9_6(scores, n));
    }

    @Test
    void test_9_6_AllElements() {
        assertArrayEquals(new int[]{5, 5, 5}, Exercises.problem9_6(new int[]{5, 5, 5}, 3));
    }

    // ===== 問題 9-7: anyMatch / allMatch / count =====

    static Stream<Arguments> hasNegativeData() {
        return Stream.of(
            Arguments.of(new int[]{3, -1, 5}, true),
            Arguments.of(new int[]{3, 1, 5}, false),
            Arguments.of(new int[]{-1, -2, -3}, true),
            Arguments.of(new int[]{0, 1, 2}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("hasNegativeData")
    void test_9_7_HasNegative(int[] numbers, boolean expected) {
        assertEquals(expected, Exercises.problem9_7_HasNegative(numbers));
    }

    static Stream<Arguments> allPositiveData() {
        return Stream.of(
            Arguments.of(new int[]{3, 1, 5}, true),
            Arguments.of(new int[]{3, 0, 5}, false),
            Arguments.of(new int[]{3, -1, 5}, false),
            Arguments.of(new int[]{1}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("allPositiveData")
    void test_9_7_AllPositive(int[] numbers, boolean expected) {
        assertEquals(expected, Exercises.problem9_7_AllPositive(numbers));
    }

    static Stream<Arguments> countOverData() {
        return Stream.of(
            Arguments.of(new int[]{3, 7, 2, 8, 5}, 4, 3),
            Arguments.of(new int[]{1, 2, 3}, 10, 0),
            Arguments.of(new int[]{5, 5, 5}, 4, 3),
            Arguments.of(new int[]{5, 5, 5}, 5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("countOverData")
    void test_9_7_CountOver(int[] numbers, int threshold, int expected) {
        assertEquals(expected, Exercises.problem9_7_CountOver(numbers, threshold));
    }

    // ===== 問題 9-8: filter + sorted descending =====

    @Test
    void test_9_8_FilterByLengthDescending() {
        String[] words = {"cat", "elephant", "ox", "dog", "hippopotamus"};
        assertArrayEquals(new String[]{"hippopotamus", "elephant"}, Exercises.problem9_8(words, 4));
    }

    @Test
    void test_9_8_MultipleSameLengthDescending() {
        String[] result = Exercises.problem9_8(new String[]{"hi", "hello", "hey"}, 3);
        assertArrayEquals(new String[]{"hello", "hey"}, result);
    }

    @Test
    void test_9_8_NoneMatch() {
        assertEquals(0, Exercises.problem9_8(new String[]{"a", "bb", "ccc"}, 5).length);
    }

    // ===== 問題 9-9: Collectors.groupingBy =====

    @Test
    void test_9_9_GroupByFirstChar() {
        String[] words = {"apple", "ant", "banana", "bear", "cat"};
        Map<Character, Integer> result = Exercises.problem9_9(words);
        assertEquals(3, result.size());
        assertEquals(2, result.get('a'));
        assertEquals(2, result.get('b'));
        assertEquals(1, result.get('c'));
    }

    @Test
    void test_9_9_AllSameFirstChar() {
        Map<Character, Integer> result = Exercises.problem9_9(new String[]{"alpha", "arrow", "ant"});
        assertEquals(1, result.size());
        assertEquals(3, result.get('a'));
    }

    @Test
    void test_9_9_AllDifferentFirstChar() {
        Map<Character, Integer> result = Exercises.problem9_9(new String[]{"zoo", "yak", "xray"});
        assertEquals(3, result.size());
        assertEquals(1, result.get('z'));
        assertEquals(1, result.get('y'));
        assertEquals(1, result.get('x'));
    }
}
