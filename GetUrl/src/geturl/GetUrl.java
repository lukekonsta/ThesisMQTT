/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geturl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author user
 */
public class GetUrl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, JSONException {
        // TODO code application logic here
        URL u = new URL("http://178.62.245.17/air/airquality.php");
        URLConnection c = u.openConnection();
        InputStream r = c.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(r));
        for (String line; (line = reader.readLine()) != null;) {
            System.out.println(line);
        }

        String out1 = new Scanner(new URL("https://www.airquality.dli.mlsi.gov.cy/air/airquality.php").openStream(), "UTF-8").useDelimiter("\\A").next();
        //System.out.println(out1);
        JSONObject jsonObject = XML.toJSONObject(out1);
        //System.out.println(jsonObject);
        JSONObject first = jsonObject.getJSONObject("air_quality");
        JSONObject second = first.getJSONObject("stations");
        //System.out.println(second);
        JSONArray third = second.getJSONArray("station");
        System.out.println(third);
        for (int i = 0; i < 5; i++) {

            JSONObject hey = third.getJSONObject(i);
            System.out.println(hey);

        }

    }

}
