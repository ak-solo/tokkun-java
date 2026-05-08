---
paths:
  - "playground/**"
---

# プレイグラウンド（playground/）

## 目的

- 引数を変えながらメソッドの動作を確認する「実験の場」
- テストとは別に、自分の実装が直感的に正しいか体感できる

## 実行方法

```bash
gradle runChapter01   # Chapter01 を実行
gradle runChapter02   # Chapter02 を実行
```

## ファイル構成

```java
// playground/chapter01/Playground.java

package chapter01;

public class Playground {

    public static void main(String[] args) {
        try {
            System.out.println(Exercises.problem1_1());

            int x9 = 3;   // ← この値を変えて実行してみよう
            System.out.println(x9 + " の 2 倍・3 倍・4 倍: " + Exercises.problem1_9(x9));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 1-1");
        }
    }
}
```

## プレイグラウンドの原則

- `Playground.java` の変数の値（コメントで `← 変えて試そう` と示した箇所）を書き換えて実行する
- 未実装の問題は `UnsupportedOperationException` を catch して `[未実装]` と表示する
- 同じ変数名が複数必要な場合はサフィックスで区別する（例: `x9`, `x10`, `x13`）
