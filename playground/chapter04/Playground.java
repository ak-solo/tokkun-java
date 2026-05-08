package chapter04;

// Chapter 04 プレイグラウンド — 繰り返し
// 実行: gradle runChapter04
//
// src/chapter04/Exercises.java に実装を書いてから実行しよう
// 値を変えながら繰り返し試してみよう

public class Playground {

    public static void main(String[] args) {

        try {
            System.out.println(Exercises.problem4_1());
            System.out.println(Exercises.problem4_2());
            System.out.println(Exercises.problem4_3());
            System.out.println("7! = " + Exercises.problem4_4());
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 4-1 〜 4-4");
        }

        try {
            int n7 = 20100;   // ← 変えて試そう（2 以上）
            System.out.println(n7 + " の素因数: " + Exercises.problem4_7(n7));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 4-7");
        }

        try {
            int n8 = 97;   // ← 変えて試そう
            System.out.println(n8 + " は素数か: " + Exercises.problem4_8(n8));

            StringBuilder primes = new StringBuilder("100 以下の素数: ");
            for (int i = 2; i <= 100; i++) {
                if (Exercises.problem4_8(i)) primes.append(i).append(" ");
            }
            System.out.println(primes);
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 4-8");
        }

        try {
            int size9 = 5;   // ← 変えて試そう
            System.out.println(Exercises.problem4_9(size9));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 4-9");
        }

        try {
            int size10 = 5;   // ← 変えて試そう（2 以上）
            System.out.println(Exercises.problem4_10(size10));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 4-10");
        }

        try {
            System.out.println(Exercises.problem4_11());
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 4-11");
        }
    }
}
