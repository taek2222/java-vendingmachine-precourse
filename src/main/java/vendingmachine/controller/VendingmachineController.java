package vendingmachine.controller;

import java.util.List;
import vendingmachine.domain.AmountHeld;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.dto.AmountHeldResponse;
import vendingmachine.domain.dto.ChangeResponse;
import vendingmachine.global.util.ProductParser;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingmachineController {
    private final InputView inputView;
    private final OutputView outputView;

    public VendingmachineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int inputAmountHeld = inputView.readAmountHeld();
        AmountHeld amountHeld = new AmountHeld(inputAmountHeld);
        AmountHeldResponse response = amountHeld.createResponse();

        outputView.printAmountHeld(response);

        String inputProducts = inputView.readProductsInfo();
        List<Product> products = ProductParser.parseProducts(inputProducts);

        int inputAmount = inputView.readInputAmount();
        VendingMachine machine = new VendingMachine(products, inputAmount);

        while (true) {
            outputView.printInputAmount(machine.getInputAmount());

            if (!machine.isPossiblePurchase()) {
                break;
            }

            String purchaseProductName = inputView.readPurchaseProductName();
            Product product = machine.findProductByName(purchaseProductName);
            machine.purchaseProduct(product);
        }

        ChangeResponse responses = amountHeld.getChange(machine.getInputAmount());
        outputView.printChange(responses);
    }
}
