---
paths:
  - "tests/**"
---

# ユニットテスト（tests/）

## テストフレームワーク

JUnit 5 を使用する。build.gradle の依存関係：

```groovy
testImplementation 'org.junit.jupiter:junit-jupiter:5.10.2'
testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
```

## ファイル構成

```java
// tests/chapter01/ExercisesTest.java

package chapter01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {

    // 命名規則: test_[問題番号]_[何をテストするか]
    @Test
    void test_1_4_SumOf13And17() {
        assertEquals(30, Exercises.problem1_4());
    }

    // @ParameterizedTest + @CsvSource でパターンを網羅する
    @ParameterizedTest
    @CsvSource({"3, '6,9,12'", "5, '10,15,20'"})
    void test_1_9_Multiples(int x, String expected) {
        assertEquals(expected, Exercises.problem1_9(x));
    }
}
```

## 配列パラメータのテスト

配列を引数に取るテストは `@MethodSource` を使う。

```java
static Stream<Arguments> problem5_1Data() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 3}, new int[]{2, 4, 6})
    );
}

@ParameterizedTest
@MethodSource("problem5_1Data")
void test_5_1_Double(int[] numbers, int[] expected) {
    assertArrayEquals(expected, Exercises.problem5_1(numbers));
}
```

## テスト作成ルール

- `assertTrue(true)` のような無意味なアサーションは書かない
- **`@ParameterizedTest`** を活用し、境界値・典型値・エッジケースを複数検証する
- テスト名は「何の問題の、何を確認するか」が一目でわかるように書く
- テストコードは初学者が変更しない前提で書く（骨格側のメソッドシグネチャに合わせる）

## 初学者が行う作業

- `src/chapterXX/Exercises.java` の `throw new UnsupportedOperationException()` を削除し、実装を書く
- `gradle test --tests "chapterXX.*"` を実行して結果を確認する
- 全テストが緑になれば完了
