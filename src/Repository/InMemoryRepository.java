package Repository;

import Validator.IValidator;
import sun.security.validator.ValidatorException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository<E> implements IAbstractRepository<E>
{
    private List<E> repo;
    private IValidator<E> validator;

    public InMemoryRepository(IValidator<E> v)
    {
        this.repo = new ArrayList<E>();
        this.validator = v;
    }

    public List<E> getElements()
    {
        return this.repo;
    }

    public void save(E el) throws ValidatorException
    {
        String msg = this.validator.validate(el);
        if (msg.equals(""))
            this.repo.add(el);
        else
            throw new ValidatorException(msg);
    }

    public void delete(E el) throws ValidatorException
    {
        String msg = this.validator.validate(el);
        if (msg.equals(""))
            this.repo.remove(el);
        else
            throw new ValidatorException(msg);
    }


    public long size()
    {
        return this.repo.size();
    }

    @Override
    public String toString()
    {
        String msg = "";
        for (E el : this.repo)
            msg += el.toString();
        return msg;
    }
}
