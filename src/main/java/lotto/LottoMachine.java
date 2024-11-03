package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public static final int PRICE_PER_LOTTO = 1000;

    public List<Lotto> purchaseLotto() {
        int amount = inputAmount();
        return generateTickets(amount / PRICE_PER_LOTTO);
    }

    private int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();

                int amount;
                try {
                    amount = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
                }

                if (amount <= 0) {
                    throw new IllegalArgumentException("[ERROR] 구입금액은 0보다 커야 합니다.");
                }
                if (amount % PRICE_PER_LOTTO != 0) {
                    throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1,000원 단위여야 합니다.");
                }
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
