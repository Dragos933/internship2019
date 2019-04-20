package Tests;

import Model.Account.Account;
import Model.Account.AccountType;
import Model.Account.AmountInterval;
import Validator.AccountValidator;
import org.junit.Test;
import sun.security.validator.ValidatorException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class TestAccount
{
    @Test
    public void testAccount() throws ValidatorException {
        Map<Double, AmountInterval> map = new HashMap<>();
        map.put(0.2, new AmountInterval(0, 500, 1));
        map.put(0.5, new AmountInterval(500, 5000, 2));
        Account acc1 = new Account(AccountType.SILVER, map, LocalDateTime.of(2020, 10, 10, 10, 10), 5000);

        AccountValidator validator = new AccountValidator();

        String msg = validator.validate(acc1);
        assertEquals(msg, "");

        assertEquals(acc1.getType(), AccountType.SILVER);
        acc1.setType(AccountType.GOLD);
        assertEquals(acc1.getType(), AccountType.GOLD);

        assertEquals(acc1.getRateToAmount().get(0.2).getLowerBound(), 0);
        assertEquals(acc1.getRateToAmount().get(0.5).getUpperBound(), 5000);
        assertEquals(acc1.getRateToAmount().get(0.5).getNr(), 2);

        assertEquals(acc1.getExp_date().getYear(), 2020);
        acc1.setExp_date(LocalDateTime.of(2021,10,10,10,10));
        assertEquals(acc1.getExp_date().getYear(), 2021);

        assertEquals(acc1.getAmount(), 5000);
        acc1.setAmount(50000);
        assertEquals(acc1.getAmount(), 50000);

        Account acc2 = new Account(AccountType.GOLD, map, LocalDateTime.of(2020, 10, 10, 10, 10), -5);
        msg = validator.validate(acc2);
        assertEquals(msg, "Invalid amount!");

    }
}
