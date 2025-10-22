import java.util.*;

public class StudentManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        // Create sample students
        Student alice = new Student(101, "Alice", 3.5, true, Department.CSE);
        Student bob   = new Student(102, "Bob",   3.5, false, Department.EEE);
        Student carol = new Student(103, "Carol", 4.0, true, Department.MECH);

        // Using varargs to add multiple students
        Utils.addMultipleStudents(students, alice, bob, carol);

        // Calculate aggregate marks using varargs
        double agg = Utils.calculateAggregateMarks("Alice", 85.0, 90.0, 88.0);

        // Determine grade from marks
        Grade grade = Grade.fromMarks(85.0);
        System.out.println("Grade for 85 marks: " + grade + " (point=" + grade.getPoint() + ")");

        // Compare CGPA between Alice and Bob (demonstrates == vs equals)
        Utils.compareCGPA(alice, bob);

        // Enum and switch example on department
        System.out.println("Department info for Carol:");
        switch (carol.getDept()) {
            case CSE:
                System.out.println("CSE Dept HOD: " + carol.getDept().getHodName());
                break;
            case EEE:
                System.out.println("EEE Dept HOD: " + carol.getDept().getHodName());
                break;
            case MECH:
                System.out.println("MECH Dept HOD: " + carol.getDept().getHodName());
                break;
        }

        // Reflection: list fields and methods of Student object
        System.out.println("\nReflection on Student object:");
        Utils.printObjectDetails(alice);

        sc.close();
    }
}
