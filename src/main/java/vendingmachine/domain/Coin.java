package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.global.util.RandomUtil;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getDivideByAmount(int amount) {
        return amount / this.amount;
    }

    public static Coin generateRandomCoin(int amount) {
        List<Coin> coins = Arrays.stream(values())
                .filter(coin -> coin.amount <= amount)
                .collect(Collectors.toList());

        int randomIndex = RandomUtil.generateListIndexRandomNumber(coins.size());
        return coins.get(randomIndex);
    }

    public int getAmount() {
        return amount;
    }
}
