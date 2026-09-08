import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest
{
   @Test
   public void testConstructor()
   {
       Person p =new Person("John", "Doe", "123", "Mr.", 1990);
         assertEquals("John", p.getFirstName());
         assertEquals("Doe", p.getLastName());
         assertEquals("123", p.getID());
         assertEquals("Mr.", p.getTitle());
         assertEquals(1990, p.getYOB());
   }
   @Test
   public void testSetters()
   {
       Person p = new Person("John", "Doe", "123", "Mr.", 1990);
       p.setFirstName("Jane");
       p.setLastName("Smith");
       p.setTitle("Dr.");
       assertEquals("Jane", p.getFirstName());
       assertEquals("Smith", p.getLastName());
       assertEquals("Dr.", p.getTitle());

   }
   @Test
   public void testFullName()
    {
        Person p = new Person("John", "Doe","123","Mr.", 1990);
        assertEquals("John Doe", p.fullName());
    }
    @Test
    public void testFormalName()
    {
        Person p =new Person("John", "Doe", "123", "Mr.",1990);
        assertEquals("Mr. John Doe", p.formalName());
    }
    @Test
    public void testGetAge()
    {
        Person p= new Person ("John", "Doe", "123", "Mr.",1990);
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        assertEquals(String.valueOf(currentYear -1990), p.getAge());
    }
    @Test
    public void testGetAgeForYear()
    {
        Person p = new Person("John", "Doe", "123", "Mr.",1990);
        assertEquals("10",p.getAge(2000));
    }
    @Test
    public void testToCSV()
    {
        Person p = new Person("John", "Doe", "123", "Mr.",1990);
        assertEquals(" John, Doe,123, Mr., 1990", p.toCSV());
    }
    @Test
    public void testEquals()
    {
        Person p1 = new Person("John", "Doe", "123", "Mr.", 1990);
        Person p2 = new Person("Jane", "Smith", "123", "Ms.",1985);
        assertTrue(p1.equals(p2));
    }
}
