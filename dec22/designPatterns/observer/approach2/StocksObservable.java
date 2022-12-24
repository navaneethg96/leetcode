package designPatterns.observer.approach2;

interface StocksObservable {

    void subscribe(AlertObserver listener);

    void unsubscribe(AlertObserver listener);

    void notifySubscribers();

    void setStockCount(int newStocksCount);

    int getStockCount();
}
