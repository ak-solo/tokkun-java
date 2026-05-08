package chapter06;

import java.util.ArrayList;
import java.util.List;

// Chapter 06 プレイグラウンド — メソッド
// 実行: gradle runChapter06
//
// src/chapter06/Exercises.java に実装を書いてから実行しよう
// 値を変えながら繰り返し試してみよう

public class Playground {

    public static void main(String[] args) {

        try {
            int n1 = 5;
            System.out.println(n1 + " の 2 乗 = " + Exercises.problem6_1(n1));
            int a1 = 7, b1 = 13;
            System.out.println("平均(" + a1 + ", " + b1 + ") = " + Exercises.problem6_2(a1, b1));
            System.out.println("最大(" + a1 + ", " + b1 + ") = " + Exercises.problem6_3(a1, b1));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 6-1 〜 6-3");
        }

        try {
            int size = 5;   // ← 変えて試そう
            System.out.println("--- $ 三角形 ---");
            System.out.println(Exercises.problem6_4(size));
            System.out.println();
            System.out.println("--- * 三角形 ---");
            System.out.println(Exercises.problem6_5(size, '*'));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 6-4 〜 6-5");
        }

        try {
            int n6 = 3;   // ← 変えて試そう
            System.out.println("--- " + n6 + " の段 ---");
            System.out.println(Exercises.problem6_6(n6));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 6-6");
        }

        try {
            int n7 = 97;   // ← 変えて試そう
            String result7 = Exercises.problem6_7(n7) ? "素数" : "素数ではない";
            System.out.println(n7 + " は" + result7);

            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i < 1000; i++) {
                if (Exercises.problem6_7(i)) primes.add(i);
            }
            System.out.println("1000 未満の素数: " + primes.size() + " 個");
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 6-7");
        }

        try {
            int a8 = 42, b8 = 99;
            System.out.println("スワップ前: a=" + a8 + ", b=" + b8);
            int[] swapped = Exercises.problem6_8(a8, b8);
            System.out.println("スワップ後: a=" + swapped[0] + ", b=" + swapped[1]);
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 6-8");
        }

        try {
            int[] numbers9 = {5, 3, 8, 1, 9, 2, 7, 4, 6};
            System.out.print("ソート前: ");
            for (int i = 0; i < numbers9.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(numbers9[i]);
            }
            System.out.println();
            Exercises.problem6_9(numbers9);
            System.out.print("ソート後: ");
            for (int i = 0; i < numbers9.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(numbers9[i]);
            }
            System.out.println();
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 6-9");
        }
    }
}
