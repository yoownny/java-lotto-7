package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
         System.out.println("구입금액을 입력해 주세요.");
         String input = Console.readLine();
         System.out.println();
         int amount = Integer.parseInt(input);
         int lottoNum = amount/1000;
         System.out.println(lottoNum + "개를 구매했습니다.");
    }
}
