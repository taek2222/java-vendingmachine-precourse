package vendingmachine.view;

import static vendingmachine.global.constant.MessageConstant.NEW_LINE;

import java.util.List;
import vendingmachine.domain.dto.AmountHeldResponse;
import vendingmachine.domain.dto.CoinResponse;

public class OutputView {

    public void printAmountHeld(AmountHeldResponse response) {
        List<CoinResponse> coinResponses = response.getAmountHeld();

        System.out.println();
        for (CoinResponse coinResponse : coinResponses) {
            System.out.printf("%d원 - %d개",
                    coinResponse.getCoin(),
                    coinResponse.getQuantity()
            );
            System.out.println();
        }
    }

    public void printInputAmount(int amount) {
        System.out.printf(NEW_LINE.get() + "투입 금액: %d", amount);
        System.out.printf(NEW_LINE.get());
    }
}
