package Validator;

import Model.Distance.Distance;

public class DistanceValidator implements IValidator<Distance>
{

    @Override
    public String validate(Distance entity)
    {
        String errors = "";
        if (entity.getID() <= 0)
            errors += "Invalid id!";
        if (entity.getFrom().equals(""))
            errors += "Invalid location: From!";
        if (entity.getTo().equals(""))
            errors += "Invalid location: To!";
        if (entity.getDuration() <= 0)
            errors += "Invalid duration!";

        return errors;
    }
}
