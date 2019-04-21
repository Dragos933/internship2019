package Validator;

import Exceptions.ValidatorException;

public interface IValidator<E>
{
    String validate(E entity) throws ValidatorException;
}