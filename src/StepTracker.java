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
        //TODO https://github.com/AndrewSukhov/java-sprint1-hw/blob/main/src/StepTracker.java
    }


}
