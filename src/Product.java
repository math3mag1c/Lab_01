import java.util.Objects;

public class Product {
    private String ID;
    private String name;
    private String description;
    private double cost;
    private static int IDSeed = 1;

    public Product(String ID, String name, String description, double cost) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public Product(String name, String description, double cost) {
        this.ID = this.genID();
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public static void setIDSeed(int IDSeed) {
        Product.IDSeed = IDSeed;
    }

    private String genID() {
        String newID = "" + IDSeed;
        while (newID.length() < 8) {
            newID = "0" + newID;
        }

        IDSeed++;
        return newID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public static int getIDSeed() {
        return IDSeed;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(cost, product.cost) == 0 && Objects.equals(ID, product.ID) && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    public String toJSONRecord() {
        return "{\"ID\":\"" + this.ID + "\",\"name\":" + this.name + "\",\"description\":" + this.description + "\",\"cost\":" + this.cost + "}";
    }

    public String toCSVRecord() {
        return this.ID + ", " + this.name + "," + this.description + "," + this.cost;
    }

    public String toXMLRecord() {
        String xml = "";
        xml += "<Product>";
        xml += "<ID>" + this.ID + "</ID>";
        xml += "<name>" + this.name + "</name>";
        xml += "<description>" + this.description + "</description>";
        xml += "<cost>" + this.cost + "</cost>";
        xml += "</Product>";
        return xml;
    }
}