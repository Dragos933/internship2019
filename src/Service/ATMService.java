package Service;

import Exceptions.ValidatorException;
import Model.ATM.ATM;
import Repository.InMemoryRepository;

import java.util.Map;

public class ATMService
{
    private InMemoryRepository repo;

    public ATMService(InMemoryRepository repo)
    {
        this.repo = repo;
    }

    public void add(ATM el) throws ValidatorException {
        this.repo.save(el);
    }

    public void delete(Integer id) throws ValidatorException
    {
        this.repo.delete(id);
    }

    public void update(ATM el) throws ValidatorException
    {
        this.repo.update(el);
    }

    public ATM find(Integer id)
    {
        return (ATM) this.repo.findOne(id);
    }

    public long size()
    {
        return this.repo.size();
    }

    public Map<Integer, ATM> getATMs()
    {
        return this.repo.getElements();
    }
}
