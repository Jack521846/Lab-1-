import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Person_Reader
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select Person File");

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION)
        {
            Path file = chooser.getSelectedFile().toPath();
            ArrayList<Person> people = new ArrayList<>();

            try (BufferedReader reader = Files.newBufferedReader(file)) {


                String line;
                while ((line = reader.readLine()) != null)
                {
                    String[] parts = line.split(",\\s*");
                    Person p= new Person(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                    people.add(p);
                }
                System.out.printf("%-12s %-12s %-8s %-6s%n", "FirstName", "LastName","ID","Title","YOB");
                System.out.println("=========================================");
                for(Person p : people)
                {
                    System.out.printf("%-12s %-12s %-8s %-8s %-6s%n", p.getFirstName(), p.getLastName(), p.getId(), p.getTitle(), p.getYob());
                }
            } catch (IOException e)
                {
                  System.out.println("Error reading file");
                }
        }
    }
}