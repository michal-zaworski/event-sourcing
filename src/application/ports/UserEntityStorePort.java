package application.ports;

import domain.Event;
import domain.User;

import java.util.List;

public interface UserEntityStorePort {
    void consumeEvent(Event event);
    List<User> getUsers();
}
