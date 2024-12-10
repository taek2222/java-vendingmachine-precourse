package vendingmachine.domain.dto;

import java.util.Collections;
import java.util.List;

public class ChangeResponse {

    private final List<CoinResponse> changeResponses;

    public ChangeResponse(List<CoinResponse> coinResponses) {
        this.changeResponses = coinResponses;
    }

    public List<CoinResponse> getChangeResponses() {
        return Collections.unmodifiableList(changeResponses);
    }
}
