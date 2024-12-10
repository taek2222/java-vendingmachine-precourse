package vendingmachine.domain;

import static vendingmachine.domain.Coin.generateRandomCoin;
import static vendingmachine.domain.dto.CoinResponse.createCoinResponse;
import static vendingmachine.global.validation.AmountValidator.validateMultipleOfTen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import vendingmachine.domain.dto.AmountHeldResponse;
import vendingmachine.domain.dto.ChangeResponse;
import vendingmachine.domain.dto.CoinResponse;

public class AmountHeld {

    private final Map<Coin, Integer> coins;

    public AmountHeld(int amount) {
        validateMultipleOfTen(amount);
        this.coins = generateRandomCoins(amount);
    }

    public ChangeResponse getChange(int changeAmount) {
        List<CoinResponse> coinResponses = new ArrayList<>();
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            if (entry.getKey().getAmount() > changeAmount) {
                continue;
            }

            int divide = entry.getKey().getDivideByAmount(changeAmount);
            if (divide < entry.getValue()) { // 남아있는 동전이 더 클 때
                changeAmount -= divide * entry.getKey().getAmount();
                coins.put(entry.getKey(), entry.getValue() - divide);
                coinResponses.add(createCoinResponse(entry, divide));
                continue;
            }

            coinResponses.add(createCoinResponse(entry));
            coins.put(entry.getKey(), 0);
        }

        return new ChangeResponse(coinResponses);
    }

    public AmountHeldResponse createResponse() {
        List<CoinResponse> coinResponses = new ArrayList<>();
        coins.entrySet().forEach(entry ->
                coinResponses.add(createCoinResponse(entry)));

        return new AmountHeldResponse(coinResponses);
    }

    private Map<Coin, Integer> generateRandomCoins(int amount) {
        Map<Coin, Integer> coins = new TreeMap<>();

        while (amount != 0) {
            Coin coin = generateRandomCoin(amount);
            amount -= coin.getAmount();
            addRandomCoin(coins, coin);
        }
        return coins;
    }

    private void addRandomCoin(Map<Coin, Integer> coins, Coin coin) {
        if (!coins.containsKey(coin)) {
            coins.put(coin, 0);
        }
        coins.put(coin, coins.get(coin) + 1);
    }
}
