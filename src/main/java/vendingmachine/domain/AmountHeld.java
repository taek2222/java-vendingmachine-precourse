package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vendingmachine.domain.dto.AmountHeldResponse;
import vendingmachine.domain.dto.CoinResponse;

public class AmountHeld {

    private final Map<Coin, Integer> coins;

    public AmountHeld(int amount) {
        this.coins = createRandomCoins(amount);
    }

    public AmountHeldResponse createResponse() {
        List<CoinResponse> coinResponses = new ArrayList<>();
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            coinResponses.add(new CoinResponse(
                    entry.getKey().getAmount(),
                    entry.getValue()
            ));
        }
        return new AmountHeldResponse(coinResponses);
    }

    private Map<Coin, Integer> createRandomCoins(int amount) {
        HashMap<Coin, Integer> coins = new HashMap<>();

        while (amount != 0) {
            Coin coin = Coin.generateRandomCoin(amount);
            amount -= coin.getAmount();

            if (!coins.containsKey(coin)) {
                coins.put(coin, 0);
            }
            coins.put(coin, coins.get(coin) + 1);
        }
        return coins;
    }
}
