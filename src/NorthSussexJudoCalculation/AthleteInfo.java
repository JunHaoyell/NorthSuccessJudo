package NorthSussexJudoCalculation;

public class AthleteInfo {

    private String name;
    private double current_weight;
    private double number_of_competition;
    private double numberHour_of_pCoaching;
// create setter and getter method
    public void setName(String name) {
        this.name = name;
    }

    public void setCurrent_weight(double current_weight) {
        this.current_weight = current_weight;
    }

    public void setNumber_of_competition(double number_of_competition) {
        this.number_of_competition = number_of_competition;
    }

    public void setNumberHour_of_pCoaching(double numberHour_of_pCoaching) {
        this.numberHour_of_pCoaching = numberHour_of_pCoaching;
    }
    public String getName() {
        return name;
    }

    public double getCurrent_weight() {
        return current_weight;
    }
    public double getNumber_of_competition() {
        return number_of_competition;
    }

    public double getNumberHour_of_pCoaching() {
        return numberHour_of_pCoaching;
    }



}
