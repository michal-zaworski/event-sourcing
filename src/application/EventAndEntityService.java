package application;


import application.ports.EventMemoryStore;
import application.ports.EventStorePort;
import application.ports.UserEntityMemoryStore;
import application.ports.UserEntityStorePort;
import domain.Event;
import domain.User;

import java.util.List;

public class EventAndEntityService {

    private final EventStorePort eventStore = new EventMemoryStore();
    private final UserEntityStorePort userEntityStore = new UserEntityMemoryStore();

    public void emitEvent(Event event) {
        eventStore.emitEvent(event);
        userEntityStore.consumeEvent(event);
    }

    public List<Event> getEvents() {
        return eventStore.getEvents();
    }

    public List<User> getUsers() {
        return userEntityStore.getUsers();
    }
}
