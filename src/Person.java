import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;
    private static int IDSeed = 1;

    /**
     * gets the value of IDSeed from the Person object
     *
     * @return the value of integer IDSeed
     */
    public static int getIDSeed() {
        return IDSeed;
    }
    /**
     * gets the person's first and last name together
     *
     * @return the String of the person's firstName with a space followed by their lastName
     */
    public String fullName() {
        return (firstName + " " + lastName);
    }
    /**
     * gets the person's formal name, meaning their title first followed by their full name
     *
     * @return the String of the person's title followed by a space followed by their full name (defined by their fullName)
     */
    public String formalName() {
        return (title + " " + firstName + " " + lastName);
    }
    /**
     * calculates the person's age given their year of birth and the current year 2026
     *
     * @return the String value of the current year minus the person's year of birth
     */
    public String getAge() {
        return (Integer.toString(2026 - YOB));
    }
    /**
     * calculates the person's age given their year of birth and the provided year
     *
     * @param year the year provided by the user from which they would like the program to calculate their age
     * @return the String value of their calculated age
     */
    public String getAge(int year) {
        return (Integer.toString(year - YOB));
    }
    /**
     * creates a CSV record of the Strings of the person's ID, first name, last name, title, and year of birth without spaces
     *
     * @return the CSV record containing all the person's information
     */
    public String toCSV() {
        return (ID + "," + firstName + "," + lastName + "," + title + "," + Integer.toString(YOB));
    }
    /**
     * constructs a new instance of the person class given all of their information
     *
     * @param IDNum the person's provided ID
     * @param firstName the person's provided first name
     * @param lastName the person's provided last name
     * @param title the person's provided title
     * @param YOB the integer value of the person's provided year of birth
     */
    public Person(String IDNum, String firstName, String lastName, String title, int YOB) {
        this.ID = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }
    /**
     * constructs a new instance of the person class given all of their information except for their ID which is generated using the genID() function if not provided
     *
     * @param firstName the person's provided first name
     * @param lastName the person's provided last name
     * @param title the person's provided title
     * @param YOB the integer value of the person's provided year of birth
     */
    public Person(String firstName, String lastName, String title, int YOB) {
        this.ID = this.genID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }
    /**
     * sets the value of IDSeed to a number provided by the user
     *
     * @param IDSeed the value from which the user would like the program to create their ID
     */
    public static void setIDSeed(int IDSeed) {
        Person.IDSeed = IDSeed;
    }
    /**
     * generates an ID from the IDSeed
     *
     * @return the String value of the newID created from the IDSeed
     */
    private String genID() {
        String newID = "" + IDSeed;
        while (newID.length() < 8) {
            newID = "0" + newID;
        }

        IDSeed++;
        return newID;
    }
    /**
     * gets the value of the person's year of birth
     *
     * @return the String of the integer YOB (or year of birth)
     */
    public int getYOB() {
        return YOB;
    }
    /**
     * sets the value of YOB to a number provided by the user
     *
     * @param YOB the value to which the user would like to set their year of birth
     */
    public void setYOB(int YOB) {
        this.YOB = YOB;
    }
    /**
     * gets the person's title
     *
     * @return the String of the person's title
     */
    public String getTitle() {
        return title;
    }
    /**
     * sets the person's title to a new title provided by the user
     *
     * @param title the new title to which the user would like to set their title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * gets the person's ID
     *
     * @return the String of the person's ID
     */
    public String getID() {
        return ID;
    }
    /**
     * sets the person's ID to a new ID provided by the user
     *
     * @param ID the new ID to which the user would like to set their ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }
    /**
     * gets the person's last name
     *
     * @return the String of the person's last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * sets the person's last name to a new last name provided by the user
     *
     * @param lastName the new last name to which the user would like to set their last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * gets the person's first name
     *
     * @return the String of the person's first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * sets the person's first name to a new first name provided by the user
     *
     * @param firstName the new first name to which the user would like to set their first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * overrides printing the name of the person function as a location and replaces it with the information from the person object
     *
     * @return a String containing all the person's information with labels
     */
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

    /**
     * overrides trying to directly find whether two objects are equal and replaces it with comparing every attribute of the two objects
     *
     * @return the boolean value of whether the two Person objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return YOB == person.YOB && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(ID, person.ID) && Objects.equals(title, person.title);
    }
    /**
     * creates a JSON record with all the person's information
     *
     * @return a String containing all the person's information with labels
     */
    public String toJSONRecord() {
        return "{\"ID\":\"" + this.ID + "\",\"firstName\":" + this.firstName + "\",\"lastName\":" + this.lastName + "\",\"title\":" + this.title + "\",\"YOB\":" + this.YOB + "}";
    }
    /**
     * creates a CSV record with all the person's information
     *
     * @return a String containing all the person's information with labels
     */
    public String toCSVRecord() {
        return this.ID + ", " + this.firstName + "," + this.lastName + "," + this.YOB;
    }
    /**
     * creates an XML record with all the person's information
     *
     * @return a String containing all the person's information with labels
     */
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