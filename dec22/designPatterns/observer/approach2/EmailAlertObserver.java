package designPatterns.observer.approach2;

class EmailAlertObserver implements AlertObserver {

    String email;

    EmailAlertObserver(String email) {
        this.email = email;
    }

    @Override
    public void update() {
        
        sendEmail(email);
    }

    private void sendEmail(String email) {

        String msg = String.format("Email sent to %s", email);
        System.out.println(msg);
    }
    
}
