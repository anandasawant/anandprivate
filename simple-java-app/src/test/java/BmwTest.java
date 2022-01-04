import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import clsobj.Bmw;
import clsobj.Car;
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
    @DisplayName("Test is Bmw is a Car")
    @Test
    void testBmwObjectCar() {
        Bmw bmw = new Bmw();
        boolean expected = true;
        boolean actual = bmw instanceof Car;
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Test Car is Not a BMW")
    @Test
    void testCarObjectNotBmw() {
        Car car = new Car();
        boolean expected = false;
        boolean actual = car instanceof Bmw;
        Assertions.assertEquals(expected, actual);
    }
}
