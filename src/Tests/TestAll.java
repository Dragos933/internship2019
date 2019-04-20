package Tests;

import org.junit.Test;
import sun.security.validator.ValidatorException;

public class TestAll
{
    @Test
    public void testAll() throws ValidatorException {
        new TestAccount().testAccount();
        new TestAccountService().testAccountService();
    }
}
