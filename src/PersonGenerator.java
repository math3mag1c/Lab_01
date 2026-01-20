import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.CREATE;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        boolean done = false;
        ArrayList<Person> people = new ArrayList<>();
        do {
            String dataEntry = "";
            String ID = SafeInput.getNonZeroLenString(new Scanner(System.in), "Please input your ID");
            String firstName = SafeInput.getNonZeroLenString(new Scanner(System.in), "Please input your first name");
            String lastName = SafeInput.getNonZeroLenString(new Scanner(System.in), "Please input your last name");
            String title = SafeInput.getNonZeroLenString(new Scanner(System.in), "Please input your title");
            int YOB = SafeInput.getRangedInt(new Scanner(System.in), "Please input your birth year", 1000, 9999);
            Person person = new Person(ID, firstName, lastName, title, YOB);
            people.add(person);
            done = SafeInput.getYNConfirm((new Scanner(System.in)), "Are you done inputting data? Please enter Y/y for yes and n/N for no");
        } while (!done);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (Person line: people) {
                String newLine = line.toCSV();
                writer.write(newLine);
                writer.newLine();
            }
            writer.close();
            System.out.println("Your file has been written!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}