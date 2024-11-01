package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static final int PRICE_PER_LOTTO = 1000;
    private final List<Lotto> tickets = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;

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
            tickets.add(new Lotto(numbers));
            System.out.println(numbers);
        }
    }

    public void inputWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        this.winningNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public void inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        this.bonusNumber = Integer.parseInt(input);
    }

    public void printResult(){
        System.out.println();
        System.out.println("");
    }

}
