# 8章 クラスⅡ

## 基礎知識

### 継承（extends）

既存のクラスを**親クラス（スーパークラス）**として、その機能を引き継ぐ新しいクラスを作れます。
これを**継承**といい、Java では `extends 親クラス名` で宣言します。

```java
public class Animal {
    private String name = "";
    private int    age  = 0;
    // ゲッター・セッター省略
}

// Animal を継承した Cat クラス
public class Cat extends Animal {
    public String sleep() {
        return "スースー";
    }
}
```

```java
Cat cat = new Cat();
cat.setName("タマ");         // Animal のメソッドを Cat でも使える
System.out.println(cat.getName());
System.out.println(cat.sleep());
```

---

### コンストラクタと super()

派生クラスのコンストラクタでは、`super(...)` で親クラスのコンストラクタを呼び出します。

```java
public class Animal {
    public Animal(String name, int age) {
        // ...
    }
}

public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);  // Animal のコンストラクタを呼ぶ
    }
}
```

```java
Cat cat = new Cat("タマ", 2);  // name="タマ"、age=2 で初期化
```

---

### オーバーライド（@Override）

親クラスのメソッドを子クラスで**上書き**できます。

- Java では親クラスのメソッドに特別なキーワードは不要です（すべてのメソッドは基本的にオーバーライド可能）
- 子クラスのメソッドに `@Override` アノテーションを付けます

```java
public class Animal {
    public String speak() {
        return "......";  // デフォルトの鳴き声
    }
}

public class Cat extends Animal {
    @Override
    public String speak() {
        return "ニャー";  // Cat 専用の鳴き声
    }
}

public class Dog extends Animal {
    @Override
    public String speak() {
        return "ワンワン";  // Dog 専用の鳴き声
    }
}
```

---

### ポリモーフィズム

親クラス型の変数に、子クラスのインスタンスを代入できます。
メソッドを呼び出すと、**実際のインスタンスの型**に応じたメソッドが実行されます。

```java
Animal[] animals = {
    new Cat("タマ", 2),
    new Dog("ポチ", 3),
    new Cat("ミケ", 1)
};

for (Animal a : animals) {
    System.out.println(a.speak());  // Cat なら "ニャー"、Dog なら "ワンワン"
}
```

`animals` の型は `Animal[]` ですが、実行時には Cat や Dog それぞれの `speak` が呼ばれます。
これが**ポリモーフィズム（多態性）**です。

---

## 練習問題

> **注意:** 問題 8-1 以降の `Animal` クラスはすでに実装済みです。骨格ファイルの `Animal` を変更せず、`Cat` と `Dog` を実装してください。

### 問題 8-1

`Animal` クラスを継承した `Cat` クラスを実装しなさい。

- コンストラクタ `Cat(String name, int age)` で `super(name, age)` を呼ぶ
- `sleep()` メソッドを実装し、`"スースー"` を返す

次に、`problem8_1` で `Cat` をインスタンス化し、`showProfile()` と `sleep()` の結果をカンマ区切りで返しなさい。

---

### 問題 8-2

`Animal` クラスを継承した `Dog` クラスを実装しなさい。

- コンストラクタ `Dog(String name, int age)` で `super(name, age)` を呼ぶ
- `run()` メソッドを実装し、`"トコトコ"` を返す

次に、`problem8_2` で `Dog` をインスタンス化し、`showProfile()` と `run()` の結果をカンマ区切りで返しなさい。

---

### 問題 8-3

`Cat` クラスに `speak()` メソッドを `@Override` して実装しなさい。

- `Animal.speak()` のデフォルト実装は `"......"` を返す
- `Cat.speak()` は `"ニャー"` を返す

次に、`problem8_3` で `Animal` 型の変数に `Cat` を代入して `speak()` を呼び出しなさい。

**ヒント:** `Animal a = new Cat("タマ", 2);` のように `Animal` 型変数に代入しても、`speak()` は `Cat` のものが呼ばれます。

---

### 問題 8-4

`Dog` クラスに `speak()` メソッドを `@Override` して実装しなさい。

- `Dog.speak()` は `"ワンワン"` を返す

次に、`problem8_4` で `Animal` 型の変数に `Dog` を代入して `speak()` を呼び出しなさい。

---

### 問題 8-5

`Animal` 型の配列を使って、`Cat` と `Dog` のインスタンスをまとめて扱いなさい。

- 要素数 4 の `Animal` 配列を作成する
- 偶数インデックス（0、2）に `Cat`、奇数インデックス（1、3）に `Dog` を格納する
- ループで各要素の `showProfile()` と `speak()` を呼ぶ

次に、`problem8_5` で上記の配列を作成し、ループで各要素の `speak()` を呼んでカンマ区切りの文字列で返しなさい。

**ポイント:** `Animal` 型の変数に `Cat`/`Dog` を代入しても、`speak()` は実際のクラスのものが呼ばれます。これがポリモーフィズムです。
