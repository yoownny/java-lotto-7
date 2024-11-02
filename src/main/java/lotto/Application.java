package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        WinningNumber winningNumber = new WinningNumber();
        LottoResult result = new LottoResult();

        List<Lotto> tickets = machine.purchaseLotto();

    }
}
