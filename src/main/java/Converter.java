public class Converter {

    private static int stepLength = 75;
    private static int caloriesPerStep = 50;


    public static double stepsToKm (int stepsPerMonth){
        return (((double) stepsPerMonth)*75)/100000;
    }

    public static int stepsToCl (int stepsPerMonth){
        return (stepsPerMonth*50)/1000;
    }

    public static int getStepLength() {
        return stepLength;
    }

    public static void setStepLength(int stepLength) {
        Converter.stepLength = stepLength;
    }

    public static int getCaloriesPerStep() {
        return caloriesPerStep;
    }

    public static void setCaloriesPerStep(int caloriesPerStep) {
        Converter.caloriesPerStep = caloriesPerStep;
    }
}
