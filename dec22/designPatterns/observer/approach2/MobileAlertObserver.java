package designPatterns.observer.approach2;

class MobileAlertObserver implements AlertObserver {

    String userName;

    MobileAlertObserver(String userName) {
        this.userName = userName;
    }

    @Override
    public void update() {
        
        sendMessage(userName);
    }

    private void sendMessage(String userName) {

        String msg = String.format("Message sent to the user %s", userName);
        System.out.println(msg);
    }
    
}
