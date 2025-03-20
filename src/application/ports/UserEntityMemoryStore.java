package application.ports;

import domain.Event;
import domain.User;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserEntityMemoryStore implements UserEntityStorePort {

    private final Map<Integer, User> users = new TreeMap<>();

    @Override
    public void consumeEvent(Event event) {
        switch (event.eventName()) {
            case Event.CREATE_USER_EVENT -> {
                users.put(event.entityId(), new User(event.entityId()));
            }
            case Event.SET_USER_FIELD_EVENT -> {
                if (users.containsKey(event.entityId())) {
                    User user = users.get(event.entityId());

                    if (event.data().containsKey("firstName")) {
                        user.setFirstName(event.data().get("firstName"));
                    } else if (event.data().containsKey("lastName")) {
                        user.setLastName(event.data().get("lastName"));
                    } else if (event.data().containsKey("email")) {
                        user.setEmail(event.data().get("email"));
                    } else if (event.data().containsKey("group")) {
                        user.setGroup(event.data().get("group"));
                    }
                }
            }
        }
    }

    @Override
    public List<User> getUsers() {
        return users.values().stream().toList();
    }

}
