public class Student extends Person
{
    //-----------data fields--------------
    String studentID;

    //-----------constructors-------------
    public Student()
    {

    }
    //------------methods-----------------
    public boolean match(String key)
    {
        if(super(key) || key.equals(studentID))
    }
    protected boolean validateData();
    protected void commit();
    protected void rollBack();

}