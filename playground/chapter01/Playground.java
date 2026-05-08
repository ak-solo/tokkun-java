package chapter01;

// Chapter 01 プレイグラウンド — 表示・変数・演算
// 実行: gradle runChapter01
//
// src/chapter01/Exercises.java に実装を書いてから実行しよう
// 値を変えながら繰り返し試してみよう

public class Playground {

    public static void main(String[] args) {

        try {
            System.out.println(Exercises.problem1_1());
            System.out.println(Exercises.problem1_2());
            System.out.println(Exercises.problem1_3());
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 1-1 〜 1-3");
        }

        try {
            System.out.println("13 + 17 = " + Exercises.problem1_4());
            System.out.println("13 * 17 = " + Exercises.problem1_5());
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 1-4 〜 1-5");
        }

        try {
            System.out.println("x=7 を 3 倍→半分（3倍,半分）: " + Exercises.problem1_6());
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 1-6");
        }

        try {
            int x9 = 3;   // ← この値を変えて実行してみよう
            System.out.println(x9 + " の 2 倍・3 倍・4 倍: " + Exercises.problem1_9(x9));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 1-9");
        }

        try {
            int x10 = 2;   // ← この値を変えて実行してみよう
            System.out.println(x10 + " の 1 乗・2 乗・3 乗: " + Exercises.problem1_10(x10));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 1-10");
        }

        try {
            System.out.println("10 / 3 = " + Exercises.problem1_11() + " (double)");
            System.out.println("10 / 3 = " + Exercises.problem1_12() + " (int)");
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 1-11 〜 1-12");
        }

        try {
            int x13 = 17;  // ← 変えて試そう（x > y であること）
            int y13 = 5;   // ← 変えて試そう
            System.out.println(x13 + " ÷ " + y13 + " の（商,余り）: " + Exercises.problem1_13(x13, y13));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 1-13");
        }
    }
}
