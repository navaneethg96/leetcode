package designPatterns.strategy;

/**
 * Order class. Doesn't know the concrete payment method (strategy) user has
 * picked. It uses common strategy interface to delegate collecting payment data
 * to strategy object. It can be used to save order to database.
 */
public class Order {

    private int total = 0;
    private boolean isClosed = false;

    public void processOrder(PayStrategy payStrategy) {
        // Here we could collect and store payment data from the strategy.
        payStrategy.collectPaymentDetails();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        this.isClosed = true;
    }
}
