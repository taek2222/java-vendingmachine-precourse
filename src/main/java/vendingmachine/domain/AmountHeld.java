package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class AmountHeld {

    private final Map<Coin, Integer> coins;

    public AmountHeld(int amount) {
        this.coins = createRandomCoins(amount);
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
