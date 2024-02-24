package mock.stub.different_json.user.controller;

public class User {

    private String name;

    private String location;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", age=" + age +
                '}';
    }

    public String toParseName(User user) {
        String name = this.name;
        return name;
    }
    public String toParseLocation(User user) {
        String location = this.location;
        return location;
    }
    public int toParseAge(User user) {
        int age = this.age;
        return age;
    }
}

