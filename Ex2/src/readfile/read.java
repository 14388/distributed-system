package readfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class read {
  public static void main(String[] args) throws IOException {
    try {
      File file = new File("filename.txt");
      Scanner myReader = new Scanner(file);
      FileWriter myWriter = new FileWriter("filename1.txt");
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        myWriter.write(data);
        System.out.println(data);
      }
      myReader.close();
      myWriter.close();
     
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}