package lotto;

import static lotto.Lotto.MAX_NUMBER;
import static lotto.Lotto.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private Lotto winningLotto;
    private int bonusNumber;

    public void input() {
        inputWinningNumbers();
        inputBonusNumber();
    }

    private void inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                winningLotto = new Lotto(parseNumbers(input));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitNumbers = input.split(",");

        for (String numberStr : splitNumbers) {
            String trimmed = numberStr.trim();
            if (!trimmed.isEmpty()) {
                try {
                    numbers.add(Integer.parseInt(trimmed));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
                }
            }
        }
        return numbers;
    }

    private void inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine().trim();
                int number;
                try {
                    number = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
                }

                if (number < MIN_NUMBER || number > MAX_NUMBER) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
                }

                if (winningLotto.contains(number)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }

                bonusNumber = number;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public List<Integer> getNumbers() {
        return winningLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}