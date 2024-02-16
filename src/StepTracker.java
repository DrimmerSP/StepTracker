import java.util.ArrayList;
import java.util.HashMap;

public class StepTracker {
    HashMap<String, ArrayList<Integer>> stepsCount;
    ArrayList<Integer> calendar;
    int stepsPerDay;
    int targetStepsCount;

    private ArrayList<Integer> initArrayList(){
        calendar = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            calendar.add(stepsPerDay);
        }
        return calendar;
    }

    StepTracker(){
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

    public void saveSteps(String month, int day, int steps){
        if (steps < 0){
            System.out.println("Количество шагов не должно быть отрицательным");
            return;
        }
        if (day < 1 || day > 30){
            System.out.println("День введён неверно");
            return;
        }
        if (stepsCount.containsKey(month)){
            stepsCount.get(month).set((day - 1), steps);   //TODO проверить (day -1)
            System.out.println("Данные сохранены");
        }else {
            System.out.println("Название месяца указано неверно");
        }
    }

    // напиши метод для вывода в консоль статистики пройденных шагов по месяцам
    public void printStatistic(String month){

    }
}
//TODO https://github.com/AndrewSukhov/java-sprint1-hw/blob/main/src/StepTracker.java