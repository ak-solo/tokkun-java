package chapter02;

// Chapter 02 プレイグラウンド — 引数と戻り値
// 実行: gradle runChapter02
//
// src/chapter02/Exercises.java に実装を書いてから実行しよう
// 値を変えながら繰り返し試してみよう

public class Playground {

    public static void main(String[] args) {

        try {
            String s = "Hello Java";   // ← 変えて試そう
            System.out.println(Exercises.problem2_1(s));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 2-1");
        }

        try {
            int x2 = 42;   // ← 変えて試そう
            System.out.println(Exercises.problem2_2(x2));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 2-2");
        }

        try {
            int x3 = 3;   // ← 変えて試そう
            System.out.println(x3 + " の 1 乗・2 乗・3 乗: " + Exercises.problem2_3(x3));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 2-3");
        }

        try {
            int x4 = 10;   // ← 変えて試そう
            int y4 = 3;    // ← 変えて試そう
            System.out.println("和      : " + Exercises.problem2_4_Sum(x4, y4));
            System.out.println("差(x-y) : " + Exercises.problem2_4_Difference(x4, y4));
            System.out.println("積      : " + Exercises.problem2_4_Product(x4, y4));
            System.out.println("除算    : " + Exercises.problem2_4_Division(x4, y4));
            System.out.println("商      : " + Exercises.problem2_4_Quotient(x4, y4));
            System.out.println("余り    : " + Exercises.problem2_4_Remainder(x4, y4));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 2-4");
        }

        try {
            int a5 = 3;   // ← 変えて試そう
            int b5 = 4;   // ← 変えて試そう
            System.out.println(a5 + " と " + b5 + " の平均: " + Exercises.problem2_5(a5, b5));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 2-5");
        }

        try {
            int age = 20;   // ← 変えて試そう
            System.out.println("年齢 " + age + " 歳 → おおよそ " + Exercises.problem2_6(age) + " 日");
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 2-6");
        }
    }
}
