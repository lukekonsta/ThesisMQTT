/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openweather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

/**
 *
 * @author user
 */
public class OpenWeather {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        // TODO code application logic here
        JSONObject json1 = new JSONObject(IOUtils.toString(new URL("http://api.openweathermap.org/data/2.5/weather?q=Limassol&APPID=c44fcec89a7e1121b144675c6d3b33e1"), Charset.forName("UTF-8")));//for current date
	JSONObject json2 = new JSONObject(IOUtils.toString(new URL("http://api.openweathermap.org/data/2.5/forecast?q=Limassol,cy&APPID=c44fcec89a7e1121b144675c6d3b33e1"), Charset.forName("UTF-8")));//5 day / 3 hour forecast        
        	
	System.out.print("For one day: ");
        System.out.println(json1);
        JSONArray jsonarr= json1.getJSONArray("weather");
	String address = jsonarr.getJSONObject(0).getString("description");
	System.out.println(address);
        
        JSONObject jsonarr1= json1.getJSONObject("main");
        //JSONObject ageJohn = jsonarr1.getJSONObject("temp");
        System.out.println(jsonarr1);  
        Double weather = jsonarr1.getDouble("temp");
        System.out.println(weather);
        System.out.println();
        
        
	System.out.print("For five days: ");
        System.out.println(json2);
	JSONArray jsonarr2= json2.getJSONArray("list");
        System.out.println();
        
        for(int i=0;i<jsonarr2.length();i++){
        
            JSONObject getit = jsonarr2.getJSONObject(i);
            System.out.println(getit);
            JSONArray wdes = getit.getJSONArray("weather");
            System.out.println(wdes);
            String descr = wdes.getJSONObject(0).getString("description");
            System.out.println(descr);
            JSONObject temp = getit.getJSONObject("main");
            System.out.println(temp);
            Double temperature_main = temp.getDouble("temp");
            System.out.println(temperature_main);
            System.out.println();
        }
        
        
        
        
    }
    
}
