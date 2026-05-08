---
paths:
  - "src/**"
---

# 骨格コード（src/）

## ファイルの書き方

```java
// src/chapter01/Exercises.java

package chapter01;

public class Exercises {

    // 問題 1-1: "Hello World" を返す
    public static String problem1_1() {
        throw new UnsupportedOperationException("問題 1-1 を実装してください");
    }

    // 問題 1-4: 13 と 17 の和を返す
    public static int problem1_4() {
        throw new UnsupportedOperationException("問題 1-4 を実装してください");
    }
}
```

## 骨格コードの原則

- メソッドシグネチャ（名前・引数・戻り値の型）は変えない
- `throw new UnsupportedOperationException` をそのまま残す（テストが例外で失敗するのが「Red」の状態）
- 問題のコメントに問題番号と概要を明記する
- 入力値は Scanner から取ることは **しない**（引数で受け取る）

## 実装設計の原則

### テスト可能な構造にする

コンソール I/O に依存する問題でも、**計算ロジックは引数・戻り値で表現できるメソッド**として切り出す。

```java
// NG: テストできない
static void problem1_4() {
    int x = 13 + 17;
    System.out.println(x);
}

// OK: ロジックをメソッドに切り出す
static int problem1_4() {
    return 13 + 17;
}
```

### 表示系の問題

文字列を**返す** メソッドとして実装し、main から System.out.println で出力する。
これにより、テストでは戻り値を assertEquals するだけでよくなる。
