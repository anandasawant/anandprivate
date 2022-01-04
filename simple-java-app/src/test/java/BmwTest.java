import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import clsobj.Bmw;
public class BmwTest {
    @DisplayName("Testing Object NullAbility")
    @Test
    void testInvalIndObject(){

        Bmw bmw=null;

        Assertions.assertNull(bmw);


    }
    @DisplayName("Testing Object Validity")
    @Test
    void testvalidObject(){
        Bmw bmw =new Bmw();
        Assertions.assertNotNull(bmw);

    }
}
