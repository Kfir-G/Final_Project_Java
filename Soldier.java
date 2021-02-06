import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Soldier extends Person
{
    //-----------data fields-----------
    String personalNumP;

    private JTextField personalNumT;
    //-----------constructors----------
    public Soldier(String idP, String nameP, String surnameP ,String telP,String personalNumP){
        super(idP,nameP,surnameP,telP);
        this.personalNumP = personalNumP;

        personalNumT = new JTextField(30);
        setSize(450,220);
        setTitle("Soldier Clubber's Data");
        mainGui.add(new JLabel("Personal Number:"));
        mainGui.add(personalNumT);
        mainGui.add(new JLabel("*"));
        setVisible(true);


    }
    //------------methods--------------
    public boolean match(String key)
    {
        return (super.match(key) || key.equals(this.personalNumP)) ? true : false; 
    }
    protected boolean validateData(){
        String personalNum = personalNumT.getText();

       boolean superCheck =  super.validateData();
       boolean personalNumCheck = personalNum.matches("[R]|[O]|[C][/][1-9][0-9]{6}");//TO DO
        return (superCheck && personalNumCheck);
    }
    protected void commit(){
        super.commit();
        this.personalNumP = personalNumT.getText();
    }
    protected void rollBack(){
        super.rollBack();
        this.personalNumT.setText(personalNumP);
        }
}