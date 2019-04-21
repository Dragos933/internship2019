package Tests;

import Tests.ATM.TestATM;
import Tests.ATM.TestATMService;
import Tests.Account.TestAccount;
import Tests.Account.TestAccountService;
import Tests.Distance.TestDistance;
import Tests.Distance.TestDistanceService;
import org.junit.Test;
import sun.security.validator.ValidatorException;

public class TestAll
{
    @Test
    public void testAll() throws ValidatorException, Exceptions.ValidatorException {
        new TestAccount().testAccount();
        new TestAccountService().testAccountService();
        new TestATM().testATM();
        new TestATMService().testATMService();
        new TestDistance().testDistance();
        new TestDistanceService().testDistanceService();
    }
}
