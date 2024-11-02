package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<Lotto> tickets = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        String[] splitNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : splitNumbers) {
            int number = Integer.parseInt(numberStr.trim());
            numbers.add(number);
        }
        this.winningNumbers = numbers;
    }

    public void inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        this.bonusNumber = Integer.parseInt(input);
    }

}
