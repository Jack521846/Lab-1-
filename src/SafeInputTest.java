import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;
public class SafeInputTest
{
   @Test
   public void testConstructor()
   {
       SafeInput s = new SafeInput();
       assertNotNull(s);
   }
   @Test
       public void testScannerConstructor()
       {
           java.util.Scanner in = new java.util.Scanner(System.in);
           SafeInputObj s =new SafeInputObj();
           assertNotNull(s);
       }
   @Test
    public void testMethodsExist()
   {
       String input = "Hello\n5\n5.5\n5\n5.5\nY\nabc123\n";
       System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

       SafeInputObj s =new SafeInputObj();
       assertDoesNotThrow(() -> s.getNonZeroLenString("Test"));
       assertDoesNotThrow(() -> s.getInt("Test"));
       assertDoesNotThrow(() -> s.getDouble("Test"));
       assertDoesNotThrow(() -> s.getRangedInt("Test",1 ,10));
       assertDoesNotThrow(() -> s.getRangedDouble("Test",1,10));
       assertDoesNotThrow(() -> s.getYNConfirm("Test"));
       assertDoesNotThrow(() -> s.getRegExString("Test", ".*"));
   }
}
