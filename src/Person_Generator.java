import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Person_Generator
{
          public static void main(String[] args)
          {
                  Scanner in = new Scanner(System.in);
                  ArrayList<Person> people = new ArrayList<>();
                  System.out.println("=== Person Generator ===");
                  boolean keepGoing = true;
                  while (keepGoing)
                  {
                      String id = SafeInput.getNonZeroLenString(in, "Enter ID");
                      String first = SafeInput.getNonZeroLenString(in, "Enter First Name");
                      String last = SafeInput.getNonZeroLenString(in,  "Enter Last Name");
                      String title = SafeInput.getNonZeroLenString(in, "Enter Title");
                      int yob = SafeInput.getRangedInt(in, "Enter Year of Birth", 0, 3000);

                      Person p= new Person(first, last, id, title, yob);
                      people.add(p);

                      keepGoing = SafeInput.getYNConfirm(in,"Add another person?");
                  }
              String filename = SafeInput.getNonZeroLenString(in,"Enter filename to save");
              Path file= Path.of(filename);

              try(BufferedWriter writer = Files.newBufferedWriter(file))
              {
                  for(Person p : people)
                  {
                      writer.write(p.toCSV());
                      writer.newLine();
                  }
                  System.out.println("File saved successfully!");
              }
              catch(IOException e)
              {
                  System.out.println("Error writing file");
              }



          }

}
