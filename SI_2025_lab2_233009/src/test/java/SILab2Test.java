import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SILab2Test {

    @Test
    public void everyStatementTest() {

        // Test za lista od Items
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null, "notImportant");
        });
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));


        // Test za validnost na item preku name
        List<Item> invalid = new ArrayList<>();
        invalid.add(new Item("", 100, 0, 1));
        ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(invalid, "1234567812345678");
        });
        assertTrue(ex.getMessage().contains("Invalid item!"));

        // Test za nevaliden format na karticka, 16cifri i notnull
        ArrayList<Item> valid = new ArrayList<>();
        valid.add(new Item("valid", 100, 0, 1));
        ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(valid, "123");
        });
        assertTrue(ex.getMessage().contains("Invalid card number!"));

        // Test za nevaliden karakter vo karticka
        ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(valid, "a234567812345666");
        });
        assertTrue(ex.getMessage().contains("Invalid character in card number!"));

        // Test za discount>1
        valid.add(new Item("IfStatemetsTest", 200, 50, 0.5d));
        assertEquals(5000-(valid.size()*30),SILab2.checkCart(valid, "1234512345123456"),"Condition for sum operation ERROR");

        // Test za  discount=0
        valid.add(new Item("IfStatemetsTest", 200, 50, 0));
        assertEquals(15000-(valid.size()*30),SILab2.checkCart(valid, "1234512345123456"),"Condition for sum operation ERROR");

    }

    @Test
    public void multipleConditionsTest() {
            // Test za multipleConditions so OR log. oper.
            ArrayList<Item> testArray = new ArrayList<>();
            testArray.add(new Item("Item1", 0, 301, 0)); // price>300
            testArray.add(new Item("Item2", 0, 299, 15)); // discount>0
            testArray.add(new Item("Item3", 30, 299, 0)); // quantity>10
            testArray.add(new Item("Item4", 8, 299, 0)); // none

            double result = SILab2.checkCart(testArray, "1234512345123456");
            assertEquals(11272,result,"MultipleConditions ERROR");


    }
}
