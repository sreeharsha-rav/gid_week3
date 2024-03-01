public class MyRunnable implements Runnable {
    private RegistrationPortal registrationPortal;
    private int studentCount;

    public MyRunnable(RegistrationPortal registrationPortal, int studentCount) {
        this.registrationPortal = registrationPortal;
        this.studentCount = studentCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < studentCount; i++) {
            // Create a new student
            String studentId = "id-" + Thread.currentThread().getName() + "-" + (i+1);
            String studentName = "name-" + (i+1);
            Student student = new Student(studentId, studentName);
            // Register the student
            registrationPortal.register(student);
            // Print the student details
            System.out.println("Registered Student: " + student);
        }
    }
}
