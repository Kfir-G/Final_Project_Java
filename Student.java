import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Student extends Person
{
    //-----------data fields--------------
    String studentIdP;

    private JTextField studentIdT;
    //-----------constructors-------------
    public Student(String idP, String nameP, String surnameP ,String telP,String studentIdP){
        super(idP,nameP,surnameP,telP);
        this.studentIdP = studentIdP;

        studentIdT = new JTextField(30);

        setSize(450,220);
        setTitle("Student Clubber's Data");

        mainGui.add(new JLabel("Student Id:"));
        mainGui.add(studentIdT);
        mainGui.add(new JLabel("*"));
        setVisible(true);
    }
    //------------methods-----------------
    public boolean match(String key)
    {
        return (super.match(key) || key.substring(5).equals(this.studentIdP)) ? true : false ;
    }
    protected boolean validateData(){
        String studentId = studentIdT.getText();

        boolean superCheck =  super.validateData();
        boolean studentIdCheck = studentId.matches("[A-Z]{3}[/][1-9][0-9]{4}");
        return (superCheck && studentIdCheck);
    }

    protected void commit(){
        super.commit();
        this.studentIdP = studentIdT.getText();
    }
    protected void rollBack(){
        super.rollBack();
        this.studentIdT.setText(studentIdP);
    }
}