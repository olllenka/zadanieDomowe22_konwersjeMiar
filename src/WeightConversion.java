import static java.lang.Double.parseDouble;

public class WeightConversion {

    private double kilogram;
    private double gram;
    private double milligram;

    public WeightConversion(String kilogramString, String gramString, String milligramString) {
        if(!kilogramString.isEmpty()) {
            this.kilogram = parseDouble(kilogramString);
            this.gram = kilogram * 1000;
            this.milligram = kilogram * 1000000;
        }
        else if(!gramString.isEmpty()){
            this.gram = parseDouble(gramString);
            this.kilogram = gram /1000;
            this.milligram = gram *1000;
        }
        else if(!milligramString.isEmpty()){
            this.milligram = parseDouble(milligramString);
            this.gram = milligram /1000;
            this.kilogram = milligram /1000000;
        }
        else{
            this.kilogram = 0;
            this.gram = 0;
            this.milligram = 0;
        }
    }

    public double getKilogram() {
        return kilogram;
    }

    public double getGram() {
        return gram;
    }

    public double getMilligram() {
        return milligram;
    }
}
