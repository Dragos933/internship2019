package Tests.ATM;

import Exceptions.ValidatorException;
import Model.ATM.ATM;
import Model.ATM.Hour;
import Validator.ATMValidator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestATM
{
    @Test
    public void testATM() throws ValidatorException {
        ATM atm1 = new ATM(1, "ATM 1", new Hour(10, 0), new Hour(20, 0));
        ATM atm2 = new ATM(2, "ATM 2", new Hour(20, -1), new Hour(30, 10));

        ATMValidator validator = new ATMValidator();

        String msg1 = validator.validate(atm1);
        assertEquals(msg1, "");

        String msg2 = validator.validate(atm2);
        assertEquals(msg2, "Invalid Opening Time!Invalid Closing Time!");

        assertEquals((int)atm1.getID(), 1);
        assertEquals(atm1.getName(), "ATM 1");
        atm1.setName("ATM 3");
        assertEquals(atm1.getName(), "ATM 3");
        assertEquals(atm1.getOpeningTime().getHh(), 10);
        assertEquals(atm1.getOpeningTime().getMm(), 0);
        assertEquals(atm1.getClosingTime().getMm(), 0);
        assertEquals(atm1.getAmount(), 5000);

        //System.out.println(atm1.toString());
    }
}