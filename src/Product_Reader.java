import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Product_Reader
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select Product File");

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION)
        {
            Path file = chooser.getSelectedFile().toPath();
            ArrayList<Product> products= new ArrayList<>();

            try (BufferedReader reader = Files.newBufferedReader(file)) {

                String line;
                while ((line = reader.readLine()) != null)
                {
                    String[] parts = line.split(",\\s*");
                    Product p = new Product (parts[0],parts[1],parts[2],Double.parseDouble(parts[3]));
                    products.add(p);
                }
                System.out.printf("%-15s %-25s %-10s %-10s%n", "Name", "Description","ID", "Cost");
                System.out.println("=========================================");

                for (Product p : products)
                {
                    System.out.printf(" %-15s %-25s %-10s $%-10.2f%n",
                            p.getName(),p.getDescription(),p.getID(),p.getCost());
                }
            } catch (IOException e)
            {
                System.out.println("Error reading file");
            }
        }
    }
}