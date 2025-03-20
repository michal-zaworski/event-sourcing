import application.EventAndEntityService;
import domain.Event;

import java.util.List;

import static domain.Event.CREATE_USER_EVENT;
import static domain.Event.SET_USER_FIELD_EVENT;

public class Main {

    public static void main(String[] args) {
        EventAndEntityService service = new EventAndEntityService();
        createTestData().forEach(service::emitEvent);

        service.getUsers().forEach(System.out::println);
    }

    private static List<Event> createTestData() {
        return List.of(
            new Event(CREATE_USER_EVENT, 1),
            new Event(SET_USER_FIELD_EVENT, 1, "firstName", "John"),
            new Event(SET_USER_FIELD_EVENT, 1, "lastName", "Smith"),
            new Event(SET_USER_FIELD_EVENT, 1, "email", "john.smith@email.com"),
            new Event(SET_USER_FIELD_EVENT, 1, "group", "admins"),
            new Event(CREATE_USER_EVENT, 2),
            new Event(SET_USER_FIELD_EVENT, 2, "firstName", "Ann"),
            new Event(SET_USER_FIELD_EVENT, 2, "lastName", "Brown"),
            new Event(SET_USER_FIELD_EVENT, 2, "email", "ann.brown@email.com"),
            new Event(SET_USER_FIELD_EVENT, 2, "group", "owners"),
            new Event(SET_USER_FIELD_EVENT, 1, "email", "john.smith_2@email.com"),
            new Event(SET_USER_FIELD_EVENT, 2, "group", "admins")
        );
    }
}