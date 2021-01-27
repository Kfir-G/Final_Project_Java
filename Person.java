import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Person extends ClubAbstractEntity
{
    
    //-----------data fields---------------
    private String idP;
    private String nameP;    //first name
    private String surnameP; //last name
    private String telP;     //telephone

    private JTextField idT;
    private JTextField nameT;
    private JTextField surnameT;
    private JTextField telT;

    //----------cחלמonstructors---------------
    public Person(String idP, String nameP, String surnameP ,String telP){
        super();
        this.idP = idP;
        this.nameP = nameP;
        this.surnameP = surnameP;
        this.telP = telP;
        // init GUI elements
        // init Title of window 
        // window size ( 220 x 450 )
    }
    //----------methods-------------------
    public boolean match(String key){
        try {
            return key.equals(this.idP) ? true: false;
        } catch (Exception e) {
            
        }
    }
    protected boolean validateData();{

    }
    protected void commit();{

    }
    protected void rollBack();{
        
    }
}