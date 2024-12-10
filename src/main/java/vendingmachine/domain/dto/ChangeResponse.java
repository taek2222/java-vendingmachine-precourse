package vendingmachine.domain.dto;

import java.util.Collections;
import java.util.List;

public record ChangeResponse(
        List<CoinResponse> changeResponses
) {

    @Override
    public List<CoinResponse> changeResponses() {
        return Collections.unmodifiableList(changeResponses);
    }
}
