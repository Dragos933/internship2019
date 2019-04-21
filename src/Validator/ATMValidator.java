package Validator;

import Model.ATM.ATM;
import Exceptions.ValidatorException;

public class ATMValidator implements IValidator<ATM>
{
    @Override
    public String validate(ATM entity) throws ValidatorException
    {
        String errors = "";
        if (entity.getID() <= 0)
            errors += "Invalid id!";
        if (entity.getName().equals(""))
            errors += "Invalid name!";
        if (entity.getOpeningTime().getHh() < 0 || entity.getOpeningTime().getHh() > 24)
            errors += "Invalid Opening Time!";
        if (entity.getOpeningTime().getMm() < 0 || entity.getOpeningTime().getMm() > 60)
            errors += "Invalid Opening Time!";
        if (entity.getClosingTime().getHh() < 0 || entity.getClosingTime().getHh() > 24)
            errors += "Invalid Closing Time!";
        if (entity.getClosingTime().getMm() < 0 || entity.getClosingTime().getMm() > 60)
            errors += "Invalid Closing Time!";

        return errors;
    }
}
