package application;

/**
 * Berechnet das Formelrad
 *
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
    private double leistung;
    private double spannung;
    private double strom;
    private double widerstand;

    public Calculator(double leistung, double spannung, double strom, double widerstand) {
        super();
        this.leistung = leistung;
        this.spannung = spannung;
        this.strom = strom;
        this.widerstand = widerstand;
    }

    public double getLeistung() {
        return leistung;
    }

    public double getSpannung() {
        return spannung;
    }

    public double getStrom() {
        return strom;
    }

    public double getWiderstand() {
        return widerstand;
    }

    @Override
    public String toString() {
        return "Calculator [leistung=" + leistung +
                ", spannung=" + spannung +
                ", strom=" + strom +
                ", widerstand=" + widerstand + "]";
    }

    public void calculate() {
        /* Hier auf Grund der vorhanden Werte entscheiden
         * welche Methode unten aufgerufen werden muss.
         */
    }

    /* Hier die Methoden mit den Formlen hinzufügen
     */
    //Calculate P
    public double pFromUandI(double u, double i) {
        return u * i;
    }

    public double pFromRandI(double r, double i){
        double val = i * i;
        return r * val;
    }

    public double pFromUandR(double u, double r) {
        double val = u * u;
        return val / r;
    }

    //Calculate I
    public double iFromPandU(double p, double u){
        return p / u;
    }

    public double iFromUandR(double u, double r){
        return u / r;
    }

    public double iFromPandR(double p, double r){
        return Math.sqrt(p / r);
    }

    //Calculate R
    public  double rFromUandI(double u,double i){
        return u / i;
    }

    public  double rFromPandI(double p,double i){
        double val = i * i;
        return p / val;
    }

    public  double rFromPandU(double p,double u){
        double val = u * u;
        return val / p;
    }
}
