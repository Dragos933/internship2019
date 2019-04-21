package Model.Distance;

import Model.Entity;

public class Distance implements Entity<Integer>
{
    private Integer id;
    private String From;
    private String To;
    private int duration;

    public Distance(Integer id, String from, String to, int duration) {
        this.id = id;
        From = from;
        To = to;
        this.duration = duration;
    }

    @Override
    public Integer getID()
    {
        return this.id;
    }

    @Override
    public void setID(Integer id)
    {
        this.id = id;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString()
    {
        return "\n\tDistance: \nDistance id: " + this.id + "\nFrom: " + this.From + "\nTo: " + this.To + "\nDuration: " + this.duration + " (minutes)\n";
    }
}
