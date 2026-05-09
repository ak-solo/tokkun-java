package chapter07;

// 問題 7-5 〜 7-6: CoinCase クラス
public class CoinCase {

    // 対応する硬貨の種類: 500, 100, 50, 10, 5, 1
    // ヒント: HashMap<Integer, Integer> で硬貨の種類と枚数を管理する

    // コンストラクタ: 6 種類の硬貨を 0 枚で初期化する
    public CoinCase() {
        throw new UnsupportedOperationException("問題 7-5 の CoinCase コンストラクタを実装してください");
    }

    // 問題 7-5: 指定した種類の硬貨を枚数分追加する（無効な種類は無視）
    public void addCoins(int denomination, int count) {
        throw new UnsupportedOperationException("問題 7-5 を実装してください");
    }

    // 問題 7-5: 指定した種類の硬貨の枚数を返す
    public int getCount(int denomination) {
        throw new UnsupportedOperationException("問題 7-5 を実装してください");
    }

    // 問題 7-5: 全硬貨の合計金額を返す
    public int getAmount() {
        throw new UnsupportedOperationException("問題 7-5 を実装してください");
    }

    // 問題 7-6: 全硬貨の合計枚数を返す（オーバーロード）
    public int getCount() {
        throw new UnsupportedOperationException("問題 7-6 を実装してください");
    }

    // 問題 7-6: 指定した種類の硬貨の合計金額を返す（オーバーロード）
    public int getAmount(int denomination) {
        throw new UnsupportedOperationException("問題 7-6 を実装してください");
    }
}
