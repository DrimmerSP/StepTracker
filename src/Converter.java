public class Converter {
 final static double kiloSteps = 0.75;
    final static int caloriesSteps = 50;

    public static double getKilometers(int steps) {
        return steps * kiloSteps / 1000;
    }

    public static int getCalories(int steps) {
        return steps * caloriesSteps / 1000;
 }
}
