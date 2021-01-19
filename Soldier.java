public class Soldier extends Person
{
    //-----------data fields-----------
    String personalNum;
    //-----------constructors----------
    public Soldier()
    {

    }
    //------------methods--------------
    public boolean match(String key)
    {
        if(key.equals(this.id) || key.equals(this.personalNum)) //? can I send to Person methods?
            return true;
        return false;       
    }
    protected boolean validateData();
    protected void commit();
    protected void rollBack();
}