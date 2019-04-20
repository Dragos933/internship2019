package Validator;

import Model.Account.Account;
import Model.Account.AmountInterval;
import sun.security.validator.ValidatorException;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

public class AccountValidator implements IValidator<Account>
{
    public String validate(Account entity) throws ValidatorException
    {
        String errors = "";
        if (entity.getType().name() != "SILVER" && entity.getType().name() != "GOLD" && entity.getType().name() != "PLATINUM")
            errors += "Invalid type!";
        Set<Double> interestRate = entity.getRateToAmount().keySet();
        for (Double el : interestRate)
            if (el < 0)
                errors += "Invalid Interest Rate!";
        Collection<AmountInterval> amounts = entity.getRateToAmount().values();
        for (AmountInterval el : amounts)
            if (el.getLowerBound() < 0)
                errors += "Invalid Amount Interval: Lower Bound is invalid!";
            else if (el.getUpperBound() < 0)
                errors += "Invalid Amount Interval: Upper Bound is invalid!";
            else if (el.getNr() != 1 && el.getNr() != 2)
                errors += "Invalid Amount Interval: Type of interval invalid!";
        if (entity.getExp_date().getYear() < LocalDateTime.now().getYear())
            errors += "Invalid year!";
        if (entity.getAmount() < 0)
            errors += "Invalid amount!";
        return errors;
    }
}
