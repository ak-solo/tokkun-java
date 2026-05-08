# 6章 メソッド

## 基礎知識

### void と戻り値ありメソッド

Java のメソッドには **戻り値なし** の `void` と **戻り値あり** の型指定があります。

```java
// void: 値を返さない
static void printHello() {
    System.out.println("Hello");
}

// int: 値を返す
static int doubleIt(int n) {
    return n * 2;
}
```

---

### 引数（パラメーター）

メソッドに渡す値を **引数** といいます。型を明示して宣言します。

```java
static int add(int a, int b) {
    return a + b;
}

// 呼び出し
int result = add(3, 5);  // result = 8
```

---

### ヘルパーメソッド

クラス内で共通処理を切り出すときは `private static` メソッドを使います。

```java
private static int square(int n) {
    return n * n;
}

public static int problem6_1(int n) {
    return square(n);
}
```

ヘルパーメソッドを定義することで、同じロジックを複数の問題メソッドから再利用できます。

---

### 戻り値

`return` で値を返します。

```java
static int max(int a, int b) {
    if (a >= b)
        return a;
    else
        return b;
}
```

---

### boolean を返すメソッド

条件を判定して `true` / `false` を返すメソッドは、後から組み合わせて使えます。

```java
static boolean isEven(int n) {
    return n % 2 == 0;
}

if (isEven(42)) {
    System.out.println("偶数");
}
```

---

### 値の入れ替えについて（Java に ref はない）

C# には `ref` キーワード（参照渡し）がありますが、Java にはありません。
2 つの値を交換した結果を呼び出し元に返したいときは、**配列で返す**方法を使います。

```java
// a と b を交換した結果を {b, a} の配列で返す
static int[] swap(int a, int b) {
    return new int[]{b, a};
}

int[] swapped = swap(10, 20);
// swapped[0] = 20, swapped[1] = 10
```

---

### 配列の直接変更

配列は参照渡しになるため、メソッド内で変更すると呼び出し元にも反映されます。

```java
static void sortInPlace(int[] numbers) {
    Arrays.sort(numbers);  // 元の配列を直接変更する
}

int[] arr = { 5, 3, 8, 1 };
sortInPlace(arr);
// arr は { 1, 3, 5, 8 } になっている
```

---

## 練習問題

### 問題 6-1

整数 `n` を受け取り、**2 乗**（`n × n`）を返すメソッドを実装しなさい。

`square` という名前でヘルパーメソッドを定義し、`problem6_1` から呼び出します。

---

### 問題 6-2

2 つの整数 `a`、`b` を受け取り、**平均**（整数除算）を返すメソッドを実装しなさい。

`average` という名前でヘルパーメソッドを定義し、`problem6_2` から呼び出します。

---

### 問題 6-3

2 つの整数 `a`、`b` を受け取り、**大きい方**を返すメソッドを実装しなさい。

`max` という名前でヘルパーメソッドを定義し、`problem6_3` から呼び出します。

---

### 問題 6-4

サイズ `size` を受け取り、`$` で作った **直角三角形** を文字列で返すメソッドを実装しなさい。

- 1 行目: `$`
- 2 行目: `$$`
- n 行目: `$` × n

各行を `System.lineSeparator()` で結合して返します。

例: `size=3` → `"$" + System.lineSeparator() + "$$" + System.lineSeparator() + "$$$"`

**ヒント:** `"$".repeat(n)` で `$` を `n` 個並べた文字列が作れます。`triangle` という名前でヘルパーメソッドを定義し、`problem6_4` から呼び出すと `problem6_5` でも再利用できます。

---

### 問題 6-5

サイズ `size` と文字 `ch`（`char` 型）を受け取り、**任意の文字で三角形** を返すメソッドを実装しなさい。

問題 6-4 の `$` を `ch` に置き換えたものです。

**ヒント:** `String.valueOf(ch).repeat(n)` または `new String(new char[n]).replace('\0', ch)` で `ch` を `n` 個並べた文字列が作れます。

---

### 問題 6-6

1〜9 の整数 `n` を受け取り、**九九の `n` の段** を文字列で返すメソッドを実装しなさい。

- 各行の形式: `"n×1=積"`, `"n×2=積"`, ..., `"n×9=積"`
- 各行を `System.lineSeparator()` で結合して返す

例: `n=3` の 1 行目 → `"3×1=3"`

---

### 問題 6-7

整数 `n` を受け取り、`n` が **素数かどうか** を `boolean` で返すメソッドを実装しなさい。

- 素数: 1 とそれ自身以外に約数を持たない 2 以上の整数
- 1 は素数ではない

**ヒント:** 2 から `√n` までの数で割り切れるか調べれば十分です。`(int) Math.sqrt(n)` で平方根（切り捨て）が求まります。`isPrime` という名前でヘルパーメソッドを定義し、`problem6_7` から呼び出します。

---

### 問題 6-8

2 つの整数 `a`、`b` を受け取り、値を **交換（スワップ）** した結果を `int[]` 配列で返すメソッドを実装しなさい。

- `result[0]` = 元の `b` の値
- `result[1]` = 元の `a` の値

**補足:** Java に `ref` 引数はないため、交換後の値を配列で返す設計にしています。

---

### 問題 6-9

`int` 型配列 `numbers` を受け取り、配列を **昇順に並べ替える（元の配列を直接変更する）** メソッドを実装しなさい。

問題 5-8 は新しい配列を返しましたが、この問題は **元の配列を直接書き換えます**。

**ヒント:** 問題 6-8 で作った `problem6_8`（スワップ）を呼び出して選択ソートを実装できます。または `Arrays.sort(numbers)` を使う方法もあります。
