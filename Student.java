import java.awt.*;
import java.util.*;
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
        if(key.equals(this.id)) //? can I send to Person methods?
            return true;
        if(key.substring(5).equals(this.id))
            return true;
        return false;
    }
    protected boolean validateData();
    protected void commit();
    protected void rollBack();

}