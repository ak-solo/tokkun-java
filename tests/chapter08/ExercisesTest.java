package chapter08;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {

    // ===== 問題 8-1: Cat クラス =====

    @Test
    void test_8_1_CatInheritsNameFromAnimal() {
        Cat cat = new Cat("タマ", 2);
        assertEquals("タマ", cat.getName());
    }

    @Test
    void test_8_1_CatInheritsAgeFromAnimal() {
        Cat cat = new Cat("タマ", 2);
        assertEquals(2, cat.getAge());
    }

    @Test
    void test_8_1_CatShowProfile() {
        Cat cat = new Cat("タマ", 2);
        assertEquals("タマ,2歳", cat.showProfile());
    }

    @Test
    void test_8_1_CatSleep() {
        Cat cat = new Cat("タマ", 2);
        assertEquals("スースー", cat.sleep());
    }

    // ===== 問題 8-2: Dog クラス =====

    @Test
    void test_8_2_DogInheritsNameFromAnimal() {
        Dog dog = new Dog("ポチ", 3);
        assertEquals("ポチ", dog.getName());
    }

    @Test
    void test_8_2_DogInheritsAgeFromAnimal() {
        Dog dog = new Dog("ポチ", 3);
        assertEquals(3, dog.getAge());
    }

    @Test
    void test_8_2_DogShowProfile() {
        Dog dog = new Dog("ポチ", 3);
        assertEquals("ポチ,3歳", dog.showProfile());
    }

    @Test
    void test_8_2_DogRun() {
        Dog dog = new Dog("ポチ", 3);
        assertEquals("トコトコ", dog.run());
    }

    // ===== 問題 8-3: Cat.speak オーバーライド =====

    @Test
    void test_8_3_CatSpeak() {
        Cat cat = new Cat("タマ", 2);
        assertEquals("ニャー", cat.speak());
    }

    @Test
    void test_8_3_CatSpeakDifferentFromAnimalDefault() {
        Cat cat = new Cat("ミケ", 5);
        assertNotEquals("......", cat.speak());
    }

    // ===== 問題 8-4: Dog.speak オーバーライド =====

    @Test
    void test_8_4_DogSpeak() {
        Dog dog = new Dog("ポチ", 3);
        assertEquals("ワンワン", dog.speak());
    }

    @Test
    void test_8_4_DogSpeakDifferentFromAnimalDefault() {
        Dog dog = new Dog("コロ", 1);
        assertNotEquals("......", dog.speak());
    }

    // ===== 問題 8-5: ポリモーフィズム =====

    @Test
    void test_8_5_AnimalArrayHoldsCatAndDog() {
        Animal[] animals = {
            new Cat("タマ", 2),
            new Dog("ポチ", 3),
            new Cat("ミケ", 1),
            new Dog("コロ", 5)
        };
        assertEquals(4, animals.length);
        assertInstanceOf(Cat.class, animals[0]);
        assertInstanceOf(Dog.class, animals[1]);
        assertInstanceOf(Cat.class, animals[2]);
        assertInstanceOf(Dog.class, animals[3]);
    }

    @Test
    void test_8_5_PolymorphicSpeakCallsCorrectOverride() {
        Animal[] animals = {
            new Cat("タマ", 2),
            new Dog("ポチ", 3),
            new Cat("ミケ", 1),
            new Dog("コロ", 5)
        };
        assertEquals("ニャー", animals[0].speak());
        assertEquals("ワンワン", animals[1].speak());
        assertEquals("ニャー", animals[2].speak());
        assertEquals("ワンワン", animals[3].speak());
    }

    @Test
    void test_8_5_PolymorphicShowProfileUsesActualNameAndAge() {
        Animal[] animals = {
            new Cat("タマ", 2),
            new Dog("ポチ", 3)
        };
        assertEquals("タマ,2歳", animals[0].showProfile());
        assertEquals("ポチ,3歳", animals[1].showProfile());
    }

    // ===== problem8_1 =====

    @ParameterizedTest
    @CsvSource({"'タマ', 2, 'タマ,2歳,スースー'", "'ミケ', 5, 'ミケ,5歳,スースー'"})
    void test_8_1_Problem(String name, int age, String expected) {
        assertEquals(expected, Exercises.problem8_1(name, age));
    }

    // ===== problem8_2 =====

    @ParameterizedTest
    @CsvSource({"'ポチ', 3, 'ポチ,3歳,トコトコ'", "'コロ', 1, 'コロ,1歳,トコトコ'"})
    void test_8_2_Problem(String name, int age, String expected) {
        assertEquals(expected, Exercises.problem8_2(name, age));
    }

    // ===== problem8_3 =====

    @Test
    void test_8_3_Problem_CatSpeaksThroughAnimalRef() {
        assertEquals("ニャー", Exercises.problem8_3());
    }

    // ===== problem8_4 =====

    @Test
    void test_8_4_Problem_DogSpeaksThroughAnimalRef() {
        assertEquals("ワンワン", Exercises.problem8_4());
    }

    // ===== problem8_5 =====

    @Test
    void test_8_5_Problem_PolymorphicSpeak() {
        assertEquals("ニャー,ワンワン,ニャー,ワンワン", Exercises.problem8_5());
    }
}
