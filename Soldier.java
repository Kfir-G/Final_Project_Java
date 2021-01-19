public class Soldier extends Person
{
    //-----------data fields-----------
    String personalNum;

    private JTextField personalNum;
    //-----------constructors----------
    public Soldier()
    {

    }
    //------------methods--------------
    public boolean match(String key)
    {
        return (super.match(key) || key.equals(this.personalNum)) ? true : false; 
    }
    protected boolean validateData();
    protected void commit();
    protected void rollBack();
}