public class Student extends Person
{
    //-----------data fields--------------
    String studentID;

    //-----------constructors-------------
    public Student()
    {

    }
    //------------methods-----------------
    public boolean match(String key);
    protected boolean validateData();
    protected void commit();
    protected void rollBack();

}