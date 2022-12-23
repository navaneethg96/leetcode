package designPatterns.observer.approach1;

import java.io.File;

public class Editor {
    
    EventPublisher eventPublisher;
    private File file;

    Editor() {
        this.eventPublisher = new EventPublisher("open", "save");
    }

    void openFile(String filePath) {
        this.file = new File(filePath);
        eventPublisher.notify("open", file);
    }

    void saveFile() throws Exception {
        if (this.file != null) {
            eventPublisher.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}
