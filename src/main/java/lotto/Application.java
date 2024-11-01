package lotto;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        game.purchaseLotto();
        game.inputWinningNumbers();
        game.inputBonusNumber();
        game.printResult();
    }
}
