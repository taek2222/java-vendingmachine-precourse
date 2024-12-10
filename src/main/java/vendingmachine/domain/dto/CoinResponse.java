package vendingmachine.domain.dto;

public class CoinResponse {

    private final int coin;
    private final int quantity;

    public CoinResponse(int coin, int quantity) {
        this.coin = coin;
        this.quantity = quantity;
    }

    public int getCoin() {
        return coin;
    }

    public int getQuantity() {
        return quantity;
    }
}
