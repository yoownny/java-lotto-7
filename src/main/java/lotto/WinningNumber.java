package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private List<Integer> numbers;
    private int bonusNumber;

    public void input() {
        inputWinningNumbers();
        inputBonusNumber();
    }

    private void inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        numbers = parseNumbers(Console.readLine());
    }

    private void inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
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
