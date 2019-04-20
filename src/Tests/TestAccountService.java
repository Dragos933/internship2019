package Tests;

import Model.Account.Account;
import Model.Account.AccountType;
import Model.Account.AmountInterval;
import Repository.InMemoryRepository;
import Service.AccountService;
import Validator.AccountValidator;
import Validator.IValidator;
import org.junit.Test;
import sun.security.validator.ValidatorException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class TestAccountService
{
    @Test
    public void testAccountService() throws ValidatorException {
        IValidator<Account> validator = new AccountValidator();
        InMemoryRepository repo = new InMemoryRepository(validator);
        AccountService srv = new AccountService(repo);

        Map<Double, AmountInterval> map1 = new HashMap<>();
        map1.put(0.2, new AmountInterval(0, 500, 1));
        map1.put(0.5, new AmountInterval(500, 5000, 2));
        Account acc1 = new Account(AccountType.SILVER, map1, LocalDateTime.of(2020, 10, 10, 10, 10), 5000);

        Map<Double, AmountInterval> map2 = new HashMap<>();
        map2.put(0.3, new AmountInterval(0, 500, 1));
        map2.put(0.6, new AmountInterval(500, 5000, 2));
        Account acc2 = new Account(AccountType.GOLD, map2, LocalDateTime.of(2021, 10, 10, 10, 10), 5000);

        Map<Double, AmountInterval> map3 = new HashMap<>();
        map3.put(0.4, new AmountInterval(0, 500, 1));
        map3.put(0.7, new AmountInterval(500, 5000, 2));
        Account acc3 = new Account(AccountType.PLATINUM, map3, LocalDateTime.of(2022, 10, 10, 10, 10), 5000);

        assertEquals(srv.size(), 0);
        srv.add(acc1);
        assertEquals(srv.size(), 1);
        srv.delete(acc1);
        assertEquals(srv.size(), 0);
        srv.add(acc1);
        srv.add(acc2);
        assertEquals(srv.size(),2);
        srv.add(acc3);
        assertEquals(srv.size(),3);

        Map<Double, AmountInterval> map4 = new HashMap<>();
        map4.put(0.7, new AmountInterval(0, 500, 1));
        map4.put(0.9, new AmountInterval(500, 5000, 2));
        Account acc4 = new Account(AccountType.PLATINUM, map4, LocalDateTime.of(2023, 10, 10, 10, 10), 5000);

        srv.update(acc4);
        assertEquals(srv.size(), 3);

        List<Account> accs = new ArrayList<Account>();
        accs.add(acc1);
        accs.add(acc2);
        accs.add(acc4);

        assertEquals(accs, srv.getAccounts());
    }
}
