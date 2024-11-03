package lotto;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final int UNIT_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int REQUIRED_NUMBERS = 6;
    private Set<Integer> winningNumbers = new HashSet<>();

    public void inputamount(String amount) {
        validateNumeric(amount);
        int numericAmount = Integer.parseInt(amount);
        validatePositive(numericAmount);
        validateUnitPrice(numericAmount);
    }

    private void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 0보다 커야 합니다.");
        }
    }

    private void validateUnitPrice(int amount) {
        if (amount % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1,000원 단위여야 합니다.");
        }
    }

    public void inputWinning(String winning) {
        String[] numbers = winning.split(",");
        validateNumberCount(numbers);

        winningNumbers.clear();
        for (String number : numbers) {
            int num = validateAndParseNumber(number.trim());
            if (!winningNumbers.add(num)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
            }
        }
    }

    public void inputBonus(String bonus) {
        int bonusNumber = validateAndParseNumber(bonus.trim());
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private int validateAndParseNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(
                        String.format("[ERROR] 로또 번호는 %d에서 %d 사이의 숫자여야 합니다.",
                                MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                );
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validateNumberCount(String[] numbers) {
        if (numbers.length != REQUIRED_NUMBERS) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 로또 번호는 %d개여야 합니다.", REQUIRED_NUMBERS)
            );
        }
    }
}
