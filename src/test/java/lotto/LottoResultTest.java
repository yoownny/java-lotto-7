package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    @DisplayName("수익률 계산")
    void calculateProfitRateTest() {
        LottoResult result = new LottoResult();
        List<Lotto> tickets = new ArrayList<>();
        tickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 1장 구매 (1000원)

        WinningNumber winningNumber = new WinningNumber();
        // winningNumber 설정 로직 필요

        double profitRate = result.calculateProfitRate(tickets.size());
        assertThat(profitRate).isGreaterThanOrEqualTo(0.0);
    }
}