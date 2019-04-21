package Service;

import Model.Account.Account;
import Repository.InMemoryRepository;
import Exceptions.ValidatorException;

import java.util.Map;

public class AccountService
{
    private InMemoryRepository repo;

    public AccountService(InMemoryRepository repo) {
        this.repo = repo;
    }

    public void add(Account el) throws ValidatorException {
        this.repo.save(el);
    }

    public void delete(Integer id) throws ValidatorException
    {
        this.repo.delete(id);
    }

    public void update(Account el) throws ValidatorException
    {
        this.repo.update(el);
    }

    public Account find(Integer id)
    {
        return (Account) this.repo.findOne(id);
    }

    public long size()
    {
        return this.repo.size();
    }

    public Map<Integer, Account> getAccounts()
    {
        return this.repo.getElements();
    }
}
