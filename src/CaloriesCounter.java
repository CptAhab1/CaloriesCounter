/*
Alex Habbart
0855541
2/23/24
CSC 512
Lab 3
 */

// This program will calculate how many candy bars of a given calorie value
// one must eat per day to maintain weight.


import java.util.Scanner;

public class CaloriesCounter {

    public static void main(String[] args) {

        // Intro message
        System.out.println("This program will calculate the number of 230 calorie\n" +
                "candy bars to eat to maintain your weight. \n");

        // Declaring this variable here will allow us to change the calories per candy bars later if needed
        double barCal = 230;

        // Scanner object
        Scanner scanner = new Scanner(System.in);

        // The next 3 blocks will read user input for age, height, and weight.

        System.out.print("\t [Q1] What is your age in years? ");
        int age = scanner.nextInt();

        System.out.print("\t [Q2] What is your total height in inches? ");
        int height = scanner.nextInt();

        System.out.print("\t [Q3] What is your weight in pounds? ");
        int weight = scanner.nextInt();

        // Since there's no nextChar function, we read sex as a string
        // then take the first char from that single-letter string
        System.out.print("\t [Q4] Enter 'M'(or 'm') for male or 'F'(or 'f') for female: ");
        String sexString = scanner.next();
        char sex = Character.toLowerCase(sexString.charAt(0));
        System.out.println();

        // declaring object for BMRCalc class
        BMRCalc calculation = new BMRCalc();

        // This variable tells how many calories one needs to maintain before factoring activity level
        double calToMaintain;

        switch (sex) {
            case 'm':
                calToMaintain = calculation.calcBMRMale(weight, height, age);
                break;
            case 'f':
                calToMaintain = calculation.calcBMRFemale(weight, height, age);
                break;
            default:
                // If the user inputs a sex besides m or f, program will end early
                System.out.println("This program does not have functionality for intersex people :(");
                System.out.println("Program ended.");
                System.exit(0);
        }

        // Similar to the sex variable, for activity level we take the first char of a string
        // entered by the user
        System.out.print("\t [Q5] Are you: \n");
        System.out.println("\t \t A. Sedentary");
        System.out.println("\t \t B. Somewhat active (exercise occasionally)");
        System.out.println("\t \t C. Active (exercise 3-4 days per week)");
        System.out.println("\t \t D. Highly active (exercise every day)\n");
        System.out.print("\t \t Enter A, B, C, or D: ");
        String activityString = scanner.next();
        char activity = Character.toLowerCase(activityString.charAt(0));

        // This variable will be calculated in the BMRCalc class and be multiplied with the calorie total
        // to tell how many calories one must eat in a day to maintain weight
        double actMod = calculation.actModCalc(activity);

        // We must divide the calories needed to maintain weight per day by the calories in a candy bar
        // to determine the candy bars per day needed to maintain weight.
        double barsToMaintain = 0;

        switch (sex) {
            case 'm':
                barsToMaintain = (1 / barCal) * actMod * (calculation.calcBMRMale(weight, height, age));
                break;
            case 'f':
                barsToMaintain = (1 / barCal) * actMod * (calculation.calcBMRFemale(weight, height, age));
                break;
        }

        // This will print the result
        System.out.println("\nWith those measurements, you should eat " +
                barsToMaintain +
                " candy bars per day to maintain the same weight.");

        // Exit message
        System.out.println("\nProgram ended.");

    }
}
