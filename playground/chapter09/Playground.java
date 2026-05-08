package chapter09;

import java.util.Map;

// Chapter 09 プレイグラウンド — Stream API
// 実行: gradle runChapter09
//
// src/chapter09/Exercises.java に実装を書いてから実行しよう
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
            int[] nums1 = {5, 1, 8, 3, 9, 2};
            int threshold1 = 4;   // ← この値を変えて試してみよう
            int[] r1 = Exercises.problem9_1(nums1, threshold1);
            System.out.println("9-1 (" + threshold1 + " 以上を昇順): " + joinInts(r1));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 9-1");
        }

        try {
            int[] nums2 = {3, 1, 4};   // ← この配列を変えて試してみよう
            String[] r2 = Exercises.problem9_2(nums2);
            StringBuilder sb = new StringBuilder();
            for (String s : r2) {
                if (sb.length() > 0) sb.append(", ");
                sb.append(s);
            }
            System.out.println("9-2 (ラベル変換): " + sb);
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 9-2");
        }

        try {
            String[] words3 = {"banana", "fig", "apple", "kiwi"};   // ← 単語を変えて試してみよう
            String[] r3 = Exercises.problem9_3(words3);
            StringBuilder sb = new StringBuilder();
            for (String s : r3) {
                if (sb.length() > 0) sb.append(", ");
                sb.append(s);
            }
            System.out.println("9-3 (文字数順): " + sb);
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 9-3");
        }

        try {
            int[] scores4 = {80, 60, 95, 70, 55};   // ← 点数を変えて試してみよう
            double r4 = Exercises.problem9_4(scores4);
            System.out.println("9-4 (平均): " + r4);
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 9-4");
        }

        try {
            int[] nums5 = {5, 2, 8, 3, 4, 6};   // ← この配列を変えて試してみよう
            int[] r5 = Exercises.problem9_5(nums5);
            System.out.println("9-5 (偶数を抽出→2乗→昇順): " + joinInts(r5));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 9-5");
        }

        try {
            int[] scores6 = {70, 85, 60, 95, 75};
            int topN = 3;   // ← この値を変えて試してみよう
            int[] r6 = Exercises.problem9_6(scores6, topN);
            System.out.println("9-6 (上位 " + topN + " 件): " + joinInts(r6));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 9-6");
        }

        try {
            int[] nums7 = {3, -1, 5, 0, 8};   // ← この配列を変えて試してみよう
            System.out.println("9-7 HasNegative: " + Exercises.problem9_7_HasNegative(nums7));
            System.out.println("9-7 AllPositive: " + Exercises.problem9_7_AllPositive(nums7));
            int over7 = 4;   // ← この値を変えて試してみよう
            System.out.println("9-7 CountOver(" + over7 + "): " + Exercises.problem9_7_CountOver(nums7, over7));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 9-7");
        }

        try {
            String[] words8 = {"cat", "elephant", "ox", "dog", "hippopotamus"};
            int minLen8 = 4;   // ← この値を変えて試してみよう
            String[] r8 = Exercises.problem9_8(words8, minLen8);
            StringBuilder sb = new StringBuilder();
            for (String s : r8) {
                if (sb.length() > 0) sb.append(", ");
                sb.append(s);
            }
            System.out.println("9-8 (文字数 " + minLen8 + " 以上を長い順): " + sb);
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 9-8");
        }

        try {
            String[] words9 = {"apple", "ant", "banana", "bear", "cat"};   // ← 単語を変えて試してみよう
            Map<Character, Integer> r9 = Exercises.problem9_9(words9);
            System.out.println("9-9 (先頭文字ごとの件数):");
            r9.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println("  '" + e.getKey() + "': " + e.getValue() + "件"));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 9-9");
        }
    }
}
