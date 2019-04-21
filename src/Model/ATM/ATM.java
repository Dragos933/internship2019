package Model.ATM;

import Model.Entity;

public class ATM implements Entity<Integer>
{
    private Integer id;
    private String name;
    private Hour openingTime;
    private Hour closingTime;
    private int amount;

    public ATM(Integer id, String name, Hour openingTime, Hour closingTime) {
        this.id = id;
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.amount = 5000;
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    @Override
    public void setID(Integer id) {
        this.id = id;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hour getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Hour openingTime) {
        this.openingTime = openingTime;
    }

    public Hour getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Hour closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public String toString()
    {
        return "\n\tATM:" + "\nATM id: " + this.id + "\nATM Name: " + this.name + "\nOpening time: " + this.openingTime.toString() + "\nClosing time: " + this.closingTime.toString() + "\nAmount: " + this.amount + "\n";
    }
}
