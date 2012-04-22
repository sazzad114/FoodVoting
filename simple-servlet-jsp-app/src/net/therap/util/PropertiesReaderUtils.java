package net.therap.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 4/16/12
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
 public class PropertiesReaderUtils {


    public static Properties loadProperties(String fileName)
    {
        FileReader fr;
        BufferedReader br;
        Properties properties = new Properties();
        try {

            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine())!= null)
            {
                line = line.trim();
               if(line.equals("") || line.charAt(0) == '#')
               {
                   //do nothing...
               }
                else
               {
                  String propertiesEntry[];
                  propertiesEntry = line.split("=");
                  properties.setProperty(propertiesEntry[0].trim(),propertiesEntry[1].trim());


               }
            }

        } catch (IOException e) {
           throw new RuntimeException(e);
        }
        return properties;
    }

}
