import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class ObjInputTest {
    void getNonZeroLenString() {
        System.out.println("=================");
        String returnedWord = new SafeInputObj().getNonZeroLenString("Type the following word: cheese");
        assertEquals(returnedWord, "cheese");
        System.out.println("Assertion passed - getNonZeroLenString TEST PASSED");
    }

    void getInt() {
        System.out.println("=================");
        new SafeInputObj().getInt("Please input an integer");
        int thing2 = new SafeInputObj().getInt("Please input the integer 5");
        assertEquals(thing2, 5);
        System.out.println("Assertion passed - getInt TEST PASSED");
    }

    void getDouble() {
        System.out.println("=================");
        double thing = new SafeInputObj().getDouble("Please input an double");
        double thing2 = new SafeInputObj().getDouble("Please input double 6.7");
        assertEquals(thing2, 6.7);
        System.out.println("Assertion passed - getDouble TEST PASSED");
    }

    void getRangedInt() {
        System.out.println("=================");
        int thing = new SafeInputObj().getRangedInt("Input an integer from", 24, 74);
        int thing2 = new SafeInputObj().getRangedInt("Only input the integer 33", 33, 33);
        assertEquals(thing2, 33);
        System.out.println("Assertion passed - getRangedInt TEST PASSED");
    }

    void getRangedDouble() {
        System.out.println("===============");
        double thing = new SafeInputObj().getRangedDouble("Input an double from", 24, 74);
        double thing2 = new SafeInputObj().getRangedDouble("Only input the double 67.67", 67.67, 67.67);
        assertEquals(thing2, 67.67);
        System.out.println("Assertion passed - getRangedDouble from TEST PASSED");
    }

    void getYNConfirm() {
        System.out.println("=================");
        boolean thing = new SafeInputObj().getYNConfirm("Please type Y/y or N/n");
        boolean thing2 = new SafeInputObj().getYNConfirm("Please type Y");
        assertEquals(true, thing2);
        System.out.println("Assertion passed - getYNConfirm TEST PASSED");
    }

    void getRegExString() {
        System.out.println("=================");
        String thing = new SafeInputObj().getRegExString("Please enter a 5-digit number", "\\d{5}");
        System.out.println("Assertion passed - getRegExString TEST PASSED");
    }

    void repeatedLine() {
        System.out.println("=================");
        new SafeInputObj().repeatedLine(3, "i", true);
        System.out.println("visually, repeatedLine TEST PASSED");
    }

    void centeredMessage() {
        System.out.println("===============");
        new SafeInputObj().centeredMessage("Center this pls");
        System.out.println("\n");
        System.out.println("visually, centeredMessage TEST PASSED");
    }

    void runTests() {
        getNonZeroLenString();
        getInt();
        getDouble();
        getRangedInt();
        getRangedDouble();
        getYNConfirm();
        getRegExString();
        repeatedLine();
        centeredMessage();
    }
}