package Model.ATM;

public class Hour
{
    private int hh;
    private int mm;

    public Hour(int hh, int mm) {
        this.hh = hh;
        this.mm = mm;
    }

    public int getHh() {
        return hh;
    }

    public void setHh(int hh) {
        this.hh = hh;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    @Override
    public String toString()
    {
        String msg = "";
        if (this.hh < 10)
            msg += "0" + this.hh;
        else
            msg += this.hh;
        msg += ":";
        if (this.mm < 10)
            msg += "0" + this.mm;
        else
            msg += this.mm;
        return msg;
    }
}
