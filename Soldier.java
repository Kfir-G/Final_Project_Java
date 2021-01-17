public class Soldier extends Person
{
    //-----------data fields-----------
    String personalNum;
    //-----------constructors----------
    public Soldier()
    {

    }
    //------------methods--------------
    public boolean match(String key);
    protected boolean validateData();
    protected void commit();
    protected void rollBack();
}