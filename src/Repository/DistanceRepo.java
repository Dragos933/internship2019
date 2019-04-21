package Repository;

import Model.Distance.Distance;
import Validator.IValidator;

public class DistanceRepo extends InMemoryRepository<Integer, Distance>
{
    public DistanceRepo(IValidator<Distance>validator)
    {
        super(validator);
    }

}
