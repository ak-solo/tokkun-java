# 9章 Stream API

## 基礎知識

### ラムダ式

Stream API では **ラムダ式**（`->` を使った記法）で処理を渡します。

```java
// 「n を受け取り、n % 2 == 0 を返す」処理
n -> n % 2 == 0

// 「n を受け取り、n * 2 を返す」処理
n -> n * 2

// 引数が複数のときは丸括弧が必要
(a, b) -> a + b
```

`n -> n % 2 == 0` は「引数 n を受け取り、n % 2 == 0 の結果を返す」という処理のかたまりです。  
メソッドの引数として渡すことで、「どんな条件で絞り込むか」「どう変換するか」を指定できます。

---

### Stream API とは

**Stream API** は、配列やコレクションに対して絞り込み・変換・並び替え・集計などの操作を簡潔に書けるしくみです。

`int[]` 配列には `Arrays.stream(arr)` で `IntStream` を作ります。

```java
import java.util.Arrays;
import java.util.stream.Collectors;

int[] numbers = { 1, 2, 3, 4, 5, 6 };
IntStream stream = Arrays.stream(numbers);
```

---

### filter（絞り込み）

条件に合う要素だけを取り出します。

```java
int[] numbers = { 1, 2, 3, 4, 5, 6 };

int[] evens = Arrays.stream(numbers)
    .filter(n -> n % 2 == 0)
    .toArray();
// → { 2, 4, 6 }
```

---

### map（変換）

各要素を別の値に変換します。

```java
int[] numbers = { 1, 2, 3 };

int[] doubled = Arrays.stream(numbers)
    .map(n -> n * 2)
    .toArray();
// → { 2, 4, 6 }
```

`String[]` に変換したい場合は `mapToObj` を使います。

```java
String[] labels = Arrays.stream(numbers)
    .mapToObj(n -> n + "番")
    .toArray(String[]::new);
// → { "1番", "2番", "3番" }
```

---

### sorted（並び替え）

```java
String[] words = { "banana", "apple", "cherry" };

// アルファベット昇順
String[] asc = Arrays.stream(words)
    .sorted()
    .toArray(String[]::new);

// 文字数の短い順（同じ文字数はアルファベット順）
String[] byLen = Arrays.stream(words)
    .sorted(Comparator.comparingInt(String::length)
            .thenComparing(Comparator.naturalOrder()))
    .toArray(String[]::new);
```

`int[]` を降順に並べるには `boxed()` で `Integer` に変換してから `reversed()` を使います。

```java
int[] desc = Arrays.stream(numbers)
    .boxed()
    .sorted(Comparator.reverseOrder())
    .mapToInt(Integer::intValue)
    .toArray();
```

---

### 集計（sum / average / min / max / count）

```java
int[] scores = { 80, 60, 95, 70, 55 };

int    sum   = Arrays.stream(scores).sum();              // 360
double avg   = Arrays.stream(scores).average().orElse(0); // 72.0
int    min   = Arrays.stream(scores).min().getAsInt();   // 55
int    max   = Arrays.stream(scores).max().getAsInt();   // 95
long   count = Arrays.stream(scores).count();            // 5
```

---

### メソッドチェーン

Stream のメソッドはつなげて書けます。

```java
int[] numbers = { 5, 3, 8, 1, 6, 2, 9, 4 };

// 偶数だけ抽出 → 2乗 → 昇順
int[] result = Arrays.stream(numbers)
    .filter(n -> n % 2 == 0)
    .map(n -> n * n)
    .sorted()
    .toArray();
// → { 4, 16, 36, 64 }
```

---

### anyMatch / allMatch

- `anyMatch(条件)` ― 条件を満たす要素が **1 つでも** あれば `true`
- `allMatch(条件)` ― **すべての** 要素が条件を満たせば `true`

```java
int[] scores = { 80, 60, 95, 70 };

boolean hasHigh = Arrays.stream(scores).anyMatch(s -> s >= 90);  // true
boolean allPass = Arrays.stream(scores).allMatch(s -> s >= 60);  // true
boolean allHigh = Arrays.stream(scores).allMatch(s -> s >= 70);  // false
```

---

### limit（先頭 n 件）

```java
int[] top3 = Arrays.stream(scores)
    .boxed()
    .sorted(Comparator.reverseOrder())
    .limit(3)
    .mapToInt(Integer::intValue)
    .toArray();
```

---

### Collectors.groupingBy（グループ化）

同じキーを持つ要素をまとめます。`String[]` には `Arrays.stream(words)` を使います。

```java
import java.util.Map;
import java.util.stream.Collectors;

String[] words = { "apple", "ant", "banana", "bear", "cat" };

// 先頭文字でグループ化し、件数をカウント
Map<Character, Integer> counts = Arrays.stream(words)
    .collect(Collectors.groupingBy(
        w -> w.charAt(0),
        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
    ));
// → {'a'=2, 'b'=2, 'c'=1}
```

> **ヒント:** `Collectors.counting()` の戻り値は `Long` です。`Integer` に変換するために `collectingAndThen(counting(), Long::intValue)` を使います。

---

## 練習問題

### 問題 9-1

`int` 型配列 `numbers` と整数 `threshold` を受け取り、`threshold` **以上** の要素だけを **昇順** に並べた配列を返すメソッドを実装しなさい。

例: `numbers={5, 1, 8, 3, 9, 2}`, `threshold=4` → `{5, 8, 9}`

**ヒント:** `filter` → `sorted` の順にチェーンします。

---

### 問題 9-2

`int` 型配列 `numbers` を受け取り、各要素を `"{n}番"` という形式の文字列に変換した `String` 配列を返すメソッドを実装しなさい。

例: `numbers={3, 1, 4}` → `{"3番", "1番", "4番"}`

**ヒント:** `mapToObj(n -> n + "番")` を使います。

---

### 問題 9-3

`String` 型配列 `words` を受け取り、文字数の **短い順**（文字数が同じ場合はアルファベット順）に並べた配列を返すメソッドを実装しなさい。

例: `words={"banana", "fig", "apple", "kiwi"}` → `{"fig", "kiwi", "apple", "banana"}`

**ヒント:** `Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())` を使います。

---

### 問題 9-4

`int` 型配列 `scores` を受け取り、その **平均値**（`double`）を返すメソッドを実装しなさい。

例: `scores={80, 60, 95, 70, 55}` → `72.0`

---

### 問題 9-5

`int` 型配列 `numbers` を受け取り、以下の処理をこの順で行った配列を返すメソッドを実装しなさい。

1. 偶数のみ抽出する
2. 各要素を 2 乗する
3. 昇順に並べる

例: `numbers={5, 2, 8, 3, 4, 6}` → `{4, 16, 36, 64}`

**ヒント:** `filter` → `map` → `sorted` の順にチェーンします。

---

### 問題 9-6

`int` 型配列 `scores` と整数 `n` を受け取り、**上位 n 件** のスコアを降順に並べた配列を返すメソッドを実装しなさい。

例: `scores={70, 85, 60, 95, 75}`, `n=3` → `{95, 85, 75}`

**ヒント:** `boxed()` → `sorted(Comparator.reverseOrder())` → `limit(n)` の順にチェーンします。

---

### 問題 9-7

`int` 型配列 `numbers` を受け取り、以下の 3 つを判定するメソッドをそれぞれ実装しなさい。

- `problem9_7_HasNegative` ― 負の数が 1 つでも含まれていれば `true` を返す
- `problem9_7_AllPositive` ― すべての要素が正の数（0 より大きい）であれば `true` を返す
- `problem9_7_CountOver` ― 引数 `threshold` を超える要素の個数を返す

例（HasNegative）: `numbers={3, -1, 5}` → `true`
例（AllPositive）: `numbers={3, 1, 5}` → `true`
例（CountOver）: `numbers={3, 7, 2, 8, 5}`, `threshold=4` → `3`

---

### 問題 9-8

`String` 型配列 `words` と整数 `minLength` を受け取り、文字数が `minLength` 以上の単語を **文字数の降順** に並べた配列を返すメソッドを実装しなさい。

例: `words={"cat", "elephant", "ox", "dog", "hippopotamus"}`, `minLength=4` → `{"hippopotamus", "elephant"}`

---

### 問題 9-9

`String` 型配列 `words` を受け取り、**先頭文字ごとの出現件数** を `Map<Character, Integer>` で返すメソッドを実装しなさい。

例: `words={"apple", "ant", "banana", "bear", "cat"}` → `{'a'=2, 'b'=2, 'c'=1}`

**ヒント:** `Collectors.groupingBy(w -> w.charAt(0), Collectors.collectingAndThen(Collectors.counting(), Long::intValue))` でグループ化します。
