package application;

/**
 * Berechnet das Formelrad
 *
 * @author David Kresic und Andelo Batinic
 * @version 23.11.2021
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
        if (getLeistung() > 0 && getSpannung() > 0) {
            iFromPandU(getLeistung(), getSpannung());
            rFromPandU(getLeistung(), getSpannung());
            System.out.println("Berechnet: Strom und Widerstand von Leistung und Spannung. ");
        } else if (getStrom() > 0 && getWiderstand() > 0) {
            pFromRandI(getWiderstand(), getStrom());
            uFromRandI(getWiderstand(), getStrom());
            System.out.println("Berechnet: Leistung und Spannung von Widerstand und Strom. ");
        } else if (getLeistung() > 0 && getStrom() > 0) {
            uFromPandI(getLeistung(), getStrom());
            rFromPandI(getLeistung(), getStrom());
            System.out.println("Berechnet: Spannung und Widerstand von Leistung und Strom. ");
        } else if (getSpannung() > 0 && getWiderstand() > 0) {
            pFromUandR(getSpannung(), getWiderstand());
            iFromUandR(getSpannung(), getWiderstand());
            System.out.println("Berechnet: Leistung und Strom von Spannung und Widerstand. ");
        } else if (getLeistung() > 0 && getWiderstand() > 0) {
            uFromPandR(getLeistung(), getWiderstand());
            iFromPandR(getLeistung(), getWiderstand());
        } else if (getStrom() > 0 && getSpannung() > 0) {
            pFromUandI(getSpannung(), getStrom());
            rFromUandI(getSpannung(), getStrom());
        }
    }

    //Calculate P
    public double pFromUandI(double u, double i) {
        return u * i;
    }

    public double pFromRandI(double r, double i) {
        double val = i * i;
        return r * val;
    }

    public double pFromUandR(double u, double r) {
        double val = u * u;
        return val / r;
    }

    //Calculate I
    public double iFromPandU(double p, double u) {
        return p / u;
    }

    public double iFromUandR(double u, double r) {
        return u / r;
    }

    public double iFromPandR(double p, double r) {
        return Math.sqrt(p / r);
    }

    //Calculate R
    public double rFromUandI(double u, double i) {
        return u / i;
    }

    public double rFromPandI(double p, double i) {
        double val = i * i;
        return p / val;
    }

    public double rFromPandU(double p, double u) {
        double val = u * u;
        return val / p;
    }

    //Calculate U
    public double uFromRandI(double r, double i) {
        return r * i;
    }

    public double uFromPandI(double p, double i) {
        return p / i;
    }

    public double uFromPandR(double p, double r) {
        double val = p * r;
        return Math.sqrt(val);
    }
}
