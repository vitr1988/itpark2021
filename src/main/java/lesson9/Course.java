package lesson9;

public final class Course {

    public static double CURRENT_VALUE = 75.56;

    private Course(){}

    public static void changeCourse(double newValue) {
        CURRENT_VALUE = newValue;
    }
}
