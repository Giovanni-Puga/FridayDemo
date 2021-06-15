import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CILabTest {

    private CILabInterface myString;

    @BeforeEach
    public void setUp() {
        myString = new CILab();
    }

    @AfterEach
    public void tearDown() {
        myString = null;
    }

    //Empty String test
    @Test
    public void detectCapitalUseTest1() {
        assertThrows(NullPointerException.class, ()-> {myString.detectCapitalUse();});
    }

    //Null String test
    @Test
    public void detectCapitalUseTest2() {
        myString = null;
        assertThrows(NullPointerException.class, ()-> {myString.detectCapitalUse();});
    }

    //First character capital test
    @Test
    public void detectCapitalUseTest3() {
        myString.setString("Apples");
        assertEquals(true, myString.detectCapitalUse());
    }

    //All character uppercase test
    @Test
    public void detectCapitalUseTest4() {
        myString.setString("APPLES");
        assertEquals(true, myString.detectCapitalUse());
    }

    //All character lowercase test
    @Test
    public void detectCapitalUseTest5() {
        myString.setString("apples");
        assertEquals(true, myString.detectCapitalUse());
    }

    //Improper casing test - middle
    @Test
    public void detectCapitalUseTest6() {
        myString.setString("apPles");
        assertEquals(false, myString.detectCapitalUse());
    }

    //Improper casing test - first and last
    @Test
    public void detectCapitalUseTest7() {
        myString.setString("AppleS");
        assertEquals(false, myString.detectCapitalUse());
    }

    //Improper casing test - all upper except one
    @Test
    public void detectCapitalUseTest8() {
        myString.setString("APPLeS");
        assertEquals(false, myString.detectCapitalUse());
    }

    //Improper casing test - Every other character is uppercase
    @Test
    public void detectCapitalUseTest9() {
        myString.setString("aPpLeS");
        assertEquals(false, myString.detectCapitalUse());
    }

    //Test proper capitalization of string with spaces
    @Test
    public void detectCapitalUseTest10() {
        myString.setString("Apples are good for you");
        assertEquals(true, myString.detectCapitalUse());
    }

    //Test improper capitalization of string with spaces
    @Test
    public void detectCapitalUseTest11() {
        myString.setString("Apples Are Good for You");
        assertEquals(false, myString.detectCapitalUse());
    }

    //Test that numbers and symbols return true by default
    @Test
    public void detectCapitalUseTest12() {
        myString.setString("!!!!!890 @pp1e5...");
        assertEquals(true, myString.detectCapitalUse());
    }


}
