import java.util.Scanner;

public class CaloriesCounter {

    public static void main(String[] args){

        System.out.println("This program will calculate the number of 230 calorie\n" +
                           "candy bars to eat to maintain your weight. \n");

        double barCal = 230;

        Scanner scanner = new Scanner(System.in);

        System.out.print("\t [Q1] What is your age in years? ");
        int age = scanner.nextInt();

        System.out.print("\t [Q2] What is your total height in inches? ");
        int height = scanner.nextInt();

        System.out.print("\t [Q3] What is your weight in pounds? ");
        int weight = scanner.nextInt();

        System.out.print("\t [Q4] Enter 'M'(or 'm') for male or 'F'(or 'f') for female: ");
        String sexString = scanner.next();
        char sex = Character.toLowerCase(sexString.charAt(0));

        System.out.print("\t [Q5] Are you: \n");
        System.out.println("\t \t A. Sedentary");
        System.out.println("\t \t B. Somewhat active (exercise occasionally)");
        System.out.println("\t \t C. Active (exercise 3-4 days per week)");
        System.out.println("\t \t D. Highly active (exercise every day)\n");
        System.out.print("\t \t Enter A, B, C, or D: ");
        String activityString = scanner.next();
        char activity = Character.toLowerCase(activityString.charAt(0));

        double actMod = 0;

        switch(activity) {
            case 'a':
                actMod = 1.2;
                break;
            case 'b':
                actMod = 1.3;
                break;
            case 'c':
                actMod = 1.4;
                break;
            case 'd':
                actMod = 1.5;
                break;
            default:
                System.out.println("Invalid entry for lifestyle.");
        }

        BMRCalc calculation = new BMRCalc();

        double barsToMaintain = 0;

        switch(sex){
            case 'm':
                barsToMaintain = (1/barCal)*(calculation.calcBMRMale(weight, height, age, actMod));
                break;
            case 'f':
                barsToMaintain = (1/barCal)*(calculation.calcBMRFemale(weight, height, age, actMod));
                break;
            default:
                System.out.println("This program does not have functionality for intersex people :(");
        }

        System.out.println("With those measurements, you should eat " +
                           barsToMaintain +
                           " candy bars per day to maintain the same weight.");




    }
}
