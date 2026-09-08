import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
public class Product_Generator
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        System.out.println("=== Product Writer ===");

        boolean keepGoing = true;

        while(keepGoing)
        {
            String id = SafeInput.getNonZeroLenString(in,"Enter ID");
            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            String desc = SafeInput.getNonZeroLenString(in, "Enter Description");
            double cost = SafeInput.getDouble(in,"Enter Cost");

            Product p = new Product(name,desc,id, cost);
            products.add(p);

            keepGoing = SafeInput.getYNConfirm(in,"Add another product?");

        }
        String filename = SafeInput.getNonZeroLenString(in,"Enter filename to save");
        Path file = Path.of(filename);
        try(BufferedWriter writer = Files.newBufferedWriter(file))
        {
            for (Product p : products) {
                writer.write(p.toCSV());
                writer.newLine();
            }
            System.out.println("File saved successfully");
        }
        catch (IOException e)
        {
            System.out.println("Error writing file");
        }

    }
}