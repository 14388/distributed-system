/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Dinh Vinh
 */
public class readcsv {

    public static List<employee> readData(String fileName) {
        List<employee> employees = new ArrayList<employee>();

        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                StringTokenizer tokens = new StringTokenizer(data, ",");

                // get data 
                String name = tokens.nextToken();
                double salary = Double.parseDouble(tokens.nextToken());

                // create an employee and add to the list
                employees.add(new employee(name, salary));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return employees;
    }

    public static void writeData(String fileName, List<employee> employees) {
        try {
            FileWriter writer = new FileWriter(fileName);

            // save data
            for (employee employee : employees) {
                String name = employee.getName();
                double salary = employee.getSalary();
                writer.write(name + "," + salary + "\n");
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<employee> list = readcsv.readData("employees.csv");
        System.out.println(list);

        readcsv.writeData("new_employees.csv", list);
    }
}