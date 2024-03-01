import java.util.ArrayList;
import java.util.Scanner;

// This is the main class to test the RegistrationPortal class
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input number of threads
        System.out.println("Enter the number of threads: ");
        int threadCount = scanner.nextInt();
        scanner.nextLine();
        // Input the number of students to be registered in each thread
        ArrayList<Integer> studentCount = new ArrayList<Integer>();
        for (int i = 0; i < threadCount; i++) {
            System.out.println("Enter the number of students registering in thread " + i + " : ");
            studentCount.add(scanner.nextInt());
            scanner.nextLine();
        }
        scanner.close();

        // Total number of students to be registered
        int totalStudents = 0;
        for (int count : studentCount) {
            totalStudents += count;
        }
        System.err.println("Total number of students to be registered: " + totalStudents);

        // Create a new instance of RegistrationPortal
        RegistrationPortal registrationPortal = RegistrationPortal.getRegistrationPortal();

        // Create threads to register students
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new MyRunnable(registrationPortal, studentCount.get(i)));
            // Set the name of the thread to the thread number
            threads[i].setName(String.valueOf(i+1));
            threads[i].start();
        }

        // Wait for all threads to complete
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
