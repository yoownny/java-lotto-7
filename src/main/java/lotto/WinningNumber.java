package lotto;

import camp.nextstep.edu.missionutils.Console;
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
        String input = Console.readLine();
        winningLotto = Lotto.from(input);
    }

    private void inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        bonusNumber = Lotto.parseNumber(input);

        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        Lotto.validateNumberRange(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return winningLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}