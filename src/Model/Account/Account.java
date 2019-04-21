package Model.Account;

import Model.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Account implements Entity<Integer>
{
    private Integer id;
    private AccountType type;
    private Map<Double, AmountInterval> rateToAmount;
    private LocalDateTime exp_date;
    private int amount;

    public Account(Integer id, AccountType type, Map<Double, AmountInterval> rateToAmount, LocalDateTime exp_date, int amount) {
        this.id = id;
        this.type = type;
        this.rateToAmount = rateToAmount;
        this.exp_date = exp_date;
        this.amount = amount;
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    @Override
    public void setID(Integer id) {
        this.id = id;
    }

    public AccountType getType() {
        return this.type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Map<Double, AmountInterval> getRateToAmount() {
        return this.rateToAmount;
    }

    public void setRateToAmount(Map<Double, AmountInterval> rateToAmount) {
        this.rateToAmount = rateToAmount;
    }

    public LocalDateTime getExp_date() {
        return this.exp_date;
    }

    public void setExp_date(LocalDateTime exp_date) {
        this.exp_date = exp_date;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        String msg = "";
        msg += "\n\tAccount:\n" + "Account id: " + this.id + "\nAccount type: " + this.type + "\nRate + Interval: ";
        List<Double> keys = new ArrayList<Double>(this.getRateToAmount().keySet());
        List<AmountInterval> values = new ArrayList<AmountInterval>(this.getRateToAmount().values());
        for (int i = 0; i < this.getRateToAmount().size(); i++)
            msg += "\n\t" + (i + 1) + ". Rate: " + keys.get(i) + " - " + values.get(i).toString();
        msg += "\nExpiration date: " + this.exp_date.toString() + "\nAvailable Amount: " + this.amount;
        return msg;
    }
}
