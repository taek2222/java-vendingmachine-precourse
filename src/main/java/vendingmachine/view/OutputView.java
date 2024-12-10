package vendingmachine.view;

import static vendingmachine.global.constant.MessageConstant.NEW_LINE;
import static vendingmachine.global.constant.MessageConstant.OUTPUT_AMOUNT_HELD;
import static vendingmachine.global.constant.MessageConstant.OUTPUT_CHANGE;
import static vendingmachine.global.constant.MessageConstant.OUTPUT_COIN_AND_QUANTITY;
import static vendingmachine.global.constant.MessageConstant.OUTPUT_INPUT_AMOUNT;

import java.util.List;
import vendingmachine.domain.dto.AmountHeldResponse;
import vendingmachine.domain.dto.ChangeResponse;
import vendingmachine.domain.dto.CoinResponse;

public class OutputView {
    
    public void printChange(ChangeResponse response) {
        List<CoinResponse> responses = response.changeResponses();

        System.out.println(OUTPUT_CHANGE);
        responses.forEach(this::printCoinAndQuantity);
    }

    public void printAmountHeld(AmountHeldResponse response) {
        List<CoinResponse> coinResponses = response.amountHeld();

        System.out.println();
        System.out.println(OUTPUT_AMOUNT_HELD);
        for (CoinResponse coinResponse : coinResponses) {
            printCoinAndQuantity(coinResponse);
        }
    }

    private void printCoinAndQuantity(CoinResponse coinResponse) {
        System.out.printf(OUTPUT_COIN_AND_QUANTITY.get(
                coinResponse.coin(),
                coinResponse.quantity()
                ));
        System.out.println();
    }

    public void printInputAmount(int amount) {
        System.out.printf(NEW_LINE.get() + OUTPUT_INPUT_AMOUNT.get(amount));
        System.out.printf(NEW_LINE.get());
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
