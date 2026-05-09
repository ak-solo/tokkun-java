# 7章 クラスⅠ

## 基礎知識

### クラスとインスタンス

**クラス**は「もののひな型（設計図）」です。クラスから作られた実体を**インスタンス**といいます。

```java
// クラス定義（設計図）
public class Dog {
    // ...
}

// インスタンスの生成（実体を作る）
Dog pochi = new Dog();
Dog koro  = new Dog();
// pochi と koro は独立した別々のオブジェクト
```

---

### フィールド（メンバー変数）

クラスが持つデータを**フィールド**（メンバー変数）として宣言します。
外部から直接アクセスさせないために `private` にするのが基本です。

```java
public class Dog {
    private String name = "";  // 名前（初期値は空文字）
    private int    age  = 0;   // 年齢（初期値は 0）
}
```

---

### ゲッター・セッター

フィールドを `private` にして外部から直接触れないようにし、**ゲッター（getter）** と **セッター（setter）** というメソッドを通じて読み書きを制御します。

```java
public class Dog {
    private String name = "";

    // ゲッター: 名前を読み取る
    public String getName() {
        return name;
    }

    // セッター: 名前を書き込む
    public void setName(String name) {
        this.name = name;
    }
}
```

```java
Dog dog = new Dog();
dog.setName("ポチ");           // セッターで書き込む
System.out.println(dog.getName()); // ゲッターで読み取る → "ポチ"
```

読み取り専用にしたい場合はセッターを定義しません。

---

### コンストラクタ

インスタンス生成時に自動で呼ばれるメソッドが**コンストラクタ**です。
クラスと同じ名前のメソッドとして定義します。

```java
public class Dog {
    private String breed = "";

    // 引数なしコンストラクタ
    public Dog() { }

    // 引数ありコンストラクタ
    public Dog(String breed) {
        this.breed = breed;
    }
}
```

```java
Dog dog1 = new Dog();         // 引数なしで生成
Dog dog2 = new Dog("柴犬");   // 犬種を指定して生成
```

---

### メソッド

クラスの動作を定義するのが**メソッド**です。フィールドを使って処理します。

```java
public String showProfile() {
    return breed + ": " + name + " (" + age + "歳)";
}
```

---

### メソッドのオーバーロード

同じ名前で**引数のリストが異なる**メソッドを複数定義できます。これを**オーバーロード**といいます。

```java
// 引数なし → 合計枚数を返す
public int getCount() {
    // ...
}

// 引数あり → 指定した種類の枚数を返す
public int getCount(int denomination) {
    // ...
}
```

---

### HashMap

硬貨の種類と枚数のような「キーと値の対応」を管理するときは `HashMap<K, V>` が便利です。

```java
import java.util.HashMap;
import java.util.Map;

Map<Integer, Integer> coins = new HashMap<>();
coins.put(100, 0);   // 100円玉: 0枚
coins.put(50, 0);    // 50円玉: 0枚

coins.put(100, coins.get(100) + 3);  // 100円玉を3枚追加

int count = coins.get(100);  // 3
```

---

## 練習問題

### 問題 7-1

`Dog` クラスに `name`（`String`）フィールドとゲッター・セッターを実装しなさい。

- `private` フィールド `name` を `""` で初期化する
- `getName()` で `name` を返す
- `setName(String name)` で `name` を書き込む

また、`problem7_1(String name)` を実装しなさい。`Dog` をインスタンス化し、`setName()` で `name` をセットして `getName()` を返します。

---

### 問題 7-2

`Dog` クラスに `age`（`int`）フィールドとゲッター・セッターを追加しなさい。

- `private` フィールド `age` を `0` で初期化する
- `getAge()` で `age` を返す
- `setAge(int age)` で `age` を書き込む

また、`problem7_2(String name, int age)` を実装しなさい。`Dog` をインスタンス化し、`setName()` と `setAge()` をセットして `"{getName()},{getAge()}"` 形式で返します。

例: `name="ポチ"`, `age=3` → `"ポチ,3"`

---

### 問題 7-3

`Dog` インスタンスを 2 つ作成し、それぞれ独立したデータを持てることを確認しなさい。

- 1 つ目に `setName("ポチ")`、2 つ目に `setName("コロ")` を設定する
- 1 つ目の名前を `"タロ"` に変更しても、2 つ目には影響しないことを確認する

**ポイント:** クラスから生成したインスタンスはそれぞれ独立したデータを持ちます。

また、`problem7_3()` を実装しなさい。上記の手順を実行し、変更後の `"{dog1.getName()},{dog2.getName()}"` を返します。インスタンスが独立していれば `"タロ,コロ"` が返ります。

---

### 問題 7-4

`Dog` クラスに以下を追加しなさい。

- `private` フィールド `breed`（犬種、`String`）を `""` で初期化する
- 犬種を引数に取るコンストラクタ `Dog(String breed)` を実装する
- 犬種を読み取り専用で返す `getBreed()` を実装する
- `showProfile()` を実装し、`"犬種: 名前 (年齢歳)"` 形式の文字列を返す

また、`problem7_4(String breed, String name, int age)` を実装しなさい。`new Dog(breed)` でインスタンスを生成し、`setName()` と `setAge()` をセットして `showProfile()` の結果を返します。

例: `breed="柴犬"`, `name="ポチ"`, `age=3` → `"柴犬: ポチ (3歳)"`

---

### 問題 7-5

硬貨の入れ物を表す `CoinCase` クラスを実装しなさい。

対応する硬貨: **500 円・100 円・50 円・10 円・5 円・1 円**

| メソッド | 引数 | 戻り値 | 説明 |
|---------|------|--------|------|
| `addCoins` | `int denomination`、`int count` | なし | 指定種類の硬貨を枚数分追加する。無効な種類は無視する |
| `getCount` | `int denomination` | `int` | 指定種類の硬貨の枚数を返す |
| `getAmount` | なし | `int` | 全硬貨の合計金額を返す |

**ヒント:** `HashMap<Integer, Integer>` で硬貨の種類と枚数を管理すると便利です。コンストラクタで 6 種類の硬貨を 0 枚で初期化しておきましょう。

また、`problem7_5(int denomination, int count)` を実装しなさい。`CoinCase` をインスタンス化して指定の硬貨を追加し、合計金額を返します。

例: `denomination=100`, `count=5` → `500`

---

### 問題 7-6

`CoinCase` クラスにオーバーロードメソッドを追加しなさい。

| メソッド | 引数 | 戻り値 | 説明 |
|---------|------|--------|------|
| `getCount` | なし | `int` | 全硬貨の合計枚数を返す |
| `getAmount` | `int denomination` | `int` | 指定種類の硬貨の合計金額を返す |

問題 7-5 の `getCount(denomination)` と `getAmount()` と同名ですが、引数が異なるオーバーロードとして実装します。

また、`problem7_6(int denomination, int count)` を実装しなさい。`CoinCase` をインスタンス化して指定の硬貨を追加し、`"{合計枚数},{指定種の合計金額}"` を返します。

例: `denomination=100`, `count=4` → `"4,400"`
