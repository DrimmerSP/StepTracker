public class Converter {
 final static double kiloSteps = 0.75;
 final static double caloriesSteps = 50;

 static void convert(int steps){
     System.out.println("Пройденная дистанция(в километрах): " + (steps * kiloSteps / 1000));
     System.out.println("Количество сгоревших килокалорий: " + (steps * caloriesSteps / 1000));
 }
}
