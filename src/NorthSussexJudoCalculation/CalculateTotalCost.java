package NorthSussexJudoCalculation;

public class CalculateTotalCost {
    // create overloading method by Polymorphism
    protected static double sum(double costPerPackage, double costPerCompetition, double costPerPrivateHour){
        double total = costPerPackage+costPerCompetition+costPerPrivateHour;
        return total;
    }

    public static double sum(double costPerPackage, double costPerPrivateHour){
        double total = costPerPackage+costPerPrivateHour;
        return total;
    }

}
