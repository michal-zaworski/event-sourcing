package domain;

import java.util.HashMap;
import java.util.Map;

public record Event(String eventName, Integer entityId, Map<String,String> data) {

    public final static String CREATE_USER_EVENT = "CREATE_USER";
    public final static String SET_USER_FIELD_EVENT = "SET_USER_FIELD";

    public Event(String eventName, Integer entityId) {
        this(eventName, entityId, new HashMap<>());
    }
    public Event(String eventName, Integer entityId, String property, String value) {
        this(eventName, entityId, Map.of(property, value));
    }
}
