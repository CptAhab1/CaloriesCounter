// This class will handle calculations for calories needed per day to maintain weight
public class BMRCalc {

    // This function will calculate the calories per day needed for a biological female to maintain weight,
    // before accounting for activity level.
    public double calcBMRFemale(int weight, int height, int age) {

        return (655 + (4.3*weight) + 4.7*(height-age));

    }
    // This function will calculate the calories per day needed for a biological male to maintain weight,
    // before accounting for activity level.
    public double calcBMRMale(int weight, int height, int age){

        return (66 + (6.3*weight) + (12.9*height) - (6.8*age));

    }

    // This function will determine the factor we must multiply the calories per day by
    // depending on user-input for activity level
    // This includes input verification for anything besides the 4 accepted levels
    public double actModCalc(char activity){
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
                System.out.println("\nInvalid entry for lifestyle.");
                System.out.println("Program ended.");
                System.exit(0);
        }

        return actMod;
    }

}
