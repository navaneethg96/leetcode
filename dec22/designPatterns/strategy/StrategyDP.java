package designPatterns.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class StrategyDP {

    private static Map<Integer, Integer> price = new HashMap<>();
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PayStrategy payStrategy;
    private static Order order;
    
    static {
        price.put(1, 220);
        price.put(2, 1850);
        price.put(3, 1100);
        price.put(4, 890);
        order = new Order();
    }
    
    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost;
            String continueChoice;
            do {
                System.out.print("Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n");
                int choice = Integer.parseInt(bufferedReader.readLine());
                cost = price.get(choice);
                System.out.print("Count: ");
                int count = Integer.parseInt(bufferedReader.readLine());
                order.setTotal(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = bufferedReader.readLine();

            } while (continueChoice.equalsIgnoreCase("Y"));

            if (payStrategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Credit Card");
                String paymentMethod = bufferedReader.readLine();

                // Client creates different strategies based on input from user,
                // application configuration, etc.
                if (paymentMethod.equals("1")) {
                    payStrategy = new PayByPaypal();
                } else {
                    payStrategy = new PayByCreditCard();
                }
            }

            // Order object delegates gathering payment data to strategy object,
            // since only strategies know what data they need to process a
            // payment.
            order.processOrder(payStrategy);

            System.out.print("Pay " + order.getTotal() + " units or Continue shopping? P/C: ");
            String proceed = bufferedReader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                // Finally, strategy handles the payment.
                if (payStrategy.pay(order.getTotal())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed();
            }
        }
    }
}
