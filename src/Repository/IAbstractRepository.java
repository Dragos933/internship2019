package Repository;

import sun.security.validator.ValidatorException;

import java.util.List;

public interface IAbstractRepository<E>
{
    List<E> getElements();
    void save(E el) throws ValidatorException;
    void delete(E el) throws ValidatorException;
    long size();
    String toString();
}
