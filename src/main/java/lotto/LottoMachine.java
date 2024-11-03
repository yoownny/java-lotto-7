package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int PRICE_PER_LOTTO = 1000;
    InputValidator validator = new InputValidator();

    public List<Lotto> purchaseLotto() {
        int amount = inputAmount();
        return generateTickets(amount / PRICE_PER_LOTTO);
    }

    private int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        validator.inputamount(amount);
        return Integer.parseInt(amount);
    }

    private List<Lotto> generateTickets(int count) {
        List<Lotto> tickets = new ArrayList<>();
        System.out.println("\n" + count + "개를 구매했습니다.");

        for (int i = 0; i < count; i++) {
            Lotto ticket = createLotto();
            tickets.add(ticket);
            System.out.println(ticket.getNumbers());
        }
        return tickets;
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
