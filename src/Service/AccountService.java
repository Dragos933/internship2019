package Service;

import Model.Account.Account;
import Repository.InMemoryRepository;
import sun.security.validator.ValidatorException;

import java.util.List;

public class AccountService
{
    private InMemoryRepository repo;

    public AccountService(InMemoryRepository repo) {
        this.repo = repo;
    }

    public void add(Account el) throws ValidatorException {
        this.repo.save(el);
    }

    public void delete(Account el) throws ValidatorException
    {
        this.repo.delete(el);
    }

    public void update(Account el) throws ValidatorException
    {
        this.repo.update(el);
    }

    public long size()
    {
        return this.repo.size();
    }

    public List<Account> getAccounts()
    {
        return this.repo.getAccounts();
    }
}
