public class Product
{
    private String name;
    private String description;
    private String ID;
    private double cost;

    public Product(String name, String description, String ID, double cost)
    {
        this.name=name;
        this.description=description;
        this.ID=ID;
        this.cost=cost;
    }
    public void setName (String name) { this.name=name;}
    public void setDescription (String description) { this.description=description;}
    public void setID (String ID) { this.ID=ID;}
    public void setCost (double cost) {this.cost=cost;}
    public String getname() {return name;}
    public String getdescription() {return description;}
    public String getID() {return ID;}
    public double getcost() {return cost;}

    @Override
    public String toString()
    {
        return String.format("%s (%s): %s - $%.2f", name, ID, description, cost);
    }
    public String toCSV()
    {
        return String.format("%s, %s,%s,%.2f", name, description, ID, cost);

    }
    public String toJSON()
    {
        return String.format("{\"name\" : \"%s\", \"description\" : \"%s\", \"ID\": \"%s\", \"cost\":%.2f}",name, description, ID, cost);
    }
    public String toXML()
    {
        return String.format("<product><name>%s</name><description>%s</description><ID>%s</ID><cost>%.2f</cost></product>",name, description, ID, cost);
    }
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product other = (Product) obj;
        return ID.equals(other.ID);
    }
}
