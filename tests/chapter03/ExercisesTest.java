package chapter03;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {

    // --- 問題 3-1 ---
    @ParameterizedTest
    @CsvSource({
            "10, 5, 'xはyより大きい。'",
            "5, 10, ''",
            "5, 5, ''"
    })
    void test_3_1_GreaterThan(int x, int y, String expected) {
        assertEquals(expected, Exercises.problem3_1(x, y));
    }

    // --- 問題 3-2 ---
    @ParameterizedTest
    @CsvSource({
            "10, 5, 'xはyより大きい'",
            "5, 10, 'xはyより小さい'",
            "5, 5, ''"
    })
    void test_3_2_Compare(int x, int y, String expected) {
        assertEquals(expected, Exercises.problem3_2(x, y));
    }

    // --- 問題 3-3 ---
    @ParameterizedTest
    @CsvSource({ "10, 5, 10", "5, 10, 10", "7, 7, 7", "-3, -1, -1" })
    void test_3_3_Max(int x, int y, int expected) {
        assertEquals(expected, Exercises.problem3_3(x, y));
    }

    // --- 問題 3-4 ---
    @ParameterizedTest
    @CsvSource({
            "10, 5, 'xはyより大きい'",
            "5, 10, 'xはyより小さい'",
            "5, 5, 'xとyは等しい'"
    })
    void test_3_4_ThreeWayCompare(int x, int y, String expected) {
        assertEquals(expected, Exercises.problem3_4(x, y));
    }

    // --- 問題 3-5 ---
    @ParameterizedTest
    @CsvSource({ "4, '偶数'", "3, '奇数'", "0, '偶数'", "-4, '偶数'", "-3, '奇数'" })
    void test_3_5_EvenOdd(int x, String expected) {
        assertEquals(expected, Exercises.problem3_5(x));
    }

    // --- 問題 3-6 ---
    @ParameterizedTest
    @CsvSource({
            "4, '正の偶数'",
            "3, '正の奇数'",
            "0, '正の偶数'",
            "-4, '負の偶数'",
            "-3, '負の奇数'"
    })
    void test_3_6_Classify(int x, String expected) {
        assertEquals(expected, Exercises.problem3_6(x));
    }

    // --- 問題 3-7 ケース1 ---
    @ParameterizedTest
    @CsvSource({ "100, '合格'", "60, '合格'", "59, '不合格'", "0, '不合格'" })
    void test_3_7_Case1(int score, String expected) {
        assertEquals(expected, Exercises.problem3_7_Case1(score));
    }

    // --- 問題 3-7 ケース2 ---
    @ParameterizedTest
    @CsvSource({
            "100, 'たいへんよくできました。'",
            "80, 'たいへんよくできました。'",
            "79, 'よくできました。'",
            "60, 'よくできました。'",
            "59, 'ざんねんでした。'",
            "0, 'ざんねんでした。'"
    })
    void test_3_7_Case2(int score, String expected) {
        assertEquals(expected, Exercises.problem3_7_Case2(score));
    }

    // --- 問題 3-7 ケース3 ---
    @ParameterizedTest
    @CsvSource({
            "100, '優'", "80, '優'", "79, '良'", "70, '良'",
            "69, '可'", "60, '可'", "59, '不可'", "0, '不可'"
    })
    void test_3_7_Case3(int score, String expected) {
        assertEquals(expected, Exercises.problem3_7_Case3(score));
    }

    // --- 問題 3-8 ---
    @ParameterizedTest
    @CsvSource({
            "70, 70, '合格'",
            "60, 60, '合格'",
            "50, 90, '合格'",
            "100, 30, '合格'",
            "10, 95, '合格'",
            "95, 10, '合格'",
            "90, 10, '合格'",
            "0, 90, '不合格'",
            "50, 55, '不合格'",
            "30, 50, '不合格'"
    })
    void test_3_8_PassFail(int midterm, int finalScore, String expected) {
        assertEquals(expected, Exercises.problem3_8(midterm, finalScore));
    }

    // --- 問題 3-9 ---
    @ParameterizedTest
    @CsvSource({
            "0, 0, '休診'",
            "1, 0, '○'",
            "2, 0, '休診'",
            "2, 1, '○'",
            "3, 2, '休診'",
            "5, 0, '休診'",
            "5, 1, '○'",
            "6, 0, '○'",
            "6, 1, '休診'"
    })
    void test_3_9_Hospital(int dayOfWeek, int timeOfDay, String expected) {
        assertEquals(expected, Exercises.problem3_9(dayOfWeek, timeOfDay));
    }

    // --- 問題 3-10 条件1 ---
    @ParameterizedTest
    @CsvSource({ "2, 4, true", "4, 2, false", "2, 3, false", "1, 3, false" })
    void test_3_10_Cond1(int x, int y, boolean expected) {
        assertEquals(expected, Exercises.problem3_10_Cond1(x, y));
    }

    // --- 問題 3-10 条件2 ---
    @ParameterizedTest
    @CsvSource({ "-3, -3, true", "-3, -4, false", "3, 3, false" })
    void test_3_10_Cond2(int x, int y, boolean expected) {
        assertEquals(expected, Exercises.problem3_10_Cond2(x, y));
    }

    // --- 問題 3-10 条件3 ---
    @ParameterizedTest
    @CsvSource({ "2, 5, true", "4, 2, true", "1, 5, true", "3, 1, false" })
    void test_3_10_Cond3(int x, int y, boolean expected) {
        assertEquals(expected, Exercises.problem3_10_Cond3(x, y));
    }

    // --- 問題 3-10 条件4 ---
    @ParameterizedTest
    @CsvSource({
            "5, 50, true",
            "100, 50, true",
            "50, 50, false",
            "5, 5, false",
            "5, 101, false"
    })
    void test_3_10_Cond4(int x, int y, boolean expected) {
        assertEquals(expected, Exercises.problem3_10_Cond4(x, y));
    }

    // --- 問題 3-10 条件5 ---
    @ParameterizedTest
    @CsvSource({ "1, 1, true", "-1, 1, true", "-1, -1, false", "0, -1, true" })
    void test_3_10_Cond5(int x, int y, boolean expected) {
        assertEquals(expected, Exercises.problem3_10_Cond5(x, y));
    }

    // --- 問題 3-11 ---
    @ParameterizedTest
    @CsvSource({
            "1, '大吉！今日は積極的に行動しよう。'",
            "2, '中吉。慎重に進めば良い結果が待っている。'",
            "3, '吉。こつこつ続けることで道が開ける。'",
            "4, '小吉。意外なところからチャンスがやってくる。'",
            "5, '末吉。今日はゆったり過ごすと吉。'",
            "0, '選択肢は 1〜5 の数字で入力してください。'",
            "9, '選択肢は 1〜5 の数字で入力してください。'"
    })
    void test_3_11_SushiFortune(int choice, String expected) {
        assertEquals(expected, Exercises.problem3_11(choice));
    }

    // --- 問題 3-12 ---
    @ParameterizedTest
    @CsvSource({
            "1, '1月は大の月です'",
            "3, '3月は大の月です'",
            "12, '12月は大の月です'",
            "2, '2月は小の月です'",
            "4, '4月は小の月です'",
            "11, '11月は小の月です'",
            "0, 'そんな月はありません'",
            "13, 'そんな月はありません'"
    })
    void test_3_12_MonthSize(int month, String expected) {
        assertEquals(expected, Exercises.problem3_12(month));
    }
}
