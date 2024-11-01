package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static final int PRICE_PER_LOTTO = 1000;

    public void purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = Integer.parseInt(input);
        int count = amount / PRICE_PER_LOTTO;

        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

}
