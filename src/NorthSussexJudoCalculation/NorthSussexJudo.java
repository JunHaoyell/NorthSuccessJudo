package NorthSussexJudoCalculation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class NorthSussexJudo {

    public static int numOfAthlete;
//declare Arraylist to store the user's inputted data.
    public static ArrayList<String> athleteName = new ArrayList<>();
    public static ArrayList<Double> athleteWeight = new ArrayList<>();
    public static ArrayList<Double> hour_of_private_coaching = new ArrayList<>();
    public static ArrayList<Double> number_of_competition = new ArrayList<>();
    public static ArrayList<Double> totalCOst = new ArrayList<>();
    public static ArrayList<String> choice = new ArrayList<>();

    // object declaration
    public static CostWeightDescription obj = new CostWeightDescription();
    public static CalculateTotalCost obj2 = new CalculateTotalCost();

// Create UserInput method
    public static void userInput() {
        double weightGoal = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("How many of you want to register into our course?... ");
            numOfAthlete = input.nextInt();
            // setting the looping based on the number of user's input.
                for (int i = 1; i <= numOfAthlete; i++) {
                    Scanner input1 = new Scanner(System.in);

                    while (true) {// set the validation that only can enter the String data type
                        System.out.print("Enter your name: ");
                        String name = input1.nextLine();// request user's name


                        String regex1 = "([a-zA-z]+)(\\s[a-zA-Z]+)*";
                        Pattern pattern1 = Pattern.compile(regex1);
                        if (name.matches(regex1)) {
                            obj.setName(name); // set the value for the variable of "name" in AthleteInfo class.
                            String athName = obj.getName(); // recall the name and store in athName variable.
                            athleteName.add(athName);// add the variable into athleteName Arraylist.
                            break;
                        } else
                            System.out.println("Enter a valid name");// if the user enter invalid data, it will ask to enter agin.
                    }

                    System.out.println("The Weight Categories : \n" +
                            "1.     FLyWeight:  " + obj.FLYWEIGHT + " kg.\n" +
                            "2.     LightWeight:    " + obj.LIGHTWEIGHT + " kg.\n" +
                            "3.     LightMiddleWeight:   " + obj.LIGHT_MIDDLEWEIGHT + " kg.\n" +
                            "4.     MiddleWeight:    " + obj.MIDDLEWEIGHT + " kg.\n" +
                            "5.     LightHeavyWeight:    " + obj.LIGHT_HEAVYWEIGHT + " kg.\n" +
                            "6.     HeavyWeight:     above 100 kg.");



                    while(true) {


                        System.out.println(" Enter 1 or 2 or 3 to choose your weight goal :");
                        String goal = input1.nextLine();

                        String regex2 = "(1|2|3|4|5|6)";
                        Pattern pattern2 = Pattern.compile(regex2);

                        if (goal.matches(regex2)) {
                            if (goal.equals("1")) {
                                weightGoal += obj.FLYWEIGHT;
                            } else if (goal.equals("2")) {
                                weightGoal += obj.LIGHTWEIGHT;
                            } else if (goal.equals("3")) {
                                weightGoal += obj.LIGHT_MIDDLEWEIGHT;
                            } else if (goal.equals("4")) {
                                weightGoal += obj.MIDDLEWEIGHT;
                            } else if (goal.equals("5")) {
                                weightGoal += obj.LIGHT_HEAVYWEIGHT;
                            } else if (goal.equals("6")) {
                                weightGoal += 101;
                            }
                            break;
                        }
                        else
                            System.out.println("Please type again: ");
                    }

                    System.out.println("Enter your current Weight  : ");
                    while (true) {
                        double currentWeight = input.nextInt();// request the user's current weight
                        if (currentWeight <= 0) {
                            System.out.println("Please enter valid Weight: ");
                        } else {
                            obj.setCurrent_weight(currentWeight);//set the value for the variable of "current_weight" in AthleteInfo class.
                            double athWeight = obj.getCurrent_weight();//recall the current from this class and store in athWeight variable.
                            athleteWeight.add(athWeight);// add the variable into athleteWeight Arraylist.

                            System.out.println("Your current Weigh: " + athWeight + " kg.");
                            obj.Weight_Comparing(athWeight,weightGoal);
                            break;
                        }

                    }

                    choosingPlan();// go to Choosingplan method.

                }

        }
// create choosing plan method
    public static void choosingPlan() {
        Scanner input = new Scanner(System.in);
        // display the cost for each package.
        System.out.println("We have three packages : Beginner , Intermediate and Elite and Type package name. " + "\n Beginner (3 session per week)  -  " + CostWeightDescription.BEGINNER_COST * 4 + "$ (Monthly). ");
        System.out.println("Intermediate (3 Session Per Week) -  " + CostWeightDescription.INTERMEDIATE_COST * 4 + "$(Monthly). ");
        System.out.println("Elite (5 session Per week) -  " + CostWeightDescription.ELITE_COST * 4 + "$(Monthly). ");
        System.out.print("Please type the package name:  ");


        String regex = "(beginner|intermediate|elite)";
        Pattern pattern = Pattern.compile(regex);
        String choose;
        while (true) {
            choose = input.nextLine().toLowerCase();// request to enter package name
            if(choose.matches(regex)){

                if(choose.equals("beginner")){
                    beginner();
                    break;
                }
                // if the user input equals "beginner", will go to Beginner method
                else if(choose.equals("intermediate")) {
                    intermediate();// will go to Intermediate method
                    break;
                }
                else if (choose.equals("elite")){
                    elite();// will go to Elite method
                    break;
                }
            }
            else {
                System.out.println("Please choos again!");
            }

        }
        choice.add(choose);
    }

// create Elite method
    private static void elite() {
        System.out.println("Well! You have chosen Elite");
        System.out.println("Do you wanna have Private Coaching?\n Please Type \"Yes\" or \"No\"");
        Scanner input = new Scanner(System.in);
        double costForElite = CostWeightDescription.ELITE_COST*4;
        double choseCompetition = 0;
        double choseprivteChoaching = 0;
        double total_Cost = 0;

        String yesNo;
        String regex="(yes|no)";// set the pattern
        Pattern pattern = Pattern.compile(regex);
        while (true) { // set the validation for checking the user's input is "yes" or "no"
            yesNo = input.nextLine().toLowerCase();// get input
            if (yesNo.matches(regex)){// if the input matches the pattern
                System.out.println();
                if (yesNo.equals("yes")) {
                    System.out.println("The cost of Private coaching per hour: "+ CostWeightDescription.PRIVATE_TUITION_PER_HOUR + " $");
                    System.out.println("Alright! we accept maximum of five hours private per week for one person.\n\n Please Enter how many hours per week that you want private coaching. : ");

                    while(true) {
                        Scanner input1 = new Scanner(System.in);
                        double privateHour = input1.nextDouble();// request the user to enter the hour
                        if(privateHour<=5&&privateHour>0) {// but the hours should not greater than 5 hours and should not equal or less than zero
                            obj.setNumberHour_of_pCoaching(privateHour);
                            double hours = obj.getNumberHour_of_pCoaching();
                            hour_of_private_coaching.add(hours);
                            choseprivteChoaching += CostWeightDescription.PRIVATE_TUITION_PER_HOUR * hours*4; //calculation the cost for private coaching
                            break;
                        }
                        else{
                           System.out.println("Please Enter valid number for hour!");
                        }
                        //System.out.println(choseprivteChoaching);
                    }

                } else if (yesNo.equals("no")) {
                    double hours = 0;
                    hour_of_private_coaching.add(hours);// if the user choose "no", the value zero will store into arraylist for this athlete only
                }
                break;
            }else{
                System.out.println("Something Wrong! Type again");
                System.out.print("Please choose Yes or No only");}
        }

        System.out.print("DO you want to Participate in competition?\nPlease Tyep \"Yes\" or \"No\" : ");


        while (true){// if the input is valid, it will not ask to input again
            String YesN0 = input.nextLine().toLowerCase();
            if (YesN0.equals("yes")||YesN0.equals("no")) {// input yes/ no only
                if (YesN0.equals("yes")) {
                    System.out.print("How many competition do you want to participate in? : ");
                    Scanner input2 = new Scanner(System.in);
                    double num = input2.nextInt();//get the number of competition
                    obj.setNumber_of_competition(num);// set the user inputted number into the variable "number_of_compettion" in AthleteInfo class
                    double numberOfCompetition = obj.getNumber_of_competition();// recall these value and store in anpther variable
                    choseCompetition += CostWeightDescription.COMPETITION_COST_PEROne * numberOfCompetition;//calculation cost based on user's input
                    number_of_competition.add(numberOfCompetition);//add the number into number_of_competition Arraylist
                    //System.out.println(choseCompetition);
                } else if (YesN0.equals("no")) {
                    double numofcom = 0;
                    number_of_competition.add(numofcom);
                }
                break;
            }else {// if condition is invalid, the program will ask again
                System.out.println("Something Wrong! Type again");
                System.out.print("Please choose Yes or No only");
            }

        }

        System.out.println("Well done!");
        // Overloading from CalculateTotalCost class
        total_Cost += obj2.sum(costForElite,choseCompetition,choseprivteChoaching);
        //System.out.println(total_Cost);
        totalCOst.add(total_Cost);

    }

    // Intermediate method
    private static void intermediate() {
        System.out.println("Well! You have chosen Intermediate");
        System.out.println("Do you wanna have Private Coaching?\n Please Type \"Yes\" or \"No\"");

        Scanner input = new Scanner(System.in);
        double costForIntermediate = CostWeightDescription.INTERMEDIATE_COST*4;
        double choseCompetition = 0;//initiate the variables and give value as zero
        double choseprivteChoaching = 0;
        double total_Cost = 0;

        String yesNo;
        String regex="(yes|no)";//set the pattern regex
        Pattern pattern = Pattern.compile(regex);
        while (true){

            yesNo = input.nextLine().toLowerCase();
            if (yesNo.matches(regex)) {// if it is matched the pattern, will continue to run
                if (yesNo.equals("yes")) {
                    System.out.println("The cost of Private coaching per hour: "+ CostWeightDescription.PRIVATE_TUITION_PER_HOUR + " $");
                    System.out.println("Alright! we accept maximum of five hours private per week for one person.\n\n Please Enter how many hours per week that you want private coaching. : ");

                    while (true) {
                        Scanner input1 = new Scanner(System.in);
                        double privateHour = input1.nextDouble();
                        if(privateHour<=5&&privateHour>0) {//check the valid for privateHour
                            obj.setNumberHour_of_pCoaching(privateHour);//set the value as user's input

                            double hours = obj.getNumberHour_of_pCoaching();//recall the set value
                            hour_of_private_coaching.add(hours);// add into arraylist
                            choseprivteChoaching += CostWeightDescription.PRIVATE_TUITION_PER_HOUR * hours * 4;//calculation cost based on the user inputted hours
                            //System.out.println(choseprivteChoaching);
                            break;
                        }
                        else{// if user's inputted private hours is not valid, will ask again
                            System.out.println("Please enter valid number for hours");
                        }
                    }

                } else if (yesNo.equals("no")) {
                    double hours = 0;// if user not wants private coaching, the value will be zero
                    hour_of_private_coaching.add(hours);
                }
                break;

            }
            else {// if the user not input Yes and no, will again again until it is valid
                System.out.println("Something Wrong! Type again");
                System.out.print("Please choose Yes or No only");
            }
        }


        System.out.print("DO you want to Participate in competition?\nPlease Tyep \"Yes\" or \"No\" : ");
        while(true) {// checking valid “”yes" or "no"
            String YesN0 = input.nextLine().toLowerCase();
            if (YesN0.equals("yes") || YesN0.equals("no")) {
                if (YesN0.equals("yes")) {
                    System.out.print("How many competition do you want to participate in? : ");
                    Scanner input2 = new Scanner(System.in);
                    double num = input2.nextDouble();
                    obj.setNumber_of_competition(num);
                    double numberOfCompetition = obj.getNumber_of_competition();
                    choseCompetition += CostWeightDescription.COMPETITION_COST_PEROne * numberOfCompetition;
                    number_of_competition.add(numberOfCompetition);
                    //System.out.println(choseCompetition);
                } else if (YesN0.equals("no")) {
                    double numofcom = 0;
                    number_of_competition.add(numofcom);
                }
                break;
            } else {
                System.out.println("Something Wrong! Type again");
                System.out.print("Please choose Yes or No only");
            }
        }


        System.out.println("Well done!");
        // overloading
        total_Cost += obj2.sum(costForIntermediate,choseCompetition,choseprivteChoaching);

        //System.out.println(total_Cost);
        totalCOst.add(total_Cost);





        //Output();
    }
    // Beginner method
    private static void beginner() {
        System.out.println("Well! You have chosen Beginner package");
        System.out.println("Do you wanna have Private Coaching?\n Please Type \"Yes\" or \"No\"");

        Scanner input = new Scanner(System.in);
        double costForBeginner = CostWeightDescription.BEGINNER_COST*4;
        double choseCompetition = 0;
        double choseprivteChoaching = 0;
        double total_Cost = 0;

        String yesNo;
        String regex = "(yes|no)";
        Pattern pattern = Pattern.compile(regex);
        while (true) {
            yesNo = input.nextLine().toLowerCase();
            if (yesNo.matches(regex)) {
                if (yesNo.equals("yes")) {
                    System.out.println("The cost of Private coaching per hour: "+ CostWeightDescription.PRIVATE_TUITION_PER_HOUR + " $");
                    System.out.println("Alright! we accept maximum of five hours private per week for one person.\n\n Please Enter how many hours per week that you want private coaching. : ");

                    while(true) {
                        Scanner input1 = new Scanner(System.in);
                        double privateHour = input1.nextDouble();
                        if(privateHour<=5&&privateHour>0) {
                            obj.setNumberHour_of_pCoaching(privateHour);
                            double hours = obj.getNumberHour_of_pCoaching();
                            hour_of_private_coaching.add(hours);

                            choseprivteChoaching += CostWeightDescription.PRIVATE_TUITION_PER_HOUR * hours * 4;
                            //System.out.println(choseprivteChoaching);
                            break;
                        } else{
                            System.out.println("Please Enter valid number for hour!");
                        }
                    }

                } else if (yesNo.equals("no")) {
                    double hours = 0;
                    hour_of_private_coaching.add(hours);
                }
                break;
            } else{
                System.out.println("Something Wrong! Type again");
                System.out.print("Please choose Yes or No only");
            }

        }

                double numofcom = 0;
                number_of_competition.add(numofcom);

        System.out.println("Well done!");
        //overloading
        total_Cost+= obj2.sum(costForBeginner,choseprivteChoaching);

        //System.out.println(total_Cost);
        totalCOst.add(total_Cost);
        //Output();

    }

// out put method
    public static void outPut() {

        for (int u=0;u<=5;u++){
            System.out.print("__");
        }
        System.out.println();
    for (int i = 0; i< numOfAthlete; i++) {
        System.out.println("Name : "+ athleteName.get(i));
        System.out.println("Package name : "+ choice.get(i));
        System.out.println("Number of Competition : "+ number_of_competition.get(i) );
        System.out.println("Hours of Private Coaching : "+ hour_of_private_coaching.get(i)+" hour/hours");
        System.out.println(" Your Total cost is : " + totalCOst.get(i) + " $$");


        for (int u=0;u<=5;u++){
            System.out.print("__");
        }
        System.out.println();

    }

    }
}
