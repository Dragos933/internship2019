package Repository;

import Model.Account.Account;
import Validator.IValidator;
import sun.security.validator.ValidatorException;

public class AccountRepo extends InMemoryRepository<Account>
{
    public AccountRepo(IValidator<Account> v) {
        super(v);
    }

    public void update(Account el) throws ValidatorException
    {
        String msg = super.
        if (msg.equals(""))
        {
            int pos = getAccountPos(el);
            this.repo.remove(pos);
            this.repo.add(pos, el);
        }
        else
            throw new ValidatorException(msg);
    }
}
