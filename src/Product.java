import java.io.IOException;
import java.io.RandomAccessFile;

public class Product
{
    private String name;
    private String description;
    private String ID;
    private double cost;

    public static final int NAME_LENGTH = 35;
    public static final int DESC_LENGTH = 75;
    public static final int ID_LENGTH = 6;

    public static final int RECORD_SIZE =
            (NAME_LENGTH + DESC_LENGTH + ID_LENGTH) * 2 + 8;

    public Product()
    {
    }

    public Product(String name, String description, String ID, double cost)
    {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getID()
    {
        return ID;
    }

    public double getCost()
    {
        return cost;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    @Override
    public String toString()
    {
        return String.format("%s (%s): %s - $%.2f",
                name, ID, description, cost);
    }

    public String toCSV()
    {
        return String.format("%s,%s,%s,%.2f",
                name, description, ID, cost);
    }

    public String toJSON()
    {
        return String.format(
                "{\"name\":\"%s\",\"description\":\"%s\",\"ID\":\"%s\",\"cost\":%.2f}",
                name, description, ID, cost);
    }

    public String toXML()
    {
        return String.format(
                "<product><name>%s</name><description>%s</description><ID>%s</ID><cost>%.2f</cost></product>",
                name, description, ID, cost);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || getClass() != obj.getClass())
            return false;

        Product other = (Product) obj;
        return ID.equals(other.ID);
    }


    public static String pad(String str, int length)
    {
        StringBuilder sb = new StringBuilder(str);

        while(sb.length() < length)
        {
            sb.append(" ");
        }

        return sb.toString().substring(0, length);
    }


    public void writeToFile(RandomAccessFile file)
            throws IOException
    {
        file.writeChars(pad(name, NAME_LENGTH));
        file.writeChars(pad(description, DESC_LENGTH));
        file.writeChars(pad(ID, ID_LENGTH));
        file.writeDouble(cost);
    }


    public static Product readFromFile(RandomAccessFile file)
            throws IOException
    {
        StringBuilder name = new StringBuilder();

        for(int i = 0; i < NAME_LENGTH; i++)
        {
            name.append(file.readChar());
        }

        StringBuilder description = new StringBuilder();

        for(int i = 0; i < DESC_LENGTH; i++)
        {
            description.append(file.readChar());
        }

        StringBuilder id = new StringBuilder();

        for(int i = 0; i < ID_LENGTH; i++)
        {
            id.append(file.readChar());
        }

        double cost = file.readDouble();

        return new Product(
                name.toString().trim(),
                description.toString().trim(),
                id.toString().trim(),
                cost
        );
    }
}