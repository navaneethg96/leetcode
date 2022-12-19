package designPatterns.strategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete Strategy using Paypal medium
 */
public class PayByPaypal implements PayStrategy{

    private String email;
    private String password;
    private boolean signedIn;

    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static{
        DATA_BASE.put("navaneeth123", "nava@gmail.com");
        DATA_BASE.put("user456", "user@example.com");
    }

    @Override
    public boolean pay(int payAmount) {
        if (signedIn) {
            System.out.println("Paying " + payAmount + " using PayPal.");
            return true;
        }
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIn) {
                System.out.println("Enter user email");
                email = bufferedReader.readLine();
                System.out.println("Enter password");
                password = bufferedReader.readLine();
                if (verify()) {
                    System.out.println("Data verified successfully");
                } else {
                    System.out.println("Invalid credentials");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
    
}
