package readfile;

import java.util.Random;


public class employee {
    private String name;
    private double salary;

    public employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + "_" + salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
