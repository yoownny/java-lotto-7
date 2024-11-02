package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int PRICE_PER_LOTTO = 1000;
    private final List<Lotto> tickets = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private Map<LottoRank, Integer> results;
    private double profit;
    private int amount;

    public void printResult() {
        results = calculateResults();
        System.out.println("\n당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.printf("%s (%,d원) - %d개\n",
                        rank.getDescription(),
                        rank.getPrize(),
                        results.get(rank));
            }
        }
        profit = calculateProfit();
        System.out.printf("총 수익률은 %.1f입니다.", profit);
    }

    private double calculateProfit() {
        double sum = 0;
        double result = 0;
        for (LottoRank rank : LottoRank.values()) {
            if (results.get(rank) != 0) {
                sum += rank.getPrize();
            }
        }
        result = sum / amount * 100;
        return result;
    }

    private Map<LottoRank, Integer> calculateResults() {
        Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, 0);
        }
        for (Lotto ticket : tickets) {
            int matchCount = countMatches(ticket);
            boolean BonusMatch = ticket.contains(bonusNumber);
            LottoRank rank = LottoRank.getLottoRank(matchCount, BonusMatch);
            results.put(rank, results.get(rank) + 1);
        }
        return results;
    }

    private int countMatches(Lotto ticket) {
        int count = 0;
        for (int number : winningNumbers) {
            if (ticket.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
