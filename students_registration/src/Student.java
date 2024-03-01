// This class is responsible for creating student objects
public class Student {
    // Final variables are initialized only once, at the time of declaration
    private final String id;
    private final String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
    }
}
