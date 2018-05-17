package tradeshift;

import static tradeshift.Triangle.classifyTriangle;
import static tradeshift.Triangle.TriangleClassification.EQUILATERAL;
import static tradeshift.Triangle.TriangleClassification.ISOSCELES;
import static tradeshift.Triangle.TriangleClassification.SCALENE;
import static org.junit.Assert.assertEquals;

import tradeshift.Triangle.TriangleClassification;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TriangleTest {

    private static final String NEGATIVE_MESSAGE = "Triangle side cannot be negative.";
    private static final String NOT_A_TRIANGLE_MESSAGE = "Input values don't configure a triangle.";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void checkTriangleIntEquilateral() {
        assertSuccess(10, 10, 10, EQUILATERAL);
        assertSuccess(7, 7, 7, EQUILATERAL);
    }

    @Test
    public void checkTriangleIntIsosceles() {
        assertSuccess(10, 10, 5, ISOSCELES);
        assertSuccess(10, 5, 10, ISOSCELES);
        assertSuccess(5, 10, 10, ISOSCELES);
    }

    @Test
    public void checkTriangleIntScalene() {
        assertSuccess(10, 7, 5, SCALENE);
        assertSuccess(7, 10, 8, SCALENE);
    }

    @Test
    public void checkTriangleIntNegativeA() {
        assertException(-10, 10, 10, IllegalStateException.class, NEGATIVE_MESSAGE);
    }

    @Test
    public void checkTriangleIntZeroA() {
        assertException(0, 10, 10, IllegalStateException.class, NEGATIVE_MESSAGE);
    }

    @Test
    public void checkTriangleIntNegativeB() {
        assertException(10, -10, 10, IllegalStateException.class, NEGATIVE_MESSAGE);
    }

    @Test
    public void checkTriangleIntZeroB() {
        assertException(10, 0, 10, IllegalStateException.class, NEGATIVE_MESSAGE);
    }

    @Test
    public void checkTriangleIntNegativeC() {
        assertException(10, 10, -10, IllegalStateException.class, NEGATIVE_MESSAGE);
    }

    @Test
    public void checkTriangleIntZeroC() {
        assertException(10, 10, 0, IllegalStateException.class, NEGATIVE_MESSAGE);
    }

    @Test
    public void checkTriangleIntWrongPerimeterA() {
        assertException(20, 10, 5, IllegalStateException.class, NOT_A_TRIANGLE_MESSAGE);
    }

    @Test
    public void checkTriangleIntWrongPerimeterB() {
        assertException(10, 15, 3, IllegalStateException.class, NOT_A_TRIANGLE_MESSAGE);
    }

    @Test
    public void checkTriangleIntWrongPerimeterC() {
        assertException(5, 5, 12, IllegalStateException.class, NOT_A_TRIANGLE_MESSAGE);
    }


    @Test
    public void checkTriangleDoubleEquilateral() {
        assertSuccess(10.78, 10.78, 10.78, EQUILATERAL);
        assertSuccess(7.996, 7.996, 7.996, EQUILATERAL);
    }

    @Test
    public void checkTriangleDoubleIsosceles() {
        assertSuccess(10.72, 10.72, 10.65, ISOSCELES);
        assertSuccess(10.72, 5.77, 10.72, ISOSCELES);
        assertSuccess(7.89, 10.43, 10.43, ISOSCELES);
    }

    @Test
    public void checkTriangleDoubleScalene() {
        assertSuccess(10.78, 7.12, 5.01, SCALENE);
        assertSuccess(7.002, 10.1, 8.12, SCALENE);
    }

    @Test
    public void checkTriangleDoubleNegativeA() {
        assertException(-10.3, 10.57, 10, IllegalStateException.class, NEGATIVE_MESSAGE);
    }

    @Test
    public void checkTriangleDoubleZeroA() {
        assertException(0, 10.1, 10.1, IllegalStateException.class, NEGATIVE_MESSAGE);
    }

    @Test
    public void checkTriangleDoubleNegativeB() {
        assertException(10.55, -10.5, 10, IllegalStateException.class, NEGATIVE_MESSAGE);
    }

    @Test
    public void checkTriangleDoubleZeroB() {
        assertException(10.4, 0, 10.4, IllegalStateException.class, NEGATIVE_MESSAGE);
    }

    @Test
    public void checkTriangleDoubleNegativeC() {
        assertException(10.34, 10.43, -10.77, IllegalStateException.class, NEGATIVE_MESSAGE);
    }

    @Test
    public void checkTriangleDoubleZeroC() {
        assertException(10.3, 10.3, 0, IllegalStateException.class, NEGATIVE_MESSAGE);
    }

    @Test
    public void checkTriangleDoubleWrongPerimeterA() {
        assertException(20.78, 10.4, 10.3, IllegalStateException.class, NOT_A_TRIANGLE_MESSAGE);
    }

    @Test
    public void checkTriangleDoubleWrongPerimeterB() {
        assertException(10.4, 15.9, 3.9, IllegalStateException.class, NOT_A_TRIANGLE_MESSAGE);
    }

    @Test
    public void checkTriangleDoubleWrongPerimeterC() {
        assertException(5.3, 5, 12.7, IllegalStateException.class, NOT_A_TRIANGLE_MESSAGE);
    }

    private void assertSuccess(int a, int b, int c, TriangleClassification type) {
        System.out.println(String.format("Testing %d, %d, %d. result: %s.", a, b, c , type));
        assertEquals(type, classifyTriangle(a, b, c));
    }

    private void assertException(int a, int b, int c, Class<? extends Throwable> exceptionClass, String message) {
        thrown.expect(exceptionClass);
        thrown.expectMessage(message);
        System.out.println(String.format("Testing %d, %d, %d. expected exception: %s.", a, b, c , exceptionClass.getSimpleName()));
        classifyTriangle(a, b, c);
    }

    private void assertSuccess(double a, double b, double c, TriangleClassification type) {
        System.out.println(String.format("Testing %f, %f, %f. result: %s.", a, b, c , type));
        assertEquals(type, classifyTriangle(a, b, c));
    }

    private void assertException(double a, double b, double c, Class<? extends Throwable> exceptionClass, String message) {
        thrown.expect(exceptionClass);
        thrown.expectMessage(message);
        System.out.println(String.format("Testing %f, %f, %f. expected exception: %s.", a, b, c , exceptionClass.getSimpleName()));
        classifyTriangle(a, b, c);
    }
}
