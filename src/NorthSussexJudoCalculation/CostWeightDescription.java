package NorthSussexJudoCalculation;

public class CostWeightDescription extends  AthleteInfo {
    public static final double BEGINNER_COST = 25.00;
    public static final double INTERMEDIATE_COST = 30.00;
    public static final double ELITE_COST = 35.00;
    public static final double PRIVATE_TUITION_PER_HOUR = 9.00;
    public static final double COMPETITION_COST_PEROne = 22.00;
    public static final double LIGHT_HEAVYWEIGHT = 100;
    public static final double MIDDLEWEIGHT = 90;
    public static final double LIGHT_MIDDLEWEIGHT = 81;
    public static final double LIGHTWEIGHT = 73;
    public static final double FLYWEIGHT = 66;

    public static void Weight_Comparing(double athleteWeight, double chooseWeight) {
        if (chooseWeight == FLYWEIGHT) {
            if (athleteWeight == chooseWeight)
                System.out.println("You FlyWeight!");
            else if (athleteWeight < chooseWeight) {
                double com = chooseWeight - athleteWeight;
                System.out.println("You need to gain " + com + "kg to get the FlyWeight");
            }
            else if (athleteWeight > chooseWeight){
                double com = athleteWeight-chooseWeight;
                System.out.println("You need to reduce "+ com + "kg to get FlyWeight");
            }
        }
        else if (chooseWeight == LIGHTWEIGHT) {
            if (athleteWeight == chooseWeight)
                System.out.println("You are Light Weight!");
            else if (athleteWeight < chooseWeight) {
                double com = chooseWeight - athleteWeight;
                System.out.println("You need to gain " + com + "kg to get the LightWeight.");
            }
            else if (athleteWeight>chooseWeight){
                double com = athleteWeight - chooseWeight;
                System.out.println("You need to loose "+ com + "kg to get LightWeight.");
            }

        } else if (chooseWeight == LIGHT_MIDDLEWEIGHT) {
            if (athleteWeight == chooseWeight)
                System.out.println("You are Light Middle Weight!");
            else if (athleteWeight < chooseWeight) {
                double com = chooseWeight - athleteWeight;
                System.out.println("You need to gain " + com + "kg to get the Light Middle Weight");
            }
            else if (athleteWeight > chooseWeight) {
                double com = athleteWeight - chooseWeight;
                System.out.println("You need to loose " + com + "kg to get the Light Middle Weight.");
            }
        } else if (chooseWeight == MIDDLEWEIGHT) {
            if (athleteWeight == chooseWeight)
                System.out.println("You are Middle Weight!");
            else if (athleteWeight < chooseWeight) {
                double com = chooseWeight - athleteWeight;
                System.out.println("You need to gain " + com + "kg to get the Middle Weight");
            }
            else if (athleteWeight > chooseWeight) {
                double com = athleteWeight - chooseWeight;
                System.out.println("You need to loose " + com + "kg to get the Middle Weight");
            }

        } else if (chooseWeight== LIGHT_HEAVYWEIGHT) {
            if (athleteWeight == chooseWeight)
                System.out.println("You are Light Heavy Weight!");
            else if (athleteWeight < chooseWeight) {
                double com = chooseWeight - athleteWeight;
                System.out.println("You need to gain " + com + "kg to get the Light Heavy Weight");
            }
            else if (athleteWeight > chooseWeight) {
                double com = athleteWeight - chooseWeight;
                System.out.println("You need to loose " + com + "kg to get the Light Heavy Weight");

            }

        }
        else if (chooseWeight > LIGHT_HEAVYWEIGHT) {
            if (athleteWeight > LIGHT_HEAVYWEIGHT)
                System.out.println("You are Heavy Weight!");
            else if (athleteWeight < chooseWeight) {
                double com = chooseWeight - athleteWeight;
                System.out.println("You need to gain " + com + "kg to get the Heavy Weight");
            }
        }

    }
}
