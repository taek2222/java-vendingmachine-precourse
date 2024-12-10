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
        AmountHeld amountHeld = generateAmountHeld();
        displayAmountHeld(amountHeld);

        VendingMachine machine = generateVendingMachine();

        processPurchases(machine);
        displayChange(amountHeld, machine);
    }

    private AmountHeld generateAmountHeld() {
        int inputAmountHeld = inputView.readAmountHeld();
        return new AmountHeld(inputAmountHeld);
    }

    private void displayAmountHeld(AmountHeld amountHeld) {
        AmountHeldResponse response = amountHeld.createResponse();
        outputView.printAmountHeld(response);
    }

    private VendingMachine generateVendingMachine() {
        String inputProducts = inputView.readProductsInfo();
        List<Product> products = ProductParser.parseProducts(inputProducts);

        int inputAmount = inputView.readInputAmount();
        return new VendingMachine(products, inputAmount);
    }

    private void processPurchases(VendingMachine machine) {
        while (true) {
            outputView.printInputAmount(machine.getInputAmount());

            if (!machine.isPossiblePurchase()) {
                break;
            }
            processPurchase(machine);
        }
    }

    private void processPurchase(VendingMachine machine) {
        String purchaseProductName = inputView.readPurchaseProductName();
        Product product = machine.findProductByName(purchaseProductName);
        machine.purchaseProduct(product);
    }

    private void displayChange(AmountHeld amountHeld, VendingMachine machine) {
        ChangeResponse responses = amountHeld.getChange(machine.getInputAmount());
        outputView.printChange(responses);
    }
}
