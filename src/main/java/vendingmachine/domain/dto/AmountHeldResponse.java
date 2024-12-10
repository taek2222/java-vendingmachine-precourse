package vendingmachine.domain.dto;

import java.util.Collections;
import java.util.List;

public record AmountHeldResponse(
        List<CoinResponse> amountHeld
) {

    @Override
    public List<CoinResponse> amountHeld() {
        return Collections.unmodifiableList(amountHeld);
    }
}
