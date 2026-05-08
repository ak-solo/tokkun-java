package chapter08;

// 問題 8-2 / 8-4: Animal を継承した Dog クラス
public class Dog extends Animal {

    // 問題 8-2: super(name, age) を呼ぶコンストラクタ
    public Dog(String name, int age) {
        super(name, age);
    }

    // 問題 8-2: "トコトコ" を返す
    public String run() {
        throw new UnsupportedOperationException("問題 8-2 を実装してください");
    }

    // 問題 8-4: "ワンワン" を返す（Animal.speak() のオーバーライド）
    @Override
    public String speak() {
        throw new UnsupportedOperationException("問題 8-4 を実装してください");
    }
}
