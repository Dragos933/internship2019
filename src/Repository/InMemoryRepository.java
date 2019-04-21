package Repository;

import Model.Entity;
import Validator.IValidator;
import Exceptions.ValidatorException;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository<ID,E extends Entity<ID>> implements IAbstractRepository<ID, E>
{
    /*
    Abstract CRUD in memory repository
     */

    private Map<ID, E> repo;
    private IValidator<E> validator;

    public InMemoryRepository(IValidator<E> v)
    {
        this.repo = new HashMap<>();
        this.validator = v;
    }

    @Override
    public E findOne(ID id)
    {
        if (this.repo.get(id) == null)
            return null;
        else
            if (id == null)
                throw new IllegalArgumentException();
            else
                return this.repo.get(id);
    }

    @Override
    public Map<ID, E> getElements()
    {
        return this.repo;
    }

    @Override
    public E save(E el) throws ValidatorException
    {
        String msg = this.validator.validate(el);
        if (msg.equals(""))
        {
            this.repo.putIfAbsent(el.getID(), el);
            return findOne(el.getID());
        }
        else
            throw new ValidatorException(msg);
    }

    @Override
    public E delete(ID id)
    {
        return this.repo.remove(id);
    }


    @Override
    public E update(E entity) throws ValidatorException
    {
        String msg = this.validator.validate(entity);
        if (msg.equals(""))
        {
            return this.repo.replace(entity.getID(), entity);
        }
        else
            throw new ValidatorException(msg);
    }

    public long size()
    {
        return this.repo.size();
    }
}
