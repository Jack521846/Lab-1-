public class Person {
    private String firstName;
    private String lastName;
    private String id;
    private String title;
    private int yob;

    public Person(String firstName, String lastName, String id, String title, int yob)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.title = title;
        this.yob = yob;
    }

        public void setFirstName(String firstName) { this.firstName = firstName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public void setTitle(String title) { this.title = title; }


        public String fullName() { return firstName + " " + lastName; }




    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getID() { return id; }
    public String getId() { return id; } // alternate casing used elsewhere
    public String getTitle() { return title; }
    public int getYOB() { return yob; }
    public int getYob() { return yob; }

    public String formalName() { return title + " " + firstName + " " + lastName; }


    public String getAge() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return String.valueOf(currentYear - this.yob);
    }

    public String getAge(int year) {
        return String.valueOf(year - this.yob);
    }


    public String toCSV() {
        return " " + firstName + ", " + lastName + "," + id + ", " + title + ", " + yob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person other = (Person) o;
        return this.id != null && this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}
