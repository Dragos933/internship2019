package Model.ATM;

public class ATM
{
    private String name;
    private Hour openingTime;
    private Hour closingTime;

    public ATM(String name, Hour openingTime, Hour closingTime) {
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
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
        return "\n\tATM:" + "\nATM Name: " + this.name + "\nOpening time: " + this.openingTime.toString() + "\nClosing time: " + this.closingTime.toString();
    }
}
