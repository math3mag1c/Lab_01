import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;
    private static int IDSeed = 1;

    public static int getIDSeed() {
        return IDSeed;
    }

    public String fullName() {
        return (firstName + " " + lastName);
    }

    public String formalName() {
        return (title + " " + firstName + " " + lastName);
    }

    public String getAge() {
        return (Integer.toString(2026 - YOB));
    }

    public String getAge(int year) {
        return (Integer.toString(year - YOB));
    }

    public String toCSV() {
        return (ID + "," + firstName + "," + lastName + "," + title + "," + Integer.toString(YOB));
    }

    public Person(String IDNum, String firstName, String lastName, String title, int YOB) {
        this.ID = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public Person(String firstName, String lastName, String title, int YOB) {
        this.ID = this.genID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public static void setIDSeed(int IDSeed) {
        Person.IDSeed = IDSeed;
    }

    private String genID() {
        String newID = "" + IDSeed;
        while (newID.length() < 8) {
            newID = "0" + newID;
        }

        IDSeed++;
        return newID;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return YOB == person.YOB && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(ID, person.ID) && Objects.equals(title, person.title);
    }

    public String toJSONRecord() {
        return "{\"ID\":\"" + this.ID + "\",\"firstName\":" + this.firstName + "\",\"lastName\":" + this.lastName + "\",\"title\":" + this.title + "\",\"YOB\":" + this.YOB + "}";
    }

    public String toCSVRecord() {
        return this.ID + ", " + this.firstName + "," + this.lastName + "," + this.YOB;
    }

    public String toXMLRecord() {
        String xml = "";
        xml += "<Person>";
        xml += "<ID>" + this.ID + "</ID>";
        xml += "<firstName>" + this.firstName + "</firstName>";
        xml += "<lastName>" + this.lastName + "</lastName>";
        xml += "<title>" + this.title + "</title>";
        xml += "<YOB>" + this.YOB + "</YOB>";
        xml += "</Person>";
        return xml;
    }
}