package lotto;

public enum LottoRank {
    THREE(3, 5_000, "3개 일치"),
    FOUR(4, 50_000, "4개 일치"),
    FIVE(5, 1_500_000, "5개 일치"),
    FIVEBONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    SIX(6, 2_000_000_000, "6개 일치");

    private final int matchCount;
    private final int prize;
    private final String description;

    LottoRank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static LottoRank getLottoRank(int matchCount, int prize) {
        if (matchCount == 3) {
            return THREE;
        }
        if (matchCount == 4) {
            return FOUR;
        }
        if (matchCount == 5) {
            return FIVE;
        }
        if (matchCount == 6) {
            return FIVEBONUS;
        }
        if (matchCount == 7) {
            return SIX;
        }
        return null;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

}
