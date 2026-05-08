# 4章 繰り返し

## 基礎知識

### for ループ

回数が決まっているときは `for` ループを使います。

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);  // 1, 2, 3, 4, 5
}

// Step を変えたい場合（3 刻み）
for (int i = 0; i <= 8; i += 3) {
    System.out.println(i);  // 0, 3, 6
}
```

---

### while ループ

条件が真の間くり返すときは `while` を使います。

```java
int n = 1;
while (n <= 5) {
    System.out.println(n);
    n++;
}
```

---

### do/while ループ

`do` ループは最低 1 回は実行されます（ループ末尾で条件を評価）。

```java
int n = 0;
do {
    n++;
    System.out.println(n);
} while (n < 5);
```

---

### break / continue

`break` でループを途中で抜け、`continue` で次の反復にスキップできます。

```java
for (int i = 1; i <= 10; i++) {
    if (i == 6) break;          // 6 に達したら終了
    if (i % 2 == 0) continue;  // 偶数はスキップ
    System.out.println(i);      // 1, 3, 5
}
```

---

### 改行を含む文字列

複数行の文字列を返すときは `System.lineSeparator()` で改行を挟みます。

```java
List<String> lines = new ArrayList<>();
lines.add("1行目");
lines.add("2行目");
lines.add("3行目");
String result = String.join(System.lineSeparator(), lines);
System.out.println(result);
// 出力:
// 1行目
// 2行目
// 3行目
```

---

### カンマ区切りの文字列を作る

`ArrayList` と `String.join` を組み合わせると便利です。

```java
import java.util.ArrayList;
import java.util.List;

List<String> parts = new ArrayList<>();
for (int i = 1; i <= 5; i++) {
    parts.add(String.valueOf(i));  // int を String に変換して追加
}
String result = String.join(",", parts);  // "1,2,3,4,5"
```

または StringBuilder を使う方法もあります。

```java
StringBuilder sb = new StringBuilder();
for (int i = 3; i <= 27; i += 3) {
    if (sb.length() > 0) sb.append(",");
    sb.append(i);
}
String result = sb.toString();  // "3,6,9,...,27"
```

---

## 練習問題

### 問題 4-1

`"SPAM"` という文字列を 10 個カンマ区切りで並べた文字列を返すメソッドを実装しなさい。

例: `"SPAM,SPAM,SPAM,SPAM,SPAM,SPAM,SPAM,SPAM,SPAM,SPAM"`

---

### 問題 4-2

九九の三の段（3, 6, 9, … 27）をカンマ区切りの文字列で返すメソッドを実装しなさい。

例: `"3,6,9,12,15,18,21,24,27"`

---

### 問題 4-3

2 の 1 乗から 8 乗までをカンマ区切りの文字列で返すメソッドを実装しなさい。

例: `"2,4,8,16,32,64,128,256"`

---

### 問題 4-4

7 の階乗（7!）を返すメソッドを実装しなさい。

例: `7! = 1 × 2 × 3 × 4 × 5 × 6 × 7 = 5040`

---

### 問題 4-5

`int` 型の引数 `n` を受け取り、`"*"` を `n` 個並べた文字列を返すメソッドを実装しなさい。

例: `n = 5` のとき `"*****"`、`n = 0` のとき `""`

---

### 問題 4-6

`int` 型の引数 `n` を受け取り、`0〜9` を繰り返す `n` 文字の文字列を返すメソッドを実装しなさい。

例: `n = 14` のとき `"01234567890123"`

---

### 問題 4-7

`int` 型の引数 `n` を受け取り、`n` を**素因数分解**した結果をカンマ区切りの文字列で返すメソッドを実装しなさい。

例:
- `n = 12` → `"2,2,3"`
- `n = 20100` → `"2,2,3,5,5,67"`
- `n = 7` → `"7"`

**ヒント:** 2 から順に割り切れるか試して、割り切れたらその数を記録し、`n` を割り続けます。

---

### 問題 4-8

`int` 型の引数 `n` を受け取り、`n` が**素数**なら `true`、そうでなければ `false` を返すメソッドを実装しなさい。

素数の条件: 1 より大きく、1 と自分自身以外で割り切れない整数。

---

### 問題 4-9

`int` 型の引数 `size` を受け取り、`"$"` で作った**直角三角形**を `System.lineSeparator()` 区切りの文字列で返すメソッドを実装しなさい。

例: `size = 3` のとき
```
$
$$
$$$
```

---

### 問題 4-10

`int` 型の引数 `size` を受け取り、`"X"` で作った **× 印**を `System.lineSeparator()` 区切りの文字列で返すメソッドを実装しなさい。

例: `size = 5` のとき
```
X   X
 X X
  X
 X X
X   X
```

---

### 問題 4-11

フィボナッチ数列の **1000 以下の項**をカンマ区切りの文字列で返すメソッドを実装しなさい。先頭は `0, 1` とする。

期待する出力: `"0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987"`
