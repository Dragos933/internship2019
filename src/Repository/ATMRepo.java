package Repository;

import Model.ATM.ATM;
import Validator.IValidator;

public class ATMRepo extends InMemoryRepository<Integer, ATM>
{
    public ATMRepo(IValidator<ATM> validator)
    {
        super(validator);
    }
}
