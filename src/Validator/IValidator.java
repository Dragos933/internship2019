package Validator;

import sun.security.validator.ValidatorException;

public interface IValidator<E>
{
    String validate(E entity) throws ValidatorException;
}
