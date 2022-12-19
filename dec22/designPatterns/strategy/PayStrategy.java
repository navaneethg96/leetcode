package designPatterns.strategy;

/**
 * Common Interface for all stretegies
 */
public interface PayStrategy {

    boolean pay(int payAmount);

    void collectPaymentDetails();
    
}
