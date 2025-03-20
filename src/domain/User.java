package domain;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String group;

    @Override
    public String toString() {
        return String.format(
                "User ( Id: %d,\tFirst name: %s,\tLast name: %s,\t Email: %s,\tGroup: %s",
                id, firstName, lastName, email, group);
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
