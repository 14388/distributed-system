package readfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import readfile.advertising;

public class readcsvAd {
	public static List<advertising> readData(String fileName) {
        List<advertising> advertisings = new ArrayList<advertising>();

        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                StringTokenizer tokens = new StringTokenizer(data, ",");

                // get data 
                double tv = Double.parseDouble(tokens.nextToken());
                double radio = Double.parseDouble(tokens.nextToken());
                double newspaper = Double.parseDouble(tokens.nextToken());
                double sales = Double.parseDouble(tokens.nextToken());
                
                // create an employee and add to the list
                advertisings.add(new advertising(tv,radio,newspaper,sales));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return advertisings;
    }

    public static void writeData(String fileName, List<advertising> advertisings) {
        try {
            FileWriter writer = new FileWriter(fileName);

            // save data
            for (advertising advertising : advertisings) {
                double tv = advertising.getTV();
                double radio = advertising.getRadio();
                double newspaper = advertising.getNewspaper();
                double sales = advertising.getSales();
                writer.write(tv + "," + radio + "," + newspaper + "," +sales+ "\n");
            }
            writer.close();
            System.out.println("Successfully wrote to the fileeee.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
