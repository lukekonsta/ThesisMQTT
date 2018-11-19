/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timestamp;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author user
 */
public class TimeStamp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DecimalFormat df2 = new DecimalFormat("0.0");
        double min = 10.00;
        double max = 20.10;
        double rand = new Random().nextDouble();
        String result = df2.format(min + (rand * (max - min))) + "0";
        System.out.println(result);//Create a random number with two decimals

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -4);
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formatted = format1.format(calendar.getTime());
        System.out.println(formatted);

        Float floatValue = 333333.645535f;
        String format = String.format("%.2f", floatValue);
        System.out.println(format);
        // TODO code application logic here
    }

}
