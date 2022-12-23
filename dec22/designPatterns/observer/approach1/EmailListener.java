package designPatterns.observer.approach1;

import java.io.File;

class EmailListener implements EventListener {

    private String email;

    EmailListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        String message = "Email to %s: Someone has performed %s oepration with the following file: %s";
        String emailNotification = String.format(message, email, eventType, file.getName());
        System.out.println(emailNotification);
        
    }
    
}
