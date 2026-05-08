package chapter08;

// Chapter 08 プレイグラウンド — クラスII
// 実行: gradle runChapter08
//
// src/chapter08/Exercises.java に実装を書いてから実行しよう
// 値を変えながら繰り返し試してみよう

public class Playground {

    public static void main(String[] args) {

        try {
            Cat cat = new Cat("タマ", 2);
            System.out.println(cat.showProfile());
            System.out.println(cat.sleep());
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 8-1");
        }

        try {
            Dog dog = new Dog("ポチ", 3);
            System.out.println(dog.showProfile());
            System.out.println(dog.run());
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 8-2");
        }

        try {
            Cat cat2 = new Cat("タマ", 2);
            Dog dog2 = new Dog("ポチ", 3);
            System.out.println("Cat.speak: " + cat2.speak());
            System.out.println("Dog.speak: " + dog2.speak());
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 8-3");
        }

        try {
            Animal[] animals = {
                new Cat("タマ", 2),
                new Dog("ポチ", 3),
                new Cat("ミケ", 1),
                new Dog("コロ", 5)
            };

            for (Animal a : animals) {
                System.out.println(a.showProfile() + " → " + a.speak());
            }

            Animal a2 = new Cat("サクラ", 4);
            System.out.println("変数の型: Animal、実際のインスタンス: Cat");
            System.out.println("speak の結果: " + a2.speak());
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 8-4");
        }
    }
}
