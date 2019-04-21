package Model;

public interface Entity<ID>
{
    /*
    Base class for all other model classes
    Implemented this way so it's easier with the Abstract Repository
     */
    ID getID();
    void setID(ID id);
}
