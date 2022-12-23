package designPatterns.observer.approach1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EventPublisher {
    
    Map<String, List<EventListener>> listeners = new HashMap<>();

    EventPublisher(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    void subscribe(String eventType, EventListener listener) {
        final var user = listeners.get(eventType);
        user.add(listener);
    }

    void unsubsribe(String eventType, EventListener eventListener) {
        final var user = listeners.get(eventType);
        user.remove(eventListener);
    }

    void notify(String eventType, File file) {
        final var users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}
