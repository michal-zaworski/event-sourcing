package application.ports;

import domain.Event;

import java.util.List;

public interface EventStorePort {
    void emitEvent(Event event);
    List<Event> getEvents();
}
