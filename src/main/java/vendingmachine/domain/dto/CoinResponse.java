package vendingmachine.domain.dto;

import java.util.Map;
import vendingmachine.domain.Coin;

public record CoinResponse(
        int coin,
        int quantity
) {

    public static CoinResponse createCoinResponse(Map.Entry<Coin, Integer> entry, int quantity) {
        return new CoinResponse(
                entry.getKey().getAmount(),
                quantity
        );
    }

    public static CoinResponse createCoinResponse(Map.Entry<Coin, Integer> entry) {
        return createCoinResponse(entry, entry.getValue());
    }
}
