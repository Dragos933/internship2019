package Repository;

import Exceptions.ValidatorException;

import java.util.Map;

public interface IAbstractRepository<ID, E>
{
    Map<ID, E> getElements();
    E findOne(ID id);
    E save(E el) throws ValidatorException;
    E delete(ID id);
    E update(E entity) throws ValidatorException;
    long size();
}
