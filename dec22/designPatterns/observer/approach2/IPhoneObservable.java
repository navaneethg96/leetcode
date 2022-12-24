package designPatterns.observer.approach2;

import java.util.ArrayList;
import java.util.List;

class IPhoneObservable implements StocksObservable {

    List<AlertObserver> listeners;
    int stockCount;

    IPhoneObservable() {
        listeners = new ArrayList<>();
        stockCount = 0;
    }

    @Override
    public void subscribe(AlertObserver listener) {

        listeners.add(listener);
    }

    @Override
    public void unsubscribe(AlertObserver listener) {
        
        listeners.remove(listener);
    }

    @Override
    public void notifySubscribers() {
        
        for (AlertObserver listener : listeners) {
            listener.update();
        }   
    }

    @Override
    public void setStockCount(int count) {
        if (stockCount == 0) {
            notifySubscribers();
        }
        stockCount = stockCount + count;
        System.out.println(String.format("Current total iphone stock count is: %s",stockCount));
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
    
}
