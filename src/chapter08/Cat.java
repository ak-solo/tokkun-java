package chapter08;

// 問題 8-1 / 8-3: Animal を継承した Cat クラス
public class Cat extends Animal {

    // 問題 8-1: super(name, age) を呼ぶコンストラクタ
    public Cat(String name, int age) {
        super(name, age);
    }

    // 問題 8-1: "スースー" を返す
    public String sleep() {
        throw new UnsupportedOperationException("問題 8-1 を実装してください");
    }

    // 問題 8-3: "ニャー" を返す（Animal.speak() のオーバーライド）
    @Override
    public String speak() {
        throw new UnsupportedOperationException("問題 8-3 を実装してください");
    }
}
