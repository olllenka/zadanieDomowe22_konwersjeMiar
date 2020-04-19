import static java.lang.Double.parseDouble;

public class MetricConversion {

    private double metre;
    private double centimetre;
    private double millimetre;

    public MetricConversion(String metreString, String centimetreString, String millimetreString) {
        if(!metreString.isEmpty()) {
            this.metre = parseDouble(metreString);
            this.centimetre = metre * 100;
            this.millimetre = metre * 1000;
        }
        else if(!centimetreString.isEmpty()){
            this.centimetre = parseDouble(centimetreString);
            this.metre = centimetre/100;
            this.millimetre = centimetre*10;
        }
        else if(!millimetreString.isEmpty()){
            this.millimetre = parseDouble(millimetreString);
            this.centimetre = millimetre/10;
            this.metre = millimetre/1000;
        }
        else{
            this.metre = 0;
            this.centimetre = 0;
            this.millimetre = 0;
        }
    }

    public double getMetre() {
        return metre;
    }

    public double getCentimetre() {
        return centimetre;
    }

    public double getMillimetre() {
        return millimetre;
    }
}
