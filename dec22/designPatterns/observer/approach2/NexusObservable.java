package designPatterns.observer.approach2;

import java.util.ArrayList;
import java.util.List;

class NexusObservable implements StocksObservable {

    List<AlertObserver> listeners;
    int stockCount;

    NexusObservable() {
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
    public void setStockCount(int newStocksCount) {
        
        if (stockCount == 0) {
            notifySubscribers();
        }
        stockCount += newStocksCount;
        System.out.println(String.format("Current total nexus stock count is: %s",stockCount));
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
    
}
