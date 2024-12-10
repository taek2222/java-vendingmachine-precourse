package vendingmachine.domain.dto;

import java.util.Collections;
import java.util.List;

public class AmountHeldResponse {

    private final List<CoinResponse> amountHeld;

    public AmountHeldResponse(List<CoinResponse> amountHeld) {
        this.amountHeld = amountHeld;
    }

    public List<CoinResponse> getAmountHeld() {
        return Collections.unmodifiableList(amountHeld);
    }
}
