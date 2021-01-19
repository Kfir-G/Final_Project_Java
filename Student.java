import java.awt.*;
import java.util.*;
public class Student extends Person
{
    //-----------data fields--------------
    String studentID;

    private JTextField studentID;
    //-----------constructors-------------
    public Student()
    {

    }
    //------------methods-----------------
    public boolean match(String key)
    {
        return (super.match(key) || key.substring(5).equals(this.id)) ? true : false ;
    }
    protected boolean validateData();
    protected void commit();
    protected void rollBack();

}