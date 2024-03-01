import java.util.List;
import java.util.ArrayList;

// RegistrationPortal class is responsible for registering students
public class RegistrationPortal {
    List<Student> registeredStudents;
    private static RegistrationPortal registrationPortal;   // There should be only one instance of RegistrationPortal

    public RegistrationPortal() {
        this.registeredStudents = new ArrayList<Student>();
    }

    // Method to get the instance of RegistrationPortal, make sure only one instance is created
    public static synchronized RegistrationPortal getRegistrationPortal() {
        // If registrationPortal is null, create a new instance of RegistrationPortal
        if (registrationPortal == null) {
            registrationPortal = new RegistrationPortal();
        }
        return registrationPortal;
    }

    // Method to register a student
    public synchronized void register (Student student) {
        this.registeredStudents.add(student);
    }

    // Method to get the list of registered students
    public synchronized List<Student> getRegisteredStudents() {
        return this.registeredStudents;
    }
}
