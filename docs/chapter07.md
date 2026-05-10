# 7章 クラスⅠ

## 基礎知識

### オブジェクト指向とは

これまでは変数とメソッドを別々に扱ってきました。しかし現実のものごとは「データ」と「操作」がセットになっています。

たとえば「犬」を考えると、
- **データ:** 名前・年齢・犬種
- **操作:** 吠える・プロフィールを表示する

**オブジェクト指向プログラミング**（OOP）とは、こうした「データ」と「操作」をひとまとめにして**オブジェクト**として扱う考え方です。

```
┌───────────────────────────────┐
│          Dog オブジェクト      │
│  データ: name, age, breed     │
│  操作: speak(), showProfile() │
└───────────────────────────────┘
```

こうすることで、関連するものが一か所にまとまりコードが整理されます。また、同じ種類のオブジェクトを何個でも独立して作れます。

---

### クラスとインスタンス

**クラス**は「もののひな型（設計図）」です。クラスから作られた実体を**インスタンス**（オブジェクト）といいます。

```
クラス（設計図）          インスタンス（実体）
┌──────────┐    new    ┌──────────┐  ┌──────────┐
│   Dog    │ ────────▶ │  pochi   │  │  koro    │
│  name    │           │ name=ポチ│  │ name=コロ│
│  age     │           │ age=3   │  │ age=5   │
└──────────┘           └──────────┘  └──────────┘
```

```java
// クラス定義（設計図）
public class Dog {
    // ...
}

// インスタンスの生成（new で実体を作る）
Dog pochi = new Dog();
Dog koro  = new Dog();
// pochi と koro は独立した別々のオブジェクト
// 一方を変更しても、もう一方には影響しない
```

---

### フィールド（メンバー変数）

クラスが持つデータを**フィールド**（メンバー変数）として宣言します。フィールドはインスタンスごとに独立した値を持ちます。

外部から直接アクセスさせないために `private` にするのが基本です（後述のカプセル化）。

```java
public class Dog {
    private String name = "";  // 名前（初期値は空文字）
    private int    age  = 0;   // 年齢（初期値は 0）
}
```

`private` にすると、クラスの外から `dog.name = "ポチ"` のように直接書き換えることができなくなります。

---

### カプセル化とゲッター・セッター

フィールドを `private` にして外から直接アクセスできないようにする考え方を**カプセル化**といいます。代わりに**ゲッター（getter）** と **セッター（setter）** というメソッドを通じて読み書きを制御します。

なぜカプセル化するのかというと、たとえば年齢に `-5` のような不正な値が入るのを防いだり、値が変わったときに他の処理を連動させたりできるからです。

```java
public void setAge(int age) {
    if (age >= 0) this.age = age;  // 負の値は無視する
}
```

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

`new Dog()` と書いたときに**自動で呼ばれる**特別なメソッドが**コンストラクタ**です。クラスと同じ名前で定義します。インスタンスの初期設定に使います。

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
Dog dog1 = new Dog();         // 引数なしで生成 → breed = ""
Dog dog2 = new Dog("柴犬");   // 引数ありで生成 → breed = "柴犬"
```

コンストラクタを定義しない場合、引数なしのコンストラクタが自動的に用意されます。

---

### this キーワード

`this` はそのメソッドを呼び出している**自分自身のインスタンス**を指します。フィールド名と引数名が同じときなど、どちらを指すか明確にしたい場面で使います。

```java
public Dog(String name) {
    this.name = name;  // this.name = フィールド、name = 引数
}
```

---

### メソッド

クラスの動作を定義するのが**メソッド**です。フィールドを使って処理します。クラスの外からは `インスタンス名.メソッド名()` で呼び出します。

```java
public String showProfile() {
    return breed + ": " + name + " (" + age + "歳)";
}
```

---

### メソッドのオーバーロード

同じ名前で**引数のリストが異なる**メソッドを複数定義できます。これを**オーバーロード**といいます。呼び出し側は渡す引数によって自動的に適切なメソッドが選ばれます。

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

```java
CoinCase c = new CoinCase();
c.getCount();     // 引数なし版が呼ばれる
c.getCount(100);  // 引数あり版が呼ばれる
```

引数の型か数が異なれば別のメソッドとして定義できます。戻り値の型だけが違うオーバーロードはできません。

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
