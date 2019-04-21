package Tests;

import Tests.Account.TestAccount;
import Tests.Account.TestAccountService;
import org.junit.Test;
import sun.security.validator.ValidatorException;

public class TestAll
{
    @Test
    public void testAll() throws ValidatorException, Exceptions.ValidatorException {
        new TestAccount().testAccount();
        new TestAccountService().testAccountService();
    }
}
