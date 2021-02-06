import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Soldier extends Person
{
    //-----------data fields-----------
    private String personalNumP;

    private JLabel asteriskPersonalNum;

    private JTextField personalNumT;
    //-----------constructors----------
    public Soldier(String idP, String nameP, String surnameP ,String telP,String personalNumP){
        super(idP,nameP,surnameP,telP);
        this.personalNumP = personalNumP;

        personalNumT = new JTextField(30);
        this.asteriskPersonalNum = new JLabel("*");
        asteriskPersonalNum.setForeground(Color.RED);

        setSize(450,220);
        setTitle("Soldier Clubber's Data");

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainGui.add(new JLabel("Soldier No"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainGui.add(personalNumT,gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        mainGui.add(asteriskPersonalNum,gbc);
        asteriskPersonalNum.setVisible(false);
        setVisible(false);
    }
    //------------methods--------------
    @Override
    public boolean match(String key)
    {
        return (super.match(key) || key.equals(this.personalNumP)) ? true : false; 
    }
    protected boolean validateData(){
        
        asteriskPersonalNum.setVisible(false);
        String personalNum = personalNumT.getText();

       boolean superCheck =  super.validateData();
       boolean personalNumCheck = personalNum.matches("[ROC][/][1-9][0-9]{6}");//TO DO
       //super - true need to check personalNumCheck
       //super - false 
       if(superCheck && !personalNumCheck) {
            asteriskPersonalNum.setVisible(true);
           }     
       

        return (superCheck && personalNumCheck);
    }
    @Override
    protected void commit(){
        super.commit();
        this.personalNumP = personalNumT.getText();
    }
    @Override
    protected void rollBack(){
        super.rollBack();
        this.personalNumT.setText(personalNumP);
    }
    @Override
    protected void showDetails(){
        super.showDetails();
        this.personalNumT.setText(personalNumP);
    }
}