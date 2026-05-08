package chapter07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {

    // ===== 問題 7-1: getName / setName =====

    @Test
    void test_7_1_NameGetSet() {
        Dog dog = new Dog();
        dog.setName("ポチ");
        assertEquals("ポチ", dog.getName());
    }

    @Test
    void test_7_1_NameCanBeUpdated() {
        Dog dog = new Dog();
        dog.setName("コロ");
        dog.setName("タロ");
        assertEquals("タロ", dog.getName());
    }

    @Test
    void test_7_1_DefaultNameIsEmpty() {
        Dog dog = new Dog();
        assertEquals("", dog.getName());
    }

    // ===== 問題 7-2: getAge / setAge =====

    @Test
    void test_7_2_AgeGetSet() {
        Dog dog = new Dog();
        dog.setAge(3);
        assertEquals(3, dog.getAge());
    }

    @Test
    void test_7_2_DefaultAgeIsZero() {
        Dog dog = new Dog();
        assertEquals(0, dog.getAge());
    }

    // ===== 問題 7-3: インスタンスの独立性 =====

    @Test
    void test_7_3_TwoInstancesAreIndependent() {
        Dog dog1 = new Dog();
        dog1.setName("ポチ");
        dog1.setAge(3);

        Dog dog2 = new Dog();
        dog2.setName("コロ");
        dog2.setAge(5);

        assertEquals("ポチ", dog1.getName());
        assertEquals(3, dog1.getAge());
        assertEquals("コロ", dog2.getName());
        assertEquals(5, dog2.getAge());
    }

    @Test
    void test_7_3_ChangingOneDoesNotAffectOther() {
        Dog dog1 = new Dog();
        dog1.setName("ポチ");
        Dog dog2 = new Dog();
        dog2.setName("コロ");

        dog1.setName("タロ");

        assertEquals("タロ", dog1.getName());
        assertEquals("コロ", dog2.getName());
    }

    // ===== 問題 7-4: コンストラクタ・getBreed・showProfile =====

    @Test
    void test_7_4_BreedSetByConstructor() {
        Dog dog = new Dog("柴犬");
        assertEquals("柴犬", dog.getBreed());
    }

    @Test
    void test_7_4_ShowProfile() {
        Dog dog = new Dog("柴犬");
        dog.setName("ポチ");
        dog.setAge(3);
        assertEquals("柴犬: ポチ (3歳)", dog.showProfile());
    }

    @Test
    void test_7_4_ShowProfileDifferentDog() {
        Dog dog = new Dog("トイプードル");
        dog.setName("モコ");
        dog.setAge(1);
        assertEquals("トイプードル: モコ (1歳)", dog.showProfile());
    }

    @Test
    void test_7_4_MultipleBreeds() {
        Dog dog1 = new Dog("柴犬");
        Dog dog2 = new Dog("ゴールデンレトリバー");
        assertEquals("柴犬", dog1.getBreed());
        assertEquals("ゴールデンレトリバー", dog2.getBreed());
    }

    // ===== 問題 7-5: CoinCase 基本機能 =====

    @Test
    void test_7_5_AddCoinsAndGetCount() {
        CoinCase cc = new CoinCase();
        cc.addCoins(500, 2);
        cc.addCoins(100, 5);
        assertEquals(2, cc.getCount(500));
        assertEquals(5, cc.getCount(100));
    }

    @Test
    void test_7_5_InitialCountIsZero() {
        CoinCase cc = new CoinCase();
        for (int d : new int[]{500, 100, 50, 10, 5, 1}) {
            assertEquals(0, cc.getCount(d));
        }
    }

    @Test
    void test_7_5_AddCoinsAccumulates() {
        CoinCase cc = new CoinCase();
        cc.addCoins(10, 3);
        cc.addCoins(10, 4);
        assertEquals(7, cc.getCount(10));
    }

    @Test
    void test_7_5_InvalidDenominationIsIgnored() {
        CoinCase cc = new CoinCase();
        cc.addCoins(200, 10);
        cc.addCoins(0, 5);
        assertEquals(0, cc.getCount(500));
        assertEquals(0, cc.getCount(100));
    }

    @Test
    void test_7_5_GetAmount_Total() {
        CoinCase cc = new CoinCase();
        cc.addCoins(500, 1);
        cc.addCoins(100, 2);
        cc.addCoins(50, 3);
        cc.addCoins(10, 4);
        cc.addCoins(5, 5);
        cc.addCoins(1, 6);
        assertEquals(921, cc.getAmount());
    }

    @Test
    void test_7_5_GetAmount_EmptyIsZero() {
        CoinCase cc = new CoinCase();
        assertEquals(0, cc.getAmount());
    }

    // ===== 問題 7-6: オーバーロード =====

    @Test
    void test_7_6_GetCountNoArgs_Total() {
        CoinCase cc = new CoinCase();
        cc.addCoins(500, 2);
        cc.addCoins(100, 3);
        cc.addCoins(10, 5);
        assertEquals(10, cc.getCount());
    }

    @Test
    void test_7_6_GetCountNoArgs_EmptyIsZero() {
        CoinCase cc = new CoinCase();
        assertEquals(0, cc.getCount());
    }

    @Test
    void test_7_6_GetAmountByDenomination() {
        CoinCase cc = new CoinCase();
        cc.addCoins(100, 4);
        cc.addCoins(50, 3);
        assertEquals(400, cc.getAmount(100));
        assertEquals(150, cc.getAmount(50));
    }

    @Test
    void test_7_6_GetAmountByDenomination_EmptyIsZero() {
        CoinCase cc = new CoinCase();
        assertEquals(0, cc.getAmount(500));
    }

    // ===== problem7_1 =====

    @ParameterizedTest
    @CsvSource({"'ポチ', 'ポチ'", "'コロ', 'コロ'", "'', ''"})
    void test_7_1_Problem(String name, String expected) {
        assertEquals(expected, Exercises.problem7_1(name));
    }

    // ===== problem7_2 =====

    @ParameterizedTest
    @CsvSource({"'ポチ', 3, 'ポチ,3'", "'コロ', 5, 'コロ,5'"})
    void test_7_2_Problem(String name, int age, String expected) {
        assertEquals(expected, Exercises.problem7_2(name, age));
    }

    // ===== problem7_3 =====

    @Test
    void test_7_3_Problem_IndependentInstances() {
        assertEquals("タロ,コロ", Exercises.problem7_3());
    }

    // ===== problem7_4 =====

    @ParameterizedTest
    @CsvSource({
        "'柴犬', 'ポチ', 3, '柴犬: ポチ (3歳)'",
        "'トイプードル', 'モコ', 1, 'トイプードル: モコ (1歳)'"
    })
    void test_7_4_Problem(String breed, String name, int age, String expected) {
        assertEquals(expected, Exercises.problem7_4(breed, name, age));
    }

    // ===== problem7_5 =====

    @ParameterizedTest
    @CsvSource({"500, 2, 1000", "100, 5, 500", "10, 3, 30"})
    void test_7_5_Problem(int denomination, int count, int expected) {
        assertEquals(expected, Exercises.problem7_5(denomination, count));
    }

    // ===== problem7_6 =====

    @ParameterizedTest
    @CsvSource({"100, 4, '4,400'", "500, 3, '3,1500'"})
    void test_7_6_Problem(int denomination, int count, String expected) {
        assertEquals(expected, Exercises.problem7_6(denomination, count));
    }
}
