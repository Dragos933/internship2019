package Service;

import Exceptions.ValidatorException;
import Model.Account.Account;
import Repository.AccountRepo;

import java.util.Map;

public class AccountService
{
    private AccountRepo repo;

    public AccountService(AccountRepo repo) {
        this.repo = repo;
    }

    public AccountRepo getRepo()
    {
        return this.repo;
    }

    public void setRepo(AccountRepo repo)
    {
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
        return this.repo.findOne(id);
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
