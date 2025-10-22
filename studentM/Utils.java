import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class Utils {

    public static void compareCGPA(Student s1, Student s2) {
        System.out.println("Comparing CGPA of " + s1.getName() + " and " + s2.getName());
        double diff = s1.getCgpa() - s2.getCgpa();
        if (diff == 0.0) {
            System.out.println("CGPAs are equal numerically.");
        } else {
            System.out.println("CGPAs are different numerically.");
        }
        if (s1.getCgpa() == s2.getCgpa()) {
            System.out.println("CGPA Double objects are == (same reference).");
        } else {
            System.out.println("CGPA Double objects are != (different references).");
        }
        if (s1.getCgpa().equals(s2.getCgpa())) {
            System.out.println("CGPA values are equal via equals().");
        } else {
            System.out.println("CGPA values are different via equals().");
        }
    }

    public static void addMultipleStudents(List<Student> list, Student... students) {
        System.out.println("Adding " + students.length + " students.");
        for (Student s : students) {
            list.add(s);
            System.out.println("Added: " + s.getName());
        }
    }

    public static double calculateAggregateMarks(String studentName, Double... marks) {
        System.out.println("Calculating aggregate for " + studentName);
        double sum = 0;
        for (Double m : marks) {
            if (m != null) sum += m;
        }
        System.out.println("Total aggregate marks: " + sum);
        return sum;
    }

    public static void printObjectDetails(Object obj) {
        Class<?> cls = obj.getClass();
        System.out.println("Fields of class: " + cls.getName());
        for (Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            try {
                Object value = f.get(obj);
                System.out.println(" " + f.getName() + " (" + f.getType().getSimpleName() + ") = " + value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Methods of class: " + cls.getName());
        for (Method m : cls.getDeclaredMethods()) {
            System.out.println(" " + m.getName() + "()");
        }
    }
}
