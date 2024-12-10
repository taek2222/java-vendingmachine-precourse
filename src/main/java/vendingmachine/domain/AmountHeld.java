package vendingmachine.domain;

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
        this.coins = createRandomCoins(amount);
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
                coinResponses.add(createCoinResponse(
                        entry.getKey().getAmount(),
                        divide
                ));
                continue;
            }

            coinResponses.add(createCoinResponse(
                    entry.getKey().getAmount(),
                    entry.getValue()
            ));
            coins.put(entry.getKey(), 0);
        }

        return new ChangeResponse(coinResponses);
    }

    public AmountHeldResponse createResponse() {
        List<CoinResponse> coinResponses = new ArrayList<>();
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            coinResponses.add(createCoinResponse(
                    entry.getKey().getAmount(),
                    entry.getValue()
            ));
        }
        return new AmountHeldResponse(coinResponses);
    }

    private CoinResponse createCoinResponse(int amount, int quantity) {
        return new CoinResponse(
                amount,
                quantity
        );
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
