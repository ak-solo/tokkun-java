package chapter05;

import java.util.Arrays;

// Chapter 05 プレイグラウンド — 配列
// 実行: gradle runChapter05
//
// src/chapter05/Exercises.java に実装を書いてから実行しよう
// 値を変えながら繰り返し試してみよう

public class Playground {

    private static String joinInts(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(n);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        try {
            int[] numbers12 = {3, 7, 1, 9, 4};   // ← 変えて試そう
            System.out.println("元: " + joinInts(numbers12));
            System.out.println("2倍: " + joinInts(Exercises.problem5_1(numbers12)));
            System.out.println("逆順: " + joinInts(Exercises.problem5_2(numbers12)));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 5-1 〜 5-2");
        }

        try {
            int[] numbers3 = {42, 7, 54, 35, 71, 13, 21, 45, 32, 8};   // ← 変えて試そう
            int[][] r3 = Exercises.problem5_3(numbers3);
            System.out.println("偶数: " + joinInts(r3[0]));
            System.out.println("奇数: " + joinInts(r3[1]));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 5-3");
        }

        try {
            int value = 42;   // ← 変えて試そう（0〜65535）
            int[] binary = Exercises.problem5_5(value);
            StringBuilder sb = new StringBuilder();
            for (int b : binary) sb.append(b);
            System.out.println(value + " = " + sb);
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 5-5");
        }

        try {
            int[][] kuku = Exercises.problem5_6();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.printf("%3d", kuku[i][j]);
                }
                System.out.println();
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 5-6");
        }

        try {
            int x7 = 7;   // ← 1〜9 で変えて試そう
            int y7 = 8;   // ← 1〜9 で変えて試そう
            System.out.println(x7 + " × " + y7 + " = " + Exercises.problem5_7(x7, y7));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 5-7");
        }

        try {
            int[] numbers8 = {5, 3, 8, 1, 9, 2, 7, 4, 6, 0};   // ← 変えて試そう
            int[] sorted = Exercises.problem5_8(numbers8);
            System.out.println("元:   " + joinInts(numbers8));
            System.out.println("並替: " + joinInts(sorted));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 5-8");
        }

        try {
            int[] numbers9 = {10, 20, 30, 40};   // ← 変えて試そう
            System.out.println("平均: " + Exercises.problem5_9(numbers9));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 5-9");
        }

        try {
            int[] results10 = {1, 0, 1, 1, 0};   // ← 変えて試そう（1=勝ち, 0=負け）
            int[] r10 = Exercises.problem5_10(results10);
            System.out.println("勝ち: " + r10[0] + ", 負け: " + r10[1]);
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 5-10");
        }

        try {
            int[] giants11 = {1, 2, 0, 3, 0, 1, 0, 2, 0};   // ← 変えて試そう
            int[] tigers11 = {0, 0, 2, 0, 1, 0, 0, 0, 3};   // ← 変えて試そう
            int g = Exercises.problem5_11_TotalScore(giants11);
            int t = Exercises.problem5_11_TotalScore(tigers11);
            System.out.println("巨人 " + g + " - " + t + " 阪神");
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 5-11");
        }

        try {
            int[] numbers13 = {5, 3, 8, 1, 9};   // ← 変えて試そう
            System.out.println("最大: " + Exercises.problem5_12(numbers13));
            int[] r13 = Exercises.problem5_13(numbers13);
            System.out.println("最大: " + r13[0] + ", 最小: " + r13[1]);
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 5-12 〜 5-13");
        }

        try {
            int[] numbers14 = {30, 40, 50, 60};   // ← 変えて試そう
            System.out.println("停止時の合計: " + Exercises.problem5_14(numbers14));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 5-14");
        }

        try {
            int[] pitches15 = {1, 2, 1, 1};   // ← 変えて試そう（1=S, 2=B）
            System.out.println("5-15: " + Exercises.problem5_15(pitches15));

            int[] pitches16 = {3, 3, 1};      // ← 変えて試そう（1=S, 2=B, 3=F）
            System.out.println("5-16: " + Exercises.problem5_16(pitches16));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 5-15 〜 5-16");
        }

        try {
            int[] numbers17 = {5, 10, 3, 0, 99};   // ← 変えて試そう
            System.out.println("0 の手前の合計: " + Exercises.problem5_17(numbers17));
            System.out.println("0 の手前の平均: " + Exercises.problem5_18(numbers17));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 5-17 〜 5-18");
        }
    }
}
