package tradeshift;

public class Triangle {

    public enum TriangleClassification {
        EQUILATERAL, ISOSCELES, SCALENE
    }

    public static TriangleClassification classifyTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalStateException("Triangle side cannot be negative.");
        }

        if (a == b && b == c) {
            return TriangleClassification.EQUILATERAL;
        }

        if (a >= b + c || c >= b + a || b >= a + c) {
            throw new IllegalStateException("Input values don't configure a triangle.");
        }

        if (b == c || a == b || c == a) {
            return TriangleClassification.ISOSCELES;
        }

        return TriangleClassification.SCALENE;
    }

    public static TriangleClassification classifyTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalStateException("Triangle side cannot be negative.");
        }

        if (a == b && b == c) {
            return TriangleClassification.EQUILATERAL;
        }

        if (a >= b + c || c >= b + a || b >= a + c) {
            throw new IllegalStateException("Input values don't configure a triangle.");
        }

        if (b == c || a == b || c == a) {
            return TriangleClassification.ISOSCELES;
        }

        return TriangleClassification.SCALENE;
    }
}
