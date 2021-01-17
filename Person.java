public class Person extends ClubAbstractEntity
{
    //-----------data fields---------------
    String id;
    String name;    //first name
    String surname; //last name
    String tel;     //telephone

    //----------constructors---------------
    public Person()
    {

    }
    //----------methods-------------------
    public boolean match(String key)
    {

    }

    protected boolean validateData();
    protected void commit();
    protected void rollBack();
}