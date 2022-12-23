package designPatterns.observer.approach1;

import java.io.File;

public class LogListener implements EventListener {

    private File log;

    LogListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        String message = "Save to log %s: Someone has performed %s operation with the following file: %s";
        String logMsg = String.format(message, log, eventType, file.getName());
        System.out.println(logMsg);
    }
    
}
