import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDivsion {

    @Test
    public void TestDivison (){

        Division division=new Division();
        int actual=division.divisionMethod(10,5);
        int expected =2;

        Assertions.assertEquals(actual,expected);

    }
}
