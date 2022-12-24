package designPatterns.observer.approach2;

class Store {
    
    public static void main(String[] args) {
        
        // iPhone stock observers - Set 1

        StocksObservable iphoneObservable = new IPhoneObservable();

        AlertObserver observer1 = new EmailAlertObserver("abc@gmail.com");
        AlertObserver observer2 = new EmailAlertObserver("xyz@gmail.com");
        AlertObserver observer3 = new MobileAlertObserver("abc_123");

        iphoneObservable.subscribe(observer1);
        iphoneObservable.subscribe(observer2);
        iphoneObservable.subscribe(observer3);

        iphoneObservable.setStockCount(10);


        // iPhone stock observers - Set 2

        StocksObservable newIphoneObservable = new IPhoneObservable();

        AlertObserver observer4 = new EmailAlertObserver("navaneeth@gmail.com");
        AlertObserver observer5 = new EmailAlertObserver("vinod@gmail.com");
        AlertObserver observer6 = new MobileAlertObserver("nava555");

        newIphoneObservable.subscribe(observer4);
        newIphoneObservable.subscribe(observer5);
        newIphoneObservable.subscribe(observer6);

        newIphoneObservable.setStockCount(0);
        newIphoneObservable.setStockCount(20);
        newIphoneObservable.setStockCount(10);


        // nexus phone stock observers - Set 1

        StocksObservable nexusPhoneObservable = new NexusObservable();

        AlertObserver observer7 = new EmailAlertObserver("ram@gmail.com");
        AlertObserver observer8 = new MobileAlertObserver("sita123");
        AlertObserver observer9 = new MobileAlertObserver("raavan777");

        nexusPhoneObservable.subscribe(observer7);
        nexusPhoneObservable.subscribe(observer8);
        nexusPhoneObservable.subscribe(observer9);

        nexusPhoneObservable.setStockCount(0);
        nexusPhoneObservable.setStockCount(50);

    }

}
