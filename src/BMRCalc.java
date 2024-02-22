public class BMRCalc {


    public double calcBMRFemale(int weight, int height, int age, double actMod) {

        //double actMod = actModCalc(activity);

        return actMod*(655 + (4.3*weight) + 4.7*(height-age));

    }

    public double calcBMRMale(int weight, int height, int age, double actMod){

        //double actMod = actModCalc(activity);

        return actMod*(66 + (6.3*weight) + (12.9*height) - (6.8*age));

    }


}
