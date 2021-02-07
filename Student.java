import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Student extends Person
{
    //-----------data fields--------------
    private String studentIdP;

    private JLabel asteriskStudentId;

    private JTextField studentIdT;
    //-----------constructors-------------
    public Student(String idP, String nameP, String surnameP ,String telP,String studentIdP){
        super(idP,nameP,surnameP,telP);
        this.studentIdP = studentIdP;

        studentIdT = new JTextField(30);
        this.asteriskStudentId = new JLabel("*");
        asteriskStudentId.setForeground(Color.RED);

        setSize(450,220);
        setTitle("Student Clubber's Data");

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainGui.add(new JLabel("Student ID"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainGui.add(studentIdT,gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        mainGui.add(asteriskStudentId,gbc);
        asteriskStudentId.setVisible(false);
        setVisible(false);
    }
    //------------methods-----------------
    @Override
    public boolean match(String key)
    {
        return (super.match(key) || key.substring(5).equals(this.studentIdP)) ? true : false ;
    }
    protected boolean validateData(){
        asteriskStudentId.setVisible(false);
        String studentId = studentIdT.getText();

        boolean superCheck =  super.validateData();
        boolean studentIdCheck = studentId.matches("[A-Z]{3}[/][0-9]*");

        if(!studentIdCheck && superCheck){
            asteriskStudentId.setVisible(true);
        }

        return (superCheck && studentIdCheck);
    }
    @Override
    protected void commit(){
        super.commit();
        this.studentIdP = studentIdT.getText();
    }
    @Override
    protected void rollBack(){
        super.rollBack();
        this.studentIdT.setText(studentIdP);
    }
    @Override
    protected void showDetails(){
        super.showDetails();
        this.studentIdT.setText(studentIdP);
    }
}