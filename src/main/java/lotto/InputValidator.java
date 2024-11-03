package lotto;

public class InputValidator {
    private static final int UNIT_PRICE = 1000;

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
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력 가능합니다.");
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
    }

    public void inputBonus(String bonus) {
    }
}
