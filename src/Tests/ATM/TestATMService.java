package Tests.ATM;

import Exceptions.ValidatorException;
import Model.ATM.ATM;
import Model.ATM.Hour;
import Repository.ATMRepo;
import Service.ATMService;
import Validator.ATMValidator;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class TestATMService
{
    @Test
    public void testATMService() throws ValidatorException {
        ATMValidator validator = new ATMValidator();
        ATMRepo repo = new ATMRepo(validator);
        ATMService srv = new ATMService(repo);

        ATM atm1 = new ATM(1, "ATM 1", new Hour(10, 0), new Hour(20,30));
        ATM atm2 = new ATM(2, "ATM 2", new Hour(9, 30), new Hour(21, 0));
        ATM atm3 = new ATM(3, "ATM 3", new Hour(8, 45), new Hour( 23, 45));

        assertEquals(srv.size(), 0);
        srv.add(atm1);
        assertEquals(srv.size(), 1);
        srv.add(atm2);
        srv.add(atm3);
        assertEquals(srv.size(), 3);
        srv.delete(1);
        assertEquals(srv.size(), 2);
        assertEquals(srv.find(1), null);

        ATM atm4 = new ATM(3, "ATM 4", new Hour(8, 45), new Hour(23, 45));
        srv.update(atm4);
        assertEquals(srv.size(), 2);

        Map<Integer, ATM> atms = new HashMap<Integer, ATM>();
        atms.put(atm2.getID(), atm2);
        atms.put(atm4.getID(), atm4);
        assertEquals(atms.toString(), srv.getATMs().toString());

        //System.out.println(srv.getATMs().toString());
    }
}
