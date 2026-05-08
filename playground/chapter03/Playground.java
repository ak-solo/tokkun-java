package chapter03;

// Chapter 03 プレイグラウンド — 分岐
// 実行: gradle runChapter03
//
// src/chapter03/Exercises.java に実装を書いてから実行しよう
// 値を変えながら繰り返し試してみよう

public class Playground {

    public static void main(String[] args) {

        try {
            int x34 = 10;   // ← 変えて試そう
            int y34 = 5;    // ← 変えて試そう
            System.out.println("3-1: " + Exercises.problem3_1(x34, y34));
            System.out.println("3-2: " + Exercises.problem3_2(x34, y34));
            System.out.println("3-3 大きい方: " + Exercises.problem3_3(x34, y34));
            System.out.println("3-4: " + Exercises.problem3_4(x34, y34));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 3-1 〜 3-4");
        }

        try {
            int x56 = -4;   // ← 変えて試そう
            System.out.println("3-5: " + Exercises.problem3_5(x56));
            System.out.println("3-6: " + Exercises.problem3_6(x56));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 3-5 〜 3-6");
        }

        try {
            int score = 75;   // ← 変えて試そう
            System.out.println("ケース1: " + Exercises.problem3_7_Case1(score));
            System.out.println("ケース2: " + Exercises.problem3_7_Case2(score));
            System.out.println("ケース3: " + Exercises.problem3_7_Case3(score));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 3-7");
        }

        try {
            int midterm = 50;   // ← 変えて試そう
            int finalScore = 90;   // ← 変えて試そう
            System.out.println("中間:" + midterm + " 期末:" + finalScore
                + " → " + Exercises.problem3_8(midterm, finalScore));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 3-8");
        }

        try {
            String[] days  = {"日", "月", "火", "水", "木", "金", "土"};
            String[] times = {"午前", "午後", "夜間"};
            System.out.print("     ");
            for (String d : days) System.out.print(d + "  ");
            System.out.println();
            for (int t = 0; t <= 2; t++) {
                System.out.print(times[t] + " ");
                for (int d = 0; d <= 6; d++) {
                    System.out.print(Exercises.problem3_9(d, t) + "  ");
                }
                System.out.println();
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 3-9");
        }

        try {
            int choice = 1;   // ← 1〜5 で変えて試そう
            System.out.println(Exercises.problem3_11(choice));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 3-11");
        }

        try {
            for (int month = 1; month <= 12; month++) {
                System.out.println(Exercises.problem3_12(month));
            }
            System.out.println(Exercises.problem3_12(13));
        } catch (UnsupportedOperationException e) {
            System.out.println("  [未実装] 問題 3-12");
        }
    }
}
