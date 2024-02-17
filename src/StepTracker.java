import java.util.ArrayList;
import java.util.HashMap;

public class StepTracker {
    private HashMap<String, ArrayList<Integer>> stepsCount;
    private ArrayList<Integer> calendar;
    private int stepsPerDay;
    private int targetStepsCount;

    private ArrayList<Integer> initArrayList() {
        calendar = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            calendar.add(0);
        }
        return calendar;
    }

    StepTracker() {
        stepsCount = new HashMap<>();
        stepsPerDay = 0;
        targetStepsCount = 10000;

        stepsCount.put("Январь", initArrayList());
        stepsCount.put("Февраль", initArrayList());
        stepsCount.put("Март", initArrayList());
        stepsCount.put("Апрель", initArrayList());
        stepsCount.put("Май", initArrayList());
        stepsCount.put("Июнь", initArrayList());
        stepsCount.put("Июль", initArrayList());
        stepsCount.put("Август", initArrayList());
        stepsCount.put("Сентябрь", initArrayList());
        stepsCount.put("Октябрь", initArrayList());
        stepsCount.put("Ноябрь", initArrayList());
        stepsCount.put("Декабрь", initArrayList());
    }

    public void saveSteps(String month, int day, int steps) {
        if (steps < 0) {
            System.out.println("Количество шагов не должно быть отрицательным");
            return;
        }
        if (day < 1 || day > 30) {
            System.out.println("День введён неверно");
            return;
        }
        if (stepsCount.containsKey(month)) {
            stepsCount.get(month).set((day - 1), steps);
            System.out.println("Данные сохранены");
        } else {
            System.out.println("Название месяца указано неверно");
        }
    }

    public void printStatistic(String month) {
        int totalMonthSteps = 0;
        int maxMonthSteps = 0;
        int averageMonthSteps = 0;
        double wayDistance = 0;
        int burnCalories = 0;
        int bestSeries = 0;
        if (stepsCount.containsKey(month)) {
            for (int i = 0; i < 30; i++) {
                totalMonthSteps += stepsCount.get(month).get(i);
                if (stepsCount.get(month).get(i) > maxMonthSteps) {
                    maxMonthSteps = stepsCount.get(month).get(i);
                }
                System.out.print(", " + (i + 1) + " день: " + stepsCount.get(month).get(i));
                // вывод пройденных шагов по дням в следующем формате: 1 день: 3000, 2 день: 2000, ..., 30 день: 10000

            }
            System.out.println();
            averageMonthSteps = totalMonthSteps / 30;
            wayDistance = Converter.getKilometers(totalMonthSteps);
            burnCalories = Converter.getCalories(totalMonthSteps);
            bestSeries = getBestSeries(month);
        } else {
            System.out.println("Название месяца указано неверно");
        }
        printResult(totalMonthSteps, maxMonthSteps, averageMonthSteps, wayDistance, burnCalories, bestSeries);
    }

    private int getBestSeries(String month) {
        int bestSeries = 0;
        int currentSeries = 0;
        for (int i = 0; i < 30; i++) {
            if (stepsCount.get(month).get(i) >= targetStepsCount) {
                currentSeries++;
            } else {
                currentSeries = 0;
            }
            if (currentSeries > bestSeries) {
                bestSeries = currentSeries;
            }
        }
        return bestSeries;
    }

    private void printResult(int totalMonthSteps, int maxMonthSteps, int averageMonthSteps, double wayDistance, int burnCalories, int bestSeries) {
        System.out.println("┌───────────────────────────────────────────────—→");
        System.out.printf("├-В этом месяце общее количество шагов: %d%n", totalMonthSteps);
        System.out.printf("├-В этом месяце максимальное количество шагов: %d%n", maxMonthSteps);
        System.out.printf("├-В этом месяце среднее количество шагов: %d%n", averageMonthSteps);
        System.out.printf("├-В этом месяце пройдено: %.2f километров %n", wayDistance);
        System.out.printf("├-В этом месяце потрачено: %d килокалорий %n", burnCalories);
        System.out.printf("├-Максимальное количество дней подряд в серии: %d. (Цель: %d)  %n", bestSeries, targetStepsCount);
        System.out.println("└───────────────────────────────────────────────→");

    }

    public void changeTarget(int targetStepsCount) {
        if (targetStepsCount < 100) {
            System.out.println("Цель не может быть меньше 100 шагов(ЗЫ: ты уж постарайся ;) )");
        } else {
            this.targetStepsCount = targetStepsCount;
            System.out.println("Цель изменена");
        }
    }
}
