public enum Grade {
    A(10.0), B(8.0), C(6.0), D(4.0), F(0.0);

    private final double point;

    Grade(double point) { this.point = point; }
    public double getPoint() { return point; }

    public static Grade fromMarks(double marks) {
        if (marks >= 90) return A;
        if (marks >= 75) return B;
        if (marks >= 60) return C;
        if (marks >= 50) return D;
        return F;
    }
}
