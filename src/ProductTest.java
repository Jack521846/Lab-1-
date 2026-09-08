import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ProductTest
{
    @Test
    public void testConstructor()
    {
        Product p = new Product("Laptop", "Gaming laptop","A100",999.99);
        assertEquals("Laptop", p.getname());
        assertEquals("Gaming laptop",p.getdescription());
        assertEquals("A100", p.getID());
        assertEquals(999.99, p.getcost());
    }

    @Test
     public void testToCSV()
    {
     Product p =new Product ("Laptop", "Gaming laptop","A100",999.99);
     assertEquals("Laptop, Gaming laptop,A100,999.99", p.toCSV());
    }
    @Test
    public void testToJSON()
    {
        Product p = new Product("Laptop", "Gaming laptop","A100",999.99);
        assertEquals("{\"name\" : \"Laptop\", \"description\" : \"Gaming laptop\", \"ID\": \"A100\", \"cost\":999.99}", p.toJSON());
    }
    @Test
    public void testToXML()
    {
        Product p = new Product("Laptop", "Gaming laptop","A100",999.99);
        assertEquals("<product><name>Laptop</name><description>Gaming laptop</description><ID>A100</ID><cost>999.99</cost></product>", p.toXML());
    }
    @Test
        public void testEquals()
        {
           Product p1 = new Product("Laptop", "Gaming laptop","A100",999.99);
           Product p2 = new Product("Desktop", "Office desktop","A100",799.99);
           assertTrue(p1.equals(p2));
        }
}

