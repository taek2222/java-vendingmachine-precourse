package vendingmachine.domain;

import static vendingmachine.global.validation.AmountValidator.validateMultipleOfTen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import vendingmachine.domain.dto.AmountHeldResponse;
import vendingmachine.domain.dto.CoinResponse;

public class AmountHeld {

    private final Map<Coin, Integer> coins;

    public AmountHeld(int amount) {
        validateMultipleOfTen(amount);
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
        Map<Coin, Integer> coins = new TreeMap<>();

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
