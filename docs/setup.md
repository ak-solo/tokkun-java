# 環境構築手順

この教材は **VSCode の Dev Containers** を使って学習環境を構築します。
Docker コンテナの中に Java SDK と Gradle が自動でセットアップされるため、手元の PC に Java や Gradle をインストールする必要はありません。

---

## 必要なもの

| ツール | 説明 |
|--------|------|
| Git | リポジトリのクローンに使用 |
| Docker Desktop | コンテナを動かすためのソフトウェア |
| Visual Studio Code | コードエディタ |
| Dev Containers 拡張機能 | VSCode からコンテナを操作するための拡張機能 |

---

## 手順

### 1. Git をインストールする

1. https://git-scm.com/download/win を開く
2. インストーラーをダウンロードして実行する
3. 設定はすべてデフォルトのまま「Next」を押し続けてインストールする
4. コマンドプロンプトまたは PowerShell を開き、次のコマンドで確認する

```
git --version
```

---

### 2. Docker Desktop をインストールする

1. https://docs.docker.com/desktop/install/windows-install/ を開く
2. 「Docker Desktop for Windows」をダウンロードしてインストールする
3. インストール後、PC を再起動する
4. タスクバーに Docker のクジラアイコンが表示されれば起動成功

> **注意:** WSL 2 が必要です。インストーラーの指示に従って有効化してください。

---

### 3. Visual Studio Code をインストールする

1. https://code.visualstudio.com/ を開く
2. 自分の OS に合ったインストーラーをダウンロードして実行する

---

### 4. Dev Containers 拡張機能をインストールする

1. VSCode を起動する
2. 左サイドバーの拡張機能アイコン（四角が4つ並んだアイコン）をクリックする
3. 検索欄に `Dev Containers` と入力する
4. 「Dev Containers」（発行者: Microsoft）を選択し、「インストール」をクリックする

   拡張機能 ID: `ms-vscode-remote.remote-containers`

---

### 5. リポジトリをクローンする

ターミナル（Windows はコマンドプロンプトまたは PowerShell）で次のコマンドを実行する。

```
git clone https://github.com/ak-solo/tokkun-java.git
cd tokkun-java
```

---

### 6. VSCode でフォルダを開く

コマンドプロンプトまたは PowerShell で次のコマンドを実行する。

```
code .
```

または VSCode のメニューから「ファイル → フォルダーを開く」で `tokkun-java` フォルダを選択する。

---

### 7. Dev Container で開き直す

フォルダを開くと、右下に次のようなポップアップが表示される。

> 「フォルダーにデベロッパーコンテナー構成ファイルが含まれています。コンテナーで再度開きますか？」

**「コンテナーで再度開く」** をクリックする。

ポップアップが表示されない場合は、次の手順で操作する。

1. `Ctrl+Shift+P` でコマンドパレットを開く
2. `Dev Containers: Reopen in Container` と入力して選択する

---

### 8. コンテナのビルドを待つ

初回は Docker イメージのダウンロードとビルドが行われます。  
環境によって **5〜15 分**程度かかります。

右下に「Starting Dev Container」と表示され、完了すると VSCode のウィンドウが再起動します。

---

### 9. 動作確認

コンテナが起動したら、VSCode のターミナル（`` Ctrl+@ `` または「ターミナル → 新しいターミナル」）で次のコマンドを実行する。

```bash
java --version
```

Java 21 のバージョンが表示されれば成功です。

テストを実行して環境を確認する。

```bash
gradle test
```

全テストが `UnsupportedOperationException` で失敗すれば正常です（まだ何も実装していない Red の状態）。

---

## 主なコマンド

| コマンド | 説明 |
|---------|------|
| `gradle test` | 全テストを実行する |
| `gradle test --tests "chapter01.*"` | 1章のテストだけ実行する |
| `gradle runChapter01` | 1章のプレイグラウンドを実行する |
| `gradle jshellChapter01` | 1章専用の JShell を起動する（`problem1_1()` とメソッド名だけで呼べる） |
| `gradle jshell` | JShell を起動する（完全修飾名 `chapter01.Exercises.problem1_1()` で呼ぶ） |

### JShell の使い方

**章専用タスク（推奨）**: `gradle jshellChapter01`（番号は対象章に合わせる）

```
$ gradle jshellChapter01
|  ようこそ JShell へ。

-> problem1_4()
$1 ==> 30

-> /exit
```

**汎用タスク**: `gradle jshell` — 全章のクラスパスが通っているため、完全修飾名で複数章をまたいで呼べます。

```
$ gradle jshell

-> chapter01.Exercises.problem1_4()
$1 ==> 30

-> chapter02.Exercises.problem2_1("hello")
$2 ==> "HELLO"

-> /exit
```

コードを変更したときは `/exit` で終了し、タスクを再実行すると最新の実装が反映されます。

---

## これで準備完了

環境構築は以上です。  
学習の進め方は [README.md](../README.md) を参照してください。

---

## トラブルシューティング

### Docker が起動しない

- WSL 2 が有効になっているか確認する
- BIOS で仮想化（Virtualization）が有効になっているか確認する

### コンテナのビルドに失敗する

- Docker Desktop が起動していることを確認する
- Docker Desktop の設定で「Resources → Memory」を 4GB 以上に設定してみる
- ネットワーク接続を確認する（Docker イメージのダウンロードが必要）

### `gradle test` が実行できない

- ターミナルが Dev Container 内で動いているか確認する（VSCode 左下に「Dev Container: tokkun-java」と表示されていれば OK）
- コンテナを再ビルドする: コマンドパレットで `Dev Containers: Rebuild Container` を実行する
