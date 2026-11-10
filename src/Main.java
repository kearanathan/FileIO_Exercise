//https://github.com/kearanathan/FileIO_Exercise.git
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Scenario: user will provide input from the keyboard and the data will
        // be stored in objects and finally data will be stored in the file

        // Using scanner and BufferedWriter objects

        Scanner scn = new Scanner(System.in);

//        String name = scn.next();
//        System.out.println("Name is: " + name);
//
//        double gpa = scn.nextDouble();
//        System.out.println("GPA is: " + gpa);

        // Take input for 5 students name and gpa
        Student[] info = new Student[5];

        int i;
        String name;
        double gpa;
        Student s;
        for (i = 0; i < 5; i++) {
            name = scn.next();
            gpa = scn.nextDouble();


            s = new Student(name, gpa);
            info[i] = s;
        }
        // Check the array
        for (i = 0; i < 5; i++) {
            System.out.println(info[i].getName());
            System.out.println(info[i].getGpa());
        }

        File f = new File("student.txt");

        try{

        if (f.createNewFile()) {
            System.out.println("File created");
        } else {
            System.out.println("File exists!");
        }

        // FileWriter or BufferedWriter?
        FileWriter fw = new FileWriter(f);
        for (i = 0; i < 5; i++) {
            fw.write(info[i].getName());
            fw.write(" ");
            fw.write(String.valueOf(info[i].getGpa()));
            fw.write("\n");
        }
        fw.close();


    } catch (IOException e) {
        System.out.println("Exception message: " + e.getMessage());
    }

    }
}