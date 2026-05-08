# tokkun-java — Java ハンズオン学習教材

## プロジェクト概要

Java を題材にした初学者向けプログラミング学習教材。
「基礎説明 → 問題を解く → ユニットテストで自己検証 → プレイグラウンドで体験する」
というサイクルで、手を動かしながら学べることを目指す。

### 学習の流れ

```
1. docs/ の README（基礎説明 + 問題文）を読む
2. src/ の骨格コードに実装を書く
3. gradle test でユニットテストを実行し、全テストが通るまで修正する
4. gradle runChapterXX でプレイグラウンドを動かして体感する
```

---

## ディレクトリ構成

```
tokkun-java/
├── .devcontainer/
│   ├── devcontainer.json       # VSCode devcontainer 設定
│   └── Dockerfile
├── docs/
│   ├── chapter01.md            # 基礎説明 + 問題文（章ごと）
│   ├── chapter02.md
│   └── ...
├── src/
│   ├── chapter01/
│   │   └── Exercises.java      # 初学者が実装を書くファイル（骨格のみ）
│   ├── chapter02/
│   └── ...
├── tests/
│   ├── chapter01/
│   │   └── ExercisesTest.java  # ユニットテスト（変更しない）
│   ├── chapter02/
│   └── ...
├── playground/
│   ├── chapter01/
│   │   └── Playground.java     # 値を変えながら実行できる実験用コード
│   ├── chapter02/
│   └── ...
├── build.gradle
├── settings.gradle
└── CLAUDE.md
```

---

## 章の構成

| ファイル | 章タイトル | 主なトピック |
|---|---|---|
| chapter01 | 表示・変数・演算 | System.out.println、変数、四則演算、Math.pow |
| chapter02 | 引数と戻り値 | 引数、戻り値、型、文字列結合 |
| chapter03 | 分岐 | if/else if/else、switch、論理演算子 |
| chapter04 | 繰り返し | for/while/do-while、break/continue、フィボナッチ、素因数分解 |
| chapter05 | 配列 | 1次元・2次元配列、for-each、ソート |
| chapter06 | メソッド | 戻り値あり/なし、引数、boolean 返し |
| chapter07 | クラスⅠ | フィールド、ゲッター/セッター、コンストラクタ、オーバーロード |
| chapter08 | クラスⅡ | 継承、オーバーライド、ポリモーフィズム |
| chapter09 | Stream API | filter、map、sorted、Collectors.groupingBy |

---

## 命名規則

| 要素 | 規則 | 例 |
|---|---|---|
| パッケージ | `chapterNN` | `chapter01` |
| 実装クラス | `Exercises` | `public class Exercises` |
| メソッド名 | `problem[章]_[番号]` + 補足 | `problem1_4()`, `problem9_7_HasNegative()` |
| テストクラス | `ExercisesTest` | `class ExercisesTest` |
| テストメソッド | `test_[問題番号]_[説明]` | `test_1_4_SumOf13And17` |

---

## 問題追加の手順

新しい問題・章を追加するときの手順：

1. `docs/chapterXX.md` に基礎説明と問題文を書く
2. `src/chapterXX/Exercises.java` に骨格メソッド（`UnsupportedOperationException`）を追加する
3. `tests/chapterXX/ExercisesTest.java` にユニットテストを書く
4. `playground/chapterXX/Playground.java` に実験用コードを追加する
5. `build.gradle` の `runChapterNN` タスクを確認する

---

## 制約・注意事項

- テストを通すためだけの**ハードコード**（`return 30;` など）は禁止。汎用的なロジックで実装すること
- 骨格コードの**メソッドシグネチャは変えない**（テストが壊れる）
- 入力は必ず**引数**で受け取る（Scanner を使ってコンソール入力しない）
- Chapter01〜Chapter03 の問題は戻り値ありのメソッドとして設計する
- Chapter04 以降のループ・配列は、結果を返す形（配列・文字列など）で設計する

---

## devcontainer（.devcontainer/）

### 含める環境

- JDK 21 (eclipse-temurin)
- Gradle 8.7
- VSCode 拡張機能
  - `redhat.java`
  - `vscjava.vscode-java-debug`
  - `vscjava.vscode-java-test`
  - `vscjava.vscode-gradle`

### 確認コマンド

```bash
gradle --version                   # バージョン確認
gradle test                        # 全テストを実行
gradle test --tests "chapter01.*"  # chapter01 のテストのみ
gradle runChapter01                # プレイグラウンドを実行
```

---

## Git コミット方針

- コミットは **変更理由（目的）ごとに分割**すること
- 1コミット = 1つの論理的な変更（機能追加・バグ修正・リファクタリングを混在させない）
- コミット前に変更内容を確認し、複数の目的が混在していれば必ず分割する
- ファイルをまとめて `git add .` せず、目的ごとに `git add <ファイル>` で個別にステージングすること
- コミットメッセージは「何をしたか」ではなく「**なぜ**その変更をしたか」を書く
- コミットメッセージには必ず以下のプレフィックスをつけること

### コミットメッセージのプレフィックス

| プレフィックス | 用途 |
|---|---|
| `feat:` | 新機能の追加 |
| `fix:` | バグ修正 |
| `docs:` | ドキュメントのみの変更 |
| `style:` | コードの見た目の変更（機能に影響しない空白等） |
| `refactor:` | バグ修正でも機能追加でもないコード変更（リファクタリング） |
| `chore:` | ビルド設定・ライブラリ更新・CI 設定など |
