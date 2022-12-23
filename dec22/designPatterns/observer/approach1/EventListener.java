package designPatterns.observer.approach1;

import java.io.File;

public interface EventListener {
    
    void update(String message, File file);
}
