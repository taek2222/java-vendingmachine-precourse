package vendingmachine.view;

import static vendingmachine.global.constant.MessageConstant.NEW_LINE;

import java.util.List;
import vendingmachine.domain.dto.AmountHeldResponse;
import vendingmachine.domain.dto.ChangeResponse;
import vendingmachine.domain.dto.CoinResponse;

public class OutputView {
    
    public void printChange(ChangeResponse response) {
        List<CoinResponse> responses = response.changeResponses();

        System.out.println("잔돈");
        responses.forEach(this::printCoinAndQuantity);
    }

    public void printAmountHeld(AmountHeldResponse response) {
        List<CoinResponse> coinResponses = response.amountHeld();

        System.out.println();
        System.out.println("자판기가 보유한 동전");
        for (CoinResponse coinResponse : coinResponses) {
            printCoinAndQuantity(coinResponse);
        }
    }

    private void printCoinAndQuantity(CoinResponse coinResponse) {
        System.out.printf("%d원 - %d개",
                coinResponse.coin(),
                coinResponse.quantity()
        );
        System.out.println();
    }

    public void printInputAmount(int amount) {
        System.out.printf(NEW_LINE.get() + "투입 금액: %d", amount);
        System.out.printf(NEW_LINE.get());
    }
}
