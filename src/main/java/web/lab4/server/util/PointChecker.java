package web.lab4.server.util;
public class PointChecker {
    public static boolean isPointIsnideArea(double x, double y, double r) {
        return isPointInsideTriangle(x, y, r) || isPointInsideRectangle(x, y, r) || isPointInsideCircle(x, y, r);
    }

    private static boolean isPointInsideTriangle(double x, double y, double r) {
        boolean isXInRange = (-r <= x) && (x <= 0);
        boolean isYInRange = (0 <= y) && (y <= r);
        boolean isFormula = (-x + y) <= r;

        return isXInRange && isYInRange && isFormula;
    }

    private static boolean isPointInsideRectangle(double x, double y, double r) {
        boolean isXInRange = (0 <= x) && (x <= r);
        boolean isYInRange = (-r <= y) && (y <= 0);

        return isXInRange && isYInRange;
    }

    private static boolean isPointInsideCircle(double x, double y, double r) {
        boolean isXInRange = (-r <= x) && (x <= 0);
        boolean isYInRange = (-r <= y) && (y <= 0);
        boolean isFormula = (x * x + y * y) <= r * r;

        return isXInRange && isYInRange && isFormula;
    }
}
