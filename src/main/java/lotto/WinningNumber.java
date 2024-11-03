package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private List<Integer> numbers;
    private int bonusNumber;
    InputValidator validator = new InputValidator();

    public void input() {
        inputWinningNumbers();
        inputBonusNumber();
    }

    private void inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winning = Console.readLine();
        validator.inputWinning(winning);
        numbers = parseNumbers(winning);
    }

    private void inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        validator.inputBonus(bonus);
        bonusNumber = Integer.parseInt(bonus);
    }

    private List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : input.split(",")) {
            numbers.add(Integer.parseInt(numberStr.trim()));
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
