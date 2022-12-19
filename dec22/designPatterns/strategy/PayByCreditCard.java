package designPatterns.strategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PayByCreditCard implements PayStrategy {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard creditCard;

    @Override
    public boolean pay(int payAmount) {
        if (cardIsPresent()) {
            System.out.println("Paying " + payAmount + " using Credit Card.");
            creditCard.setAmount(creditCard.getAmount() - payAmount);
            return true;
        }
        return false;
    }

    private boolean cardIsPresent() {
        return creditCard != null;
    }

    @Override
    public void collectPaymentDetails() {

        try {
            System.out.println("Enter card details");
            String number = bufferedReader.readLine();

            System.out.println("Enter expiry in mm/yy format");
            String date = bufferedReader.readLine();

            System.out.println("Enter CVV");
            String cvv = bufferedReader.readLine();

            creditCard = new CreditCard(number, date, cvv);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
