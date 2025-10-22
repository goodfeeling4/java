import java.util.Scanner;

class Shape {
    public void area() {
        System.out.println("Display Area of Shape");
    }
}

class Circle extends Shape {
    public void area(int r) {
        System.out.println("Area of Circle: " + (3.14 * r * r));
    }
}

class Rectangle extends Shape {
    public void area(int l, int b) {
        System.out.println("Area of Rectangle: " + (l * b));
    }
}

class Triangle extends Shape {
    public static <T, U> void pair(T first, U second) {
        System.out.println("Pair: " + first + " - " + second);
    }

    public void area(int b, int h) {
        System.out.println("Area of Triangle: " + (0.5 * b * h));
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle();
        Rectangle r = new Rectangle();
        Triangle t = new Triangle();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of circle: ");
        int radius = sc.nextInt();
        System.out.print("Enter length and breadth of rectangle: ");
        int length = sc.nextInt();
        int breadth = sc.nextInt();
        System.out.print("Enter base and height of triangle: ");
        int base = sc.nextInt();
        int height = sc.nextInt();
        c.area(radius);
        r.area(length, breadth);
        t.area(base, height);
    }
}

public static boolean isPrime(long n) {
    if (n <= 1)
        return false;
    if (n <= 3)
        return true;
    if (n % 2 == 0 || n % 3 == 0)
        return false;
    long i = 5;
    // test divisors of form 6k-1 and 6k+1
    while (i * i <= n) {
        if (n % i == 0 || n % (i + 2) == 0)
            return false;
        i += 6;
    }
    return true;
}
