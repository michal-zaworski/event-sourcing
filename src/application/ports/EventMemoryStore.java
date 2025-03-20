package application.ports;

import domain.Event;

import java.util.ArrayList;
import java.util.List;

public class EventMemoryStore implements EventStorePort {

    private final List<Event> events = new ArrayList<>();

    @Override
    public void emitEvent(Event event) {
        events.add(event);
    }

    public List<Event> getEvents() {
        return events;
    }
}
