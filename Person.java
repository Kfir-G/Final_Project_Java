public class Person extends ClubAbstractEntity
{
    //-----------data fields---------------
    String id;
    String name;    //first name
    String surname; //last name
    String tel;     //telephone

    private JTextField id;
    private JTextField name;
    private JTextField surname;
    private JTextField tel;

    //----------constructors---------------
    public Person()
    {

    }
    //----------methods-------------------
    public boolean match(String key)
    {
        return key.equals(this.id) ? true: false; 
    }

    protected boolean validateData();
    protected void commit();
    protected void rollBack();
}