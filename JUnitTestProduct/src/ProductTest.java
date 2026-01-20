import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp()
    {
        p1 = new Product("000001", "Rao Sauce", "tomato sauce", 19.44);
        p2 = new Product("000002", "Ragu Sauce", "Also tomato sauce", 19.75);
        Product.setIDSeed(0);
        p3 = new Product("Steak", "form of meat", 50.30);
        p4 = new Product( "Pork", "pig meat", 40.25);
        p5 = new Product( "Bacon", "also pig meat", 9.70);
        p6 = new Product( "Chicken", "chicken meat", 9.75);

    }

    @Test
    /** tests the seed generator after 4 calls, should be 4*/
    void getIDSeed() {
        assertEquals(4, Product.getIDSeed());
    }

    /** Test the constructor with the first instance  p1 */

    @Test
    void getIDNum() {
        assertEquals("000001", p1.getID());
    }
    @Test
    void getFirstName() {
        assertEquals("Rao Sauce", p1.getName());
    }

    @Test
    void getDescription() {
        assertEquals("tomato sauce", p1.getDescription());
    }

    @Test
    void getCost() {
        assertEquals(19.44, p1.getCost());
    }

    /** now we go though all the setters and change P1 to P2 oo we can test the equals with P1 and P2 */
    @Test
    void setID() {
        p1.setID("00000B");
        assertEquals("00000B", p1.getID());
    }

    @Test
    void setName() {
        p1.setName("Ragu Sauce");
        assertEquals("Ragu Sauce", p1.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("Also tomato sauce");
        assertEquals("Also tomato sauce", p1.getDescription());
    }

    @Test
    void setCost() {
        p1.setCost(19.75);
        assertEquals(19.75, p1.getCost());
    }

    @Test
    void equals() {
        p1.setID("000002");
        p1.setName("Ragu Sauce");
        p1.setDescription("Also tomato sauce");
        p1.setCost(19.75);
        assertEquals(true, p1.equals(p2));
    }


}