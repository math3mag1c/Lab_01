import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                System.out.printf("%-10s %-13s %-13s %-8s %-4s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("====================================================");

                ArrayList<Person> records = new ArrayList<>();
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] recer = line.split(",");
                    Person person = new Person(recer[0], recer[1], recer[2], recer[3], Integer.valueOf(recer[4]));
                    records.add(person);
                }

                reader.close();

                for (Person row : records) {
                    System.out.printf("%-10s %-13s %-13s %-8s %-4s%n",
                            row.getID(), row.getFirstName(), row.getLastName(), row.getTitle(), row.getYOB());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("I/O Error!");
        }
    }
}