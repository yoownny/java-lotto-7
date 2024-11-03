package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(String input) {
        return new Lotto(parseNumbers(input));
    }

    private static List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitNumbers = input.split(",");

        for (String numberStr : splitNumbers) {
            String trimmed = numberStr.trim();
            if (!trimmed.isEmpty()) {
                int number = parseNumber(trimmed);
                if (numbers.contains(number)) {
                    throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
                }
                numbers.add(number);
            }
        }
        return numbers;
    }

    public static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 로또 번호는 %d에서 %d 사이의 숫자여야 합니다.",
                            MIN_NUMBER, MAX_NUMBER)
            );
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}