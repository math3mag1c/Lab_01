import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {
    public static void main(String[] args) {
        boolean done = false;
        ArrayList <Product> products = new ArrayList();
        do {
            String dataEntry = "";
            String ID = SafeInput.getNonZeroLenString(new Scanner(System.in), "Please input your item's ID");
            String name = SafeInput.getNonZeroLenString(new Scanner(System.in), "Please input your item's name");
            String description = SafeInput.getNonZeroLenString(new Scanner(System.in), "Please input your item's description");
            double cost = SafeInput.getDouble(new Scanner(System.in), "Please input your item's cost");

            Product product = new Product(ID, name, description, cost);
            products.add(product);
            done = SafeInput.getYNConfirm((new Scanner(System.in)), "Are you done inputting data? Please enter Y/y for yes and n/N for no");
        } while (!done);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (Product line: products) {
                String newLine = line.toCSVRecord();
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