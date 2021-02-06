import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Soldier extends Person
{
    //-----------data fields-----------
    String personalNumP;

    private JTextField personalNumT;
    //-----------constructors----------
    public Soldier()
    {
        super();
    }
    //------------methods--------------
    public boolean match(String key)
    {
        return (super.match(key) || key.equals(this.personalNum)) ? true : false; 
    }
    protected boolean validateData(){

    }
    protected void commit(){

    }
    protected void rollBack(){

    }
}