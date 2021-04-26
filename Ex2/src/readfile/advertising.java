package readfile;

import java.io.Serializable;
import java.util.List;
import java.util.Random;


public class advertising implements Serializable{
    private double tv;
    private double radio;
    private double newspaper;
    private double sales;

    public advertising(double tv, double radio, double newspaper, double sales) {
        this.tv = tv;
        this.radio = radio;
        this.newspaper = newspaper;
        this.sales = sales;
    }

    @Override
    public String toString() {
        return tv + "_" + radio + "_" + newspaper + "_" + sales;
    }

    public double getTV() {
        return tv;
    }

    public double getRadio() {
        return radio;
    }
    
    public double getNewspaper() {
        return newspaper;
    }
    
    public double getSales() {
        return sales;
    }
    
    public static double getTotalSales(List<advertising> advertisings){
    	int i = 0;
    	double totalSales = 0;
    	while (i < advertisings.size()) {
    		totalSales += advertisings.get(i).getSales();
            i++;
        }
		return totalSales;
    }
}
