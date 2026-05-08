package chapter07;

// Chapter 07 プレイグラウンド — クラスI
// 実行: gradle runChapter07
//
// src/chapter07/Exercises.java に実装を書いてから実行しよう
// 値を変えながら繰り返し試してみよう

public class Playground {

    public static void main(String[] args) {

        try {
            Dog dog = new Dog();
            dog.setName("ポチ");
            dog.setAge(3);
            System.out.println("名前: " + dog.getName());
            System.out.println("年齢: " + dog.getAge() + "歳");
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 7-1");
        }

        try {
            Dog dog1 = new Dog();
            dog1.setName("ポチ");
            dog1.setAge(3);

            Dog dog2 = new Dog();
            dog2.setName("コロ");
            dog2.setAge(5);

            System.out.println("dog1 → 名前: " + dog1.getName() + ", 年齢: " + dog1.getAge() + "歳");
            System.out.println("dog2 → 名前: " + dog2.getName() + ", 年齢: " + dog2.getAge() + "歳");

            dog1.setName("タロ");
            System.out.println("dog1.name を変更後 → dog2.name = " + dog2.getName());
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 7-2");
        }

        try {
            String[] breeds = {"柴犬", "トイプードル", "ゴールデンレトリバー"};
            String[] names  = {"ポチ", "モコ", "ゴールド"};
            int[]    ages   = {3, 1, 5};

            for (int i = 0; i < 3; i++) {
                Dog d = new Dog(breeds[i]);
                d.setName(names[i]);
                d.setAge(ages[i]);
                System.out.println(d.showProfile());
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 7-3");
        }

        try {
            CoinCase cc = new CoinCase();
            cc.addCoins(500, 1);
            cc.addCoins(100, 2);
            cc.addCoins(50,  3);
            cc.addCoins(10,  4);
            cc.addCoins(5,   5);
            cc.addCoins(1,   6);

            for (int d : new int[]{500, 100, 50, 10, 5, 1}) {
                System.out.printf("%4d円: %3d枚%n", d, cc.getCount(d));
            }
            System.out.println("合計金額: " + cc.getAmount() + "円");
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 7-4");
        }

        try {
            CoinCase cc2 = new CoinCase();
            cc2.addCoins(500, 2);
            cc2.addCoins(100, 5);
            cc2.addCoins(10,  3);

            System.out.println("合計枚数: " + cc2.getCount() + "枚");
            System.out.println("500円の合計: " + cc2.getAmount(500) + "円");
            System.out.println("100円の合計: " + cc2.getAmount(100) + "円");
            System.out.println(" 10円の合計: " + cc2.getAmount(10) + "円");
            System.out.println("全体の合計: " + cc2.getAmount() + "円");
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 7-5");
        }
    }
}
