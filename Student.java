import java.awt.*;
import java.util.*;
import javax.swing.*;
/**
 * Student class extends Person class 
 * Student has an adition field which is student ID
 * {@link Person}, {@link ClubAbstractEntity}
 */
public class Student extends Person
{
    //-----------data fields--------------
    private String studentIdP;

    private JLabel asteriskStudentId;

    private JTextField studentIdT;
    //-----------constructors-------------
    /**
     * 
     * @param idP
     * @param nameP
     * @param surnameP
     * @param telP
     * @param studentIdP
     */
    public Student(String idP, String nameP, String surnameP ,String telP,String studentIdP){
        super(idP,nameP,surnameP,telP);
        this.studentIdP = studentIdP;

        studentIdT = new JTextField(30);
        this.asteriskStudentId = new JLabel("*");
        asteriskStudentId.setForeground(Color.RED);

        setSize(450,220);
        setTitle("Student Clubber's Data");

        //sets grid corrdinate each grid
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
    /** 
     * match method is equals the ID or student ID
     * {@link Person#match}
     * @param key String type is the user input
     * @return boolean return true if it's equal and return false else to the ID or student ID
     */
    @Override
    public boolean match(String key)
    {
        return (super.match(key) || key.substring(5).equals(this.studentIdP)) ? true : false ;
    }
    /** 
     * validateData method check if the user input is valid
     * {@link Person#validateData}
     * @return boolean return true if the input is valid and false else
     */
    @Override
    protected boolean validateData(){
        asteriskStudentId.setVisible(false);

        boolean superCheck =  super.validateData();
        boolean studentIdCheck = studentIdT.getText().matches("[A-Z]{3}[/][0-9]*");

        if(!studentIdCheck && superCheck){
            asteriskStudentId.setVisible(true);
        }

        return (superCheck && studentIdCheck);
    }
    /**
     * commit method insert the user input to the class class data fields
     * {@link Person#commit}
     */
    @Override
    protected void commit(){
        super.commit();
        this.studentIdP = studentIdT.getText();
    }
    /**
     * rollBack method set the texts that was before and hide all the Asterisks
     * {@link Person#rollBack}
     */
    @Override
    protected void rollBack(){
        super.rollBack();
        this.studentIdT.setText(studentIdP);
    }
    /**
     * showDetails method show the details of the entity
     * {@link Person#showDetails}
     */
    @Override
    protected void showDetails(){
        super.showDetails();
        this.studentIdT.setText(studentIdP);
    }
}