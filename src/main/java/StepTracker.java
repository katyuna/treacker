import java.util.HashMap;

public class StepTracker {

    private static int targetNumberOfStepsPerDay = 10000;

    public static void setSteps(int month, int day, int steps){
        if(month>0 && month<12 && day>0 && day<31 && steps>0){
            System.out.println("Выполняется сохранение шагов");
        }else {
            System.out.println("Вы ввели некорректные данные! Введите корректные данные.");
        }
    }

    public void createMonthData(){
        HashMap<Integer, MonthData> monthData= new HashMap<Integer, MonthData>();
        for (int i = 0; i<12; i++){
            monthData.put (i, new MonthData());
        }
   }

    public static int getTargetNumberOfStepsPerDay() {
        return targetNumberOfStepsPerDay;
    }

    public static void setTargetNumberOfStepsPerDay(int targetNumberOfStepsPerDay) {
        StepTracker.targetNumberOfStepsPerDay = targetNumberOfStepsPerDay;
    }
}
