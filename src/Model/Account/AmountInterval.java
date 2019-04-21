package Model.Account;

public class AmountInterval
{
    /*
    AmountInterval class:
        - getters
        - setters
        - toString
     */
    private int lowerBound;
    private int upperBound;
    private int nr;

    public AmountInterval(int lowerBound, int upperBound, int nr) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getLowerBound() {
        return this.lowerBound;

    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    @Override
    public String toString()
    {
        if (nr == 1)
            return "Amount Interval: [" + this.lowerBound + ", " + this.upperBound + "]";
        return "Amount Interval: (" + this.lowerBound + ", " + this.upperBound + "]";
    }
}
