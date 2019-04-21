package Repository;

import Model.Account.Account;
import Validator.IValidator;

public class AccountRepo extends InMemoryRepository<Integer, Account>
{
    public AccountRepo(IValidator<Account> validator) {
        super(validator);
    }
}
